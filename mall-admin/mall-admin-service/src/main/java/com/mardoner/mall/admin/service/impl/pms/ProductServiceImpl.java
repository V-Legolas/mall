package com.mardoner.mall.admin.service.impl.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.Product;
import com.mardoner.mall.admin.entity.pms.SkuStock;
import com.mardoner.mall.admin.mapper.cms.PreferenceAreaProductRelationMapper;
import com.mardoner.mall.admin.mapper.cms.SubjectProductRelationMapper;
import com.mardoner.mall.admin.mapper.pms.*;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductParam;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductQueryParam;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductResult;
import com.mardoner.mall.admin.service.pms.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource(name = "productMapper")
    private ProductMapper productMapper;
    @Resource(name = "productLadderMapper")
    private ProductLadderMapper ladderMapper;
    @Resource(name = "memberPriceMapper")
    private MemberPriceMapper memberPriceMapper;
    @Resource(name = "productFullReductionMapper")
    private ProductFullReductionMapper fullReductionMapper;
    @Resource(name = "skuStockMapper")
    private SkuStockMapper stockMapper;
    @Resource(name = "productAttributeValueMapper")
    private ProductAttributeValueMapper attributeValueMapper;
    @Resource(name = "subjectProductRelationMapper")
    private SubjectProductRelationMapper subjectProductRelationMapper;
    @Resource(name = "preferenceAreaProductRelationMapper")
    private PreferenceAreaProductRelationMapper preferenceAreaRelationMapper;

    @Override
    public Integer create(PmsProductParam param) {
        // 创建商品
        Product product = new Product();
        BeanUtils.copyProperties(param, product);
        int count = productMapper.insert(product);

        // 根据促销类型设置价格：阶梯价格、满减价格等其他关联信息
        Long productId = product.getId();
        // 阶梯价格
        relatedAndInsertList(ladderMapper, param.getProductLadderList(), productId);
        // 会员价
        relatedAndInsertList(memberPriceMapper, param.getMemberPriceList(), productId);
        // 满减价
        relatedAndInsertList(fullReductionMapper, param.getFullReductionList() , productId);
        // 处理sku编码问题
        handleSkuStockCode(param.getSkuStockList(), productId);
        // 添加sku库存
        relatedAndInsertList(stockMapper, param.getSkuStockList(), productId);
        // 添加商品参数信息，添加自定义商品规格
        relatedAndInsertList(attributeValueMapper, param.getAttributeValueList(), productId);
        // 关联专题
        relatedAndInsertList(subjectProductRelationMapper, param.getSubjectProductRelationList(), productId);
        // 关联优选
        relatedAndInsertList(preferenceAreaRelationMapper, param.getPreferenceAreaProductRelationList(),
                productId);

        return count;
    }

    private void handleSkuStockCode(List<SkuStock> skuStockList, Long productId) {
        if(CollectionUtils.isEmpty(skuStockList))return;
        for(int i = 0,len = skuStockList.size();i < len;i++){
            SkuStock skuStock = skuStockList.get(i);
            if(skuStock.getSkuCode().isEmpty()){
                StringBuilder skuCode = new StringBuilder();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                // 日期
                skuCode.append(dateFormat.format(new Date()));
                // 四位货品id
                skuCode.append(String.format("%04d",productId));
                // 三位索引id
                skuCode.append(String.format("%03d",i+1));
                skuStock.setSkuCode(skuCode.toString());
            }
        }
    }

    @Override
    public PmsProductResult getDetail(Long id) {
        return null;
    }

    @Override
    public Integer update(Long id, PmsProductParam param) {
        return null;
    }

    @Override
    public List<Product> listPage(PmsProductQueryParam param, Integer current, Integer limit) {
        return null;
    }

    @Override
    public Integer updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        return null;
    }

    @Override
    public Integer updatePublishStatus(List<Long> ids, Integer publishStatus) {
        return null;
    }

    @Override
    public Integer updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return null;
    }

    @Override
    public Integer updateNewStatus(List<Long> ids, Integer newStatus) {
        return null;
    }

    @Override
    public Integer updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        return null;
    }

    @Override
    public List<Product> list(String keywords) {
        return null;
    }

    private void relatedAndInsertList(BaseMapper<?> mapper, List<?> dataList, Long productId) {
        if(CollectionUtils.isEmpty(dataList)) return;
        try{
            for(Object item : dataList){
                Class<?> clazz = item.getClass();
                Method setProductId = clazz.getMethod("setProductId",Long.class);
                setProductId.invoke(item,productId);
            }
            Method insertList = mapper.getClass().getMethod("insertList", List.class);
            insertList.invoke(mapper,dataList);
        }catch (Exception e){
            LOGGER.warn("ProductServiceImpl.create()出错：" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
}
