package com.mardoner.mall.admin.service.pms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.pms.ProductAttribute;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductAttributeParam;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductAttrInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description:  商品属性
* @ClassName: ProductAttributeService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 11:03
* @Version 1.0
*/
public interface ProductAttributeService {

    /**
     * 根据分类分页获取商品属性
     * @param cid 分类id
     * @param type 属性分类 ：0-规格 1-参数
     * @param current 分页当前页
     * @param limit 每页显示记录数
     * @return 商品属性集合以及分页信息
     */
    IPage<ProductAttribute> listPage(Long cid, Integer type,
                                     Integer current, Integer limit);

    /**
     * 根据参数创建商品属性
     * @param param 属性入参
     * @return 操作影响记录数
     */
    @Transactional
    Integer create(PmsProductAttributeParam param);

    /**
     * 修改商品属性
     * @param id 商品属性id
     * @param param 属性参数
     * @return 操作影响记录数
     */
    @Transactional
    Integer update(Long id, PmsProductAttributeParam param);

    ProductAttribute getById(Long id);

    /**
     * 批量删除商品id属性集合（同一属性类型之下，即productAttributeCategoryId相同）
     * @param ids 属性集合
     * @return 操作影响记录数
     */
    @Transactional
    Integer delete(List<Long> ids);

    /**
     * 获取分类对应属性信息
     * @param productCategoryId 分类id
     * @return 属性信息
     */
    List<PmsProductAttrInfo> getAttrInfo(Long productCategoryId);
}
