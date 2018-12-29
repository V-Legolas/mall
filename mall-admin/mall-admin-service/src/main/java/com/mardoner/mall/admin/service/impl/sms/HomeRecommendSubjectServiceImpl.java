package com.mardoner.mall.admin.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.sms.HomeRecommendSubject;
import com.mardoner.mall.admin.enums.OrderEnums;
import com.mardoner.mall.admin.mapper.sms.HomeRecommendSubjectMapper;
import com.mardoner.mall.admin.service.sms.HomeRecommendSubjectService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
* @description:  主页推荐主题
* @className: HomeRecommendSubjectServiceImpl
* @author whuan-QQ:2500129268
* @email: mardoner12p@gmail.com
* @date 2018/12/29 19:16
* @version 1.0
*/
@Service
public class HomeRecommendSubjectServiceImpl implements HomeRecommendSubjectService {

    @Resource(name = "homeRecommendSubjectMapper")
    private HomeRecommendSubjectMapper subjectMapper;

    @Override
    public int create(List<HomeRecommendSubject> subjectList) {
        subjectList.forEach(subject -> {
           subject.setRecommendStatus(OrderEnums.USE.getCode());
           subject.setSort(0);
        });
        return subjectMapper.insertList(subjectList);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return subjectMapper.deleteBatchIds(ids);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        HomeRecommendSubject subject = new HomeRecommendSubject();
        subject.setId(id);
        subject.setSort(sort);
        return subjectMapper.updateById(subject);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        HomeRecommendSubject setEntity = new HomeRecommendSubject();
        setEntity.setRecommendStatus(recommendStatus);
        UpdateWrapper<HomeRecommendSubject> wrapper =
                new UpdateWrapper<>();
        wrapper.in("id",ids);
        return subjectMapper.update(setEntity,wrapper);
    }

    @Override
    public IPage<HomeRecommendSubject> list(String productName, Integer recommendStatus,
                                            Integer current, Integer limit) {
        IPage<HomeRecommendSubject> page = new Page<>(current,limit);
        QueryWrapper<HomeRecommendSubject> wrapper = new QueryWrapper<>();
        if(recommendStatus != null){
            wrapper.eq("recommend_status",recommendStatus);
        }
        if(!StringUtils.isEmpty(productName)){
            wrapper.like("product_name",productName);
        }
        return subjectMapper.selectPage(page, wrapper);
    }
}
