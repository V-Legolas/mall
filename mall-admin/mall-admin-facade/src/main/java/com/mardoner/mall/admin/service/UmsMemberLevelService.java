package com.mardoner.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mardoner.mall.admin.entity.UmsMemberLevel;

import java.util.List;

/**
* @Description: 后台会员等级管理 逻辑层接口
* @ClassName: UmsMemberLevelService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/18 19:54
* @Version 1.0
*/
public interface UmsMemberLevelService extends IService<UmsMemberLevel> {

    /**
     * 获取所有会员登录
     * @param defaultStatus 是否为默认会员
     * @return 所有登录会员
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}
