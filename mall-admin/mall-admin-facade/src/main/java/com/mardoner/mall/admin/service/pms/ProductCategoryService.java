package com.mardoner.mall.admin.service.pms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.pms.ProductCategory;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductCategoryParam;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductCategoryWithChildren;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description:  商品分类 service
* @ClassName: ProductCategoryService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 11:38
* @Version 1.0
*/
public interface ProductCategoryService {
    @Transactional
    int create(PmsProductCategoryParam param);

    @Transactional
    int update(Long id, PmsProductCategoryParam param);

    int delete(Long id);

    ProductCategory getById(Long id);

    /**
     * 根据父类id及分页信息筛选
     * @param parentId 父类id
     * @param current 当前页
     * @param limit 每页记录数
     * @return 符合条件集合记录
     */
    IPage<ProductCategory> list(Long parentId, int current,
                                int limit);

    /**
     * 批量更新导航栏显示状态
     * @param ids 商品分类id集合
     * @param navStatus 是否在导航栏显示
     * @return 操作影响记录数
     */
    int updateNavStatus(List<Long> ids, int navStatus);

    int updateShowStatus(List<Long> ids,int showStatus);

    /**
     * 层级结构返回所有分类
     * @return 层级结构的商品分类
     */
    List<PmsProductCategoryWithChildren> listWithChildren();
}
