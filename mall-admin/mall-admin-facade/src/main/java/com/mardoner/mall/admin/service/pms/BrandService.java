package com.mardoner.mall.admin.service.pms;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mardoner.mall.admin.entity.pms.Brand;
import com.mardoner.mall.admin.pojo.dto.param.PmsBrandParam;

/**
* @Description:  商品品牌service
* @ClassName: BrandService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 9:47
* @Version 1.0
*/
public interface BrandService {

    /**
     * 列举所有品牌
     * @return 所有品牌集合
     */
    List<Brand> list();

    /**
     * 插入新的品牌
     * @param param 品牌入参
     * @return 操作影响记录数
     */
    Integer createBrand(PmsBrandParam param);

    /**
     * 更新品牌信息
    * @param id 品牌id
    * @return 操作影响记录数
     */
    @Transactional
    Integer updateBrand(Long id, PmsBrandParam param);
    
    /**
     * 根据id删除一条记录
     * @param id 品牌id
     * @return  操作影响记录数
     */
    Integer delete(Long id);

    /**
     * 批量删除品牌记录
     * @param ids 品牌id集合
     * @return 操作影响记录数
     */
    Integer deleteList(List<Long> ids);

    /**
     * 根据id获取单条记录
     * @param id 品牌id
     * @return 单条记录实体
     */
    Brand getById(Long id);

    /**
     * 根据分页及条件查询
     * @param keyword 模糊查询条件（品牌名称）
     * @param current 当前页
     * @param size 每页显示记录数
     * @return 符合条件记录集合以及分页信息
     */
    IPage<Brand> listPage(String keyword, int current,int size);

    /**
     * 批量更新厂家状态
     * @param ids 品牌id集合
     * @param factoryStatus 厂家状态
     * @return 操作影响记录数
     */
    @Transactional
    Integer updateFactoryStatus(List<Long> ids, Integer factoryStatus);

    /**
     * 批量更新显示状态
     * @param ids 品牌id集合
     * @param showStatus 显示状态
     * @return 操作影响记录数
     */
    @Transactional
    Integer updateShowStatus(List<Long> ids, Integer showStatus);
}
