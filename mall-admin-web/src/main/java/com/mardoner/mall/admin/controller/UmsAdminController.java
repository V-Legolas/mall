package com.mardoner.mall.admin.controller;

import com.mardoner.mall.admin.common.base.IController;
import com.mardoner.mall.admin.common.enums.AdminResult;
import com.mardoner.mall.admin.common.enums.CommonReturnCode;
import com.mardoner.mall.admin.common.enums.UserReturnCode;
import com.mardoner.mall.admin.entity.ums.UmsAdmin;
import com.mardoner.mall.admin.entity.ums.UmsPermission;
import com.mardoner.mall.admin.entity.ums.UmsRole;
import com.mardoner.mall.admin.pojo.dto.param.UmsAdminLoginParam;
import com.mardoner.mall.admin.pojo.dto.param.UmsAdminRegisterParam;
import com.mardoner.mall.admin.service.ums.UmsAdminService;
import com.mardoner.mall.admin.service.ums.UmsPermissionService;
import com.mardoner.mall.admin.util.SingletonLoginUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    @Resource(name = "umsPermissionServiceImpl")
    private UmsPermissionService permissionService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public Object register(@RequestBody @Valid UmsAdminRegisterParam param, BindingResult result){
        if(result.hasErrors()){
            // 先进行参数校验失败
            return new AdminResult(result);
        }

        boolean registerResult = false;
        try{
            registerResult = adminService.register(param);
        }catch(AccountException e){
            // 账户已经存在
            LOGGER.warn(e.getMessage());
            return new AdminResult(UserReturnCode.ACCOUNT_USED);
        }

        if(!registerResult){
            // 注册失败，其它错误
            return new AdminResult(CommonReturnCode.UNKOWN);
        }
        return new AdminResult(CommonReturnCode.SUCCESS);
    }


    // TODO 暂未加入验证码
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public AdminResult login(@RequestBody @Valid UmsAdminLoginParam param, BindingResult result){
        if(result.hasErrors()){
            return new AdminResult(result);
        }
        try{
            boolean isSuccess = adminService.login(param.getUsername(),param.getPassword());

            return new AdminResult(CommonReturnCode.SUCCESS);
        }catch(BadCredentialsException passwordError){
            LOGGER.info("AdminLogin.login()",passwordError);
            return new AdminResult(UserReturnCode.WRONG_PASSWORD);
        }catch(UsernameNotFoundException notFound){
            LOGGER.info("AdminLogin.login()",notFound);
            return new AdminResult(UserReturnCode.USER_NOT_EXIST);
        }catch(RuntimeException e){
            LOGGER.info("AdminLogin.login()",e);
            return new AdminResult(CommonReturnCode.UNKOWN);
        }
    }

    @ApiOperation("用户登出")
    @PostMapping("/logout")
    public AdminResult logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();       // 清空上下文
        if(session != null){
            session.invalidate();               // 清空session
        }
        return new AdminResult(CommonReturnCode.SUCCESS.getCode(),"退出登录成功！");
    }

    @ApiOperation("当前用户信息")
    @GetMapping(value = "/info")
    public AdminResult getAdminInfo(){
        String username;
        try{
            username = SingletonLoginUtils.getUser().getUsername();
        }catch (ProviderNotFoundException e){
            // 用户未登录
            LOGGER.info("UmsAdminController.getAdminInfo()" + e.getMessage());
            return new AdminResult(UserReturnCode.UNAUTHORIZED);
        }
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        List<String> roles = adminService.getRoleList(umsAdmin.getId()).stream()
                .map(role -> role.getName()).collect(Collectors.toList());
        Map<String,Object> data = new HashMap<>();
        data.put("username",username);
        data.put("roles",roles);
        data.put("icon",umsAdmin.getIcon());
        return new AdminResult(CommonReturnCode.SUCCESS,data);
    }

    @ApiOperation("根据用户名或者姓名分页获取用户列表")
    @GetMapping("/list")
    public AdminResult list(@RequestParam(value="name",required = false) String name,
                            @RequestParam(value = "limit",defaultValue = "5") Integer limit,
                            @RequestParam(value = "index",defaultValue = "1") Integer index){
        List<UmsAdmin> adminList = adminService.listByPage(name, index, limit);
        return new AdminResult(CommonReturnCode.SUCCESS,adminList);
    }

    @ApiOperation("获取指定用户信息")
    @GetMapping("/{id}")
    public AdminResult getAdminById(@PathVariable Long id){
        UmsAdmin admin = adminService.getById(id);
        return new AdminResult(CommonReturnCode.SUCCESS,admin);
    }

    @ApiOperation("更新指定用户")
    @PutMapping("/update/{id}")
    public AdminResult update(@PathVariable Long id, @RequestBody UmsAdmin umsAdmin){
        umsAdmin.setId(id);
        boolean isSuccess = adminService.updateById(umsAdmin);
        return getAdminResult(isSuccess);
    }

    @ApiOperation("删除指定用户")
    @DeleteMapping("/delete/{id}")
    public AdminResult delete(@PathVariable Long id){
        boolean isOk = adminService.removeById(id);
        return getAdminResult(isOk);
    }

    @ApiOperation("给客户分配角色")
    @PutMapping("/role/update")
    public AdminResult updateRole(@RequestParam("adminId") Long adminId,
                           @RequestParam("roleIds") List<Long> ids){
        int count = adminService.updateRole(adminId,ids);
        return getAdminResult(count >= 0);
    }

    @ApiOperation("获取指定用户权限")
    @GetMapping("/role/{adminId}")
    public AdminResult getRolesById(@PathVariable("adminId") Long adminId){
        List<UmsRole> roleList = adminService.getRoleList(adminId);
        return new AdminResult(CommonReturnCode.SUCCESS,roleList);
    }

    @ApiOperation("给用户分配+-权限")
    @PutMapping("/permission/update")
    public AdminResult updatePermissions(@RequestParam("adminId")Long adminId,
                                         @RequestParam("permissionIds")List<Long> permissionIds){
        int count = adminService.updatePermission(adminId,permissionIds);
        return getAdminResult(count >= 0);
    }

    @ApiOperation("获取用户所有权限")
    @GetMapping("/permission/{adminId}")
    public AdminResult getAllPermissions(@PathVariable("adminId")Long adminId){
        List<UmsPermission> permissions = adminService.getPermissionList(adminId);
        return new AdminResult(CommonReturnCode.SUCCESS,permissions);
    }
}

