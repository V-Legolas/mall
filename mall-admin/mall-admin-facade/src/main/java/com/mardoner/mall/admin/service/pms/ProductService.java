package com.mardoner.mall.admin.service.pms;

import com.mardoner.mall.admin.entity.pms.Product;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductParam;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductQueryParam;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description:  商品管理service
* @ClassName: ProductService
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/23 13:59
* @Version 1.0
*/
public interface ProductService {
    @Transactional
    Integer create(PmsProductParam param);

    PmsProductResult getDetail(Long id);

    @Transactional
    Integer update(Long id, PmsProductParam param);

    /**
     * 分页查询
     * @param param 查询条件
     * @param current 当前页
     * @param limit 每页记录数
     * @return 符合条件的商品集合
     */
    List<Product> listPage(PmsProductQueryParam param,Integer current, Integer limit);

    /**
     * 批量修改审核状态
     * @param ids 商品id集合
     * @param verifyStatus 审核状态
     * @param detail 审核详情
     * @return 操作影响记录数
     */
    @Transactional
    Integer updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 批量修改上架状态
    * @param ids 产品id集合
    * @param publishStatus 上架状态
    * @return 操作成功影响记录数
     */
    Integer updatePublishStatus(List<Long> ids, Integer publishStatus);
    
    /**
     * 批量修改商品推荐状态
    * @param ids 商品id集合
    * @param recommendStatus 推荐状态
    * @return
     */
    Integer updateRecommendStatus(List<Long> ids, Integer recommendStatus);
    
    /**
     * 批量修改商品新品状态
    * @param ids 商品id集合
    * @param newStatus 新品状态
    * @return 操作影响记录数
     */
    Integer updateNewStatus(List<Long> ids, Integer newStatus);
    
    /**
     * 批量删除商品（逻辑删除)
    * @param ids 商品id集合
    * @param deleteStatus 删除状态
    * @return 成功记录数
     */
    Integer updateDeleteStatus(List<Long> ids, Integer deleteStatus);
    
    /**
     * 根据商品名称或者货编号模糊查询
    * @param keywords 名称或者编号关键字
    * @return 符合条件集合
     */
    List<Product> list(String keywords);
}
