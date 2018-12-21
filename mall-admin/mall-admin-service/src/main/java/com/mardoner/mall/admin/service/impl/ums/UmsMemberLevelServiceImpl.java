package com.mardoner.mall.admin.service.impl.ums;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mardoner.mall.admin.entity.ums.UmsMemberLevel;
import com.mardoner.mall.admin.mapper.ums.UmsMemberLevelMapper;
import com.mardoner.mall.admin.service.ums.UmsMemberLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: 会员 等级 业务逻辑管理
* @ClassName: UmsMemberLevelServiceImpl
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/19 13:39
* @Version 1.0
*/
@Service
public class UmsMemberLevelServiceImpl extends ServiceImpl<UmsMemberLevelMapper, UmsMemberLevel>
    implements UmsMemberLevelService {

    @Resource(name = "umsMemberLevelMapper")
    private UmsMemberLevelMapper memberLevelMapper;

    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevel query = new UmsMemberLevel();
        query.setDefaultStatus(defaultStatus);
        return memberLevelMapper.selectList(new QueryWrapper<>(query));
    }
}
