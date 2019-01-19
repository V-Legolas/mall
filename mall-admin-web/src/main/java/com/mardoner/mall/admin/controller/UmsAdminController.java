package com.mardoner.mall.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.util.SingletonLoginUtils;
import com.mardoner.mall.admin.entity.ums.UmsAdmin;
import com.mardoner.mall.admin.entity.ums.UmsPermission;
import com.mardoner.mall.admin.entity.ums.UmsRole;
import com.mardoner.mall.admin.pojo.dto.param.UmsAdminLoginParam;
import com.mardoner.mall.admin.pojo.dto.param.UmsAdminRegisterParam;
import com.mardoner.mall.admin.results.CommonResult;
import com.mardoner.mall.admin.results.CommonReturnCode;
import com.mardoner.mall.admin.results.UserReturnCode;
import com.mardoner.mall.admin.service.ums.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @Description: 后台用户管理
* @ClassName: UmsAdminController
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/19 21:21
* @Version 1.0
*/
@RestController
@Api(tags = "UmsAdminController" , description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController implements IController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminController.class);

    @Resource(name = "umsAdminServiceImpl")
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public Object register(@RequestBody @Validated UmsAdminRegisterParam param, BindingResult result){
        boolean registerResult = false;
        try{
            registerResult = adminService.register(param);
        }catch(AccountException e){
            // 账户已经存在
            LOGGER.warn(e.getMessage());
            return new CommonResult(UserReturnCode.ACCOUNT_USED);
        }
        if(!registerResult){
            // 注册失败，其它错误
            return new CommonResult(CommonReturnCode.UNKNOWN);
        }
        return new CommonResult(CommonReturnCode.SUCCESS);
    }


    // 后台登录不加入验证码
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public CommonResult login(@RequestBody @Validated UmsAdminLoginParam param, BindingResult result){
        try{
            String token = adminService.login(param.getUsername(),param.getPassword());
            if(token == null){
                return new CommonResult(UserReturnCode.VALIDATE_ERROR);
            }
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);
            tokenMap.put("tokenHead", tokenHead);
            return new CommonResult(CommonReturnCode.SUCCESS, tokenMap);
        }catch(BadCredentialsException passwordError){
            LOGGER.info("AdminLogin.login()",passwordError);
            return new CommonResult(UserReturnCode.WRONG_PASSWORD);
        }catch(UsernameNotFoundException notFound){
            LOGGER.info("AdminLogin.login()",notFound);
            return new CommonResult(UserReturnCode.USER_NOT_EXIST);
        }catch(RuntimeException e){
            LOGGER.info("AdminLogin.login()",e);
            return new CommonResult(CommonReturnCode.UNKNOWN);
        }
    }

    // 刷新token
    @ApiOperation("刷新token")
    @GetMapping("/token/refresh")
    public CommonResult refreshToken(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if(refreshToken == null){
            return new CommonResult(CommonReturnCode.FAILED);
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return new CommonResult(CommonReturnCode.SUCCESS, tokenMap);
    }


    @ApiOperation("用户登出")
    @PostMapping("/logout")
    public CommonResult logout(HttpServletRequest request){
        SecurityContextHolder.clearContext();       // 清空上下文
        // 由于基于token，所以其实后端无需做任何操作，只需前端清除保存的token即可
        return new CommonResult(CommonReturnCode.SUCCESS.getCode(),"退出登录成功！");
    }

    @ApiOperation("当前用户信息")
    @GetMapping(value = "/info")
    public CommonResult getAdminInfo(){
        String username = SingletonLoginUtils.getUser().getUsername();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        List<String> roles = adminService.getRoleList(umsAdmin.getId()).stream()
                .map(role -> role.getName()).collect(Collectors.toList());
        Map<String,Object> data = new HashMap<>();
        data.put("username",username);
        data.put("roles",roles);
        data.put("icon",umsAdmin.getIcon());
        return new CommonResult(CommonReturnCode.SUCCESS,data);
    }

    @ApiOperation("根据用户名或者姓名分页获取用户列表")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value="name",required = false) String name,
                             @RequestParam(value = "pageSize",defaultValue = "5") Integer limit,
                             @RequestParam(value = "pageNum",defaultValue = "1") Integer index){
        IPage<UmsAdmin> page = adminService.listByPage(name, index, limit);
        return new CommonResult(page);
    }

    @ApiOperation("获取指定用户信息")
    @GetMapping("/{id}")
    public CommonResult getAdminById(@PathVariable Long id){
        UmsAdmin admin = adminService.getById(id);
        return new CommonResult(CommonReturnCode.SUCCESS,admin);
    }

    @ApiOperation("更新指定用户")
    @PutMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody UmsAdmin umsAdmin){
        umsAdmin.setId(id);
        boolean isSuccess = adminService.updateById(umsAdmin);
        return getResult(isSuccess);
    }

    @ApiOperation("删除指定用户")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id){
        boolean isOk = adminService.removeById(id);
        return getResult(isOk);
    }

    @ApiOperation("给客户分配角色")
    @PutMapping("/role/update")
    public CommonResult updateRole(@RequestParam("adminId") Long adminId,
                                   @RequestParam("roleIds") List<Long> ids){
        int count = adminService.updateRole(adminId,ids);
        return getResult(count);
    }

    @ApiOperation("获取指定用户权限")
    @GetMapping("/role/{adminId}")
    public CommonResult getRolesById(@PathVariable("adminId") Long adminId){
        List<UmsRole> roleList = adminService.getRoleList(adminId);
        return new CommonResult(CommonReturnCode.SUCCESS,roleList);
    }

    @ApiOperation("给用户分配+-权限")
    @PutMapping("/permission/update")
    public CommonResult updatePermissions(@RequestParam("adminId")Long adminId,
                                          @RequestParam("permissionIds")List<Long> permissionIds){
        int count = adminService.updatePermission(adminId,permissionIds);
        return getResult(count >= 0);
    }

    @ApiOperation("获取用户所有权限")
    @GetMapping("/permission/{adminId}")
    public CommonResult getAllPermissions(@PathVariable("adminId")Long adminId){
        List<UmsPermission> permissions = adminService.getPermissionList(adminId);
        return new CommonResult(CommonReturnCode.SUCCESS,permissions);
    }
}

