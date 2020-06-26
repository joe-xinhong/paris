package com.commune.paris.mapper;

import com.commune.paris.entity.PAttribute;
import com.commune.paris.entity.PAttributeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PAttributeMapper {
    long countByExample(PAttributeExample example);

    int deleteByExample(PAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PAttribute record);

    int insertSelective(PAttribute record);

    List<PAttribute> selectByExample(PAttributeExample example);

    PAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PAttribute record, @Param("example") PAttributeExample example);

    int updateByExample(@Param("record") PAttribute record, @Param("example") PAttributeExample example);

    int updateByPrimaryKeySelective(PAttribute record);

    int updateByPrimaryKey(PAttribute record);
}