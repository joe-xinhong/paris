package com.commune.paris.mapper;

import com.commune.paris.entity.PLogistics;
import com.commune.paris.entity.PLogisticsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PLogisticsMapper {
    long countByExample(PLogisticsExample example);

    int deleteByExample(PLogisticsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PLogistics record);

    int insertSelective(PLogistics record);

    List<PLogistics> selectByExample(PLogisticsExample example);

    PLogistics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PLogistics record, @Param("example") PLogisticsExample example);

    int updateByExample(@Param("record") PLogistics record, @Param("example") PLogisticsExample example);

    int updateByPrimaryKeySelective(PLogistics record);

    int updateByPrimaryKey(PLogistics record);

    int deleteByOrderId(@Param("orderId")String orderId);
}