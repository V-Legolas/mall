package com.mardoner.mall.admin.mapper.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mardoner.mall.admin.entity.pms.ProductVerifyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description:  商品审核记录
* @className: ProductVerifyRecordMapper
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/25 20:40
* @version 1.0
*/
public interface ProductVerifyRecordMapper extends BaseMapper<ProductVerifyRecord> {

    int insertList(@Param("list")List<ProductVerifyRecord> dataList);
}
