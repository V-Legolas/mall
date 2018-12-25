package com.mardoner.mall.admin.service.impl.pms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mardoner.mall.admin.entity.cms.CmsPreferenceAreaProductRelation;
import com.mardoner.mall.admin.entity.cms.CmsSubjectProductRelation;
import com.mardoner.mall.admin.entity.pms.*;
import com.mardoner.mall.admin.enums.StatusEnum;
import com.mardoner.mall.admin.mapper.cms.PreferenceAreaProductRelationMapper;
import com.mardoner.mall.admin.mapper.cms.SubjectProductRelationMapper;
import com.mardoner.mall.admin.mapper.pms.*;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductParam;
import com.mardoner.mall.admin.pojo.dto.param.PmsProductQueryParam;
import com.mardoner.mall.admin.pojo.dto.vo.PmsProductResult;
import com.mardoner.mall.admin.service.pms.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource(name = "productVerifyRecordMapper")
    private ProductVerifyRecordMapper verifyRecordMapper;
    @Resource(name = "subjectProductRelationMapper")
    private SubjectProductRelationMapper subjectProductRelationMapper;
    @Resource(name = "preferenceAreaProductRelationMapper")
    private PreferenceAreaProductRelationMapper preferenceAreaRelationMapper;

    @Override
    public int create(PmsProductParam param) {
        // 创建商品
        Product product = param;
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
        return productMapper.detailInfo(id);
    }

    @Override
    public int update(Long id, PmsProductParam param) {
        Product product = param;
        product.setId(id);
        // 更新商品信息
        int count = productMapper.updateById(product);

        // 更新关联信息, 都是先删除再添加实现更新操作
        // 会员价格
        QueryWrapper<MemberPrice> memberWrapper = new QueryWrapper<>();
        memberWrapper.eq("product_id",id);
        memberPriceMapper.delete(memberWrapper);
        relatedAndInsertList(memberPriceMapper, param.getMemberPriceList(), id);
        // 阶梯价格
        QueryWrapper<ProductLadder> ladderWrapper = new QueryWrapper<>();
        ladderWrapper.eq("product_id",id);
        ladderMapper.delete(ladderWrapper);
        relatedAndInsertList(ladderMapper, param.getProductLadderList(), id);
        // 满减价格
        QueryWrapper<ProductFullReduction> fullWrapper = new QueryWrapper<>();
        fullWrapper.eq("product_id",id);
        fullReductionMapper.delete(fullWrapper);
        relatedAndInsertList(fullReductionMapper, param.getFullReductionList(), id);
        // 库存信息
        QueryWrapper<SkuStock> stockWrapper = new QueryWrapper<>();
        stockWrapper.eq("product_id",id);
        stockMapper.delete(stockWrapper);
        relatedAndInsertList(stockMapper, param.getSkuStockList(), id);
        // 商品参数，自定义商品规格
        QueryWrapper<ProductAttributeValue> attributeWrapper = new QueryWrapper<>();
        attributeWrapper.eq("product_id",id);
        attributeValueMapper.delete(attributeWrapper);
        relatedAndInsertList(attributeValueMapper, param.getAttributeValueList() ,id);
        // 关联专题
        QueryWrapper<CmsSubjectProductRelation> subjectWrapper = new QueryWrapper<>();
        subjectWrapper.eq("product_id",id);
        subjectProductRelationMapper.delete(subjectWrapper);
        relatedAndInsertList(subjectProductRelationMapper,param.getSubjectProductRelationList(),id);
        // 关联优选
        QueryWrapper<CmsPreferenceAreaProductRelation> preferenceAreaWrapper =
                new QueryWrapper<>();
        preferenceAreaWrapper.eq("productId",id);
        preferenceAreaRelationMapper.delete(preferenceAreaWrapper);
        relatedAndInsertList(preferenceAreaRelationMapper, param.getPreferenceAreaProductRelationList(), id);

        return count;
    }

    @Override
    public IPage<Product> listPage(PmsProductQueryParam param, Integer current, Integer limit) {
        IPage<Product> page = new Page<>(current,limit);
        // 查询条件， 为 null 默认都符合
        Product product = new Product();
        product.setPublishStatus(param.getPublishStatus());
        product.setVerifyStatus(param.getVerifyStatus());
        product.setProductCategoryId(param.getProductCategoryId());
        product.setProductSn(param.getProductSn());
        product.setBrandId(param.getBrandId());
        product.setDeleteStatus(StatusEnum.NOT_LOGIC_DELETE.getCode()); // 未被逻辑删除

        QueryWrapper<Product> wrapper = new QueryWrapper<>(product);
        // 模糊查询
        if(!StringUtils.isEmpty(param.getKeyword())){
            wrapper.like("name",param.getKeyword());
        }
        wrapper.orderByDesc("sort");

        return productMapper.selectPage(page,wrapper);
    }

    @Override
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail, String verifyMan) {
        int count =
                updateStatus(ids, verifyStatus, "setVerifyStatus");
        // 插入审核记录
        List<ProductVerifyRecord> records = ids.stream().map(id -> {
            ProductVerifyRecord record = new ProductVerifyRecord();
            record.setProductId(id);
            record.setCreateTime(new Date());
            record.setVerifyMan(verifyMan);
            record.setStatus(verifyStatus);
            record.setDetail(detail);
            return record;
        }).collect(Collectors.toList());
        verifyRecordMapper.insertList(records);

        return count;
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        return updateStatus(ids, publishStatus, "setPublishStatus");
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return updateStatus(ids, recommendStatus, "setRecommendStatus");
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        return updateStatus(ids, newStatus,"setNewStatus");
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        return updateStatus(ids, deleteStatus, "setDeleteStatus");
    }

    @Override
    public List<Product> list(String keywords) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        // 未被逻辑删除
        wrapper.eq("delete_status",StatusEnum.NOT_LOGIC_DELETE.getCode());
        if(!StringUtils.isEmpty(keywords)){
            wrapper.like("name",keywords).or().like("product_sn",keywords);
        }
        return productMapper.selectList(wrapper);
    }

    private int updateStatus(List<Long> ids, Integer status, String productSetMethodName) {
        Product product = new Product();
        try {
            Method method = product.getClass().getMethod(productSetMethodName,Integer.class);
            method.invoke(product,status);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            LOGGER.warn("productServiceImpl.update" + productSetMethodName.replace("set",""),e);
            // 抛出运行异常, 数据库保存失败
            throw new RuntimeException(e.getMessage());
        }
        UpdateWrapper<Product> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        return productMapper.update(product,wrapper);
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
