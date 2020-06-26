package com.commune.paris.mapper;

import com.commune.paris.entity.PCategory;
import com.commune.paris.entity.PCategoryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PCategoryMapper {
    long countByExample(PCategoryExample example);

    int deleteByExample(PCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PCategory record);

    int insertSelective(PCategory record);

    List<PCategory> selectByExample(PCategoryExample example);

    PCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PCategory record, @Param("example") PCategoryExample example);

    int updateByExample(@Param("record") PCategory record, @Param("example") PCategoryExample example);

    int updateByPrimaryKeySelective(PCategory record);

    int updateByPrimaryKey(PCategory record);
}