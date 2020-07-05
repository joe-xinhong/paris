package com.commune.paris.mapper;

import com.commune.paris.entity.POrderDetail;
import com.commune.paris.entity.POrderDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface POrderDetailMapper {
    long countByExample(POrderDetailExample example);

    int deleteByExample(POrderDetailExample example);

    int insert(POrderDetail record);

    int insertSelective(POrderDetail record);

    List<POrderDetail> selectByExample(POrderDetailExample example);

    int updateByExampleSelective(@Param("record") POrderDetail record, @Param("example") POrderDetailExample example);

    int updateByExample(@Param("record") POrderDetail record, @Param("example") POrderDetailExample example);

    int deleteByOrderId(@Param("orderId")String orderId);

    Integer countGoodsAll(@Param("goodsId")Integer goodsId);
}