package com.commune.paris.mapper;

import com.commune.paris.entity.PAttributeValue;
import com.commune.paris.entity.PAttributeValueExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PAttributeValueMapper {
    long countByExample(PAttributeValueExample example);

    int deleteByExample(PAttributeValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PAttributeValue record);

    int insertSelective(PAttributeValue record);

    List<PAttributeValue> selectByExample(PAttributeValueExample example);

    PAttributeValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PAttributeValue record, @Param("example") PAttributeValueExample example);

    int updateByExample(@Param("record") PAttributeValue record, @Param("example") PAttributeValueExample example);

    int updateByPrimaryKeySelective(PAttributeValue record);

    int updateByPrimaryKey(PAttributeValue record);
}