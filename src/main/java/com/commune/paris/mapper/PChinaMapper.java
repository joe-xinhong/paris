package com.commune.paris.mapper;

import com.commune.paris.entity.PChina;
import com.commune.paris.entity.PChinaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PChinaMapper {
    long countByExample(PChinaExample example);

    int deleteByExample(PChinaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PChina record);

    int insertSelective(PChina record);

    List<PChina> selectByExample(PChinaExample example);

    PChina selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PChina record, @Param("example") PChinaExample example);

    int updateByExample(@Param("record") PChina record, @Param("example") PChinaExample example);

    int updateByPrimaryKeySelective(PChina record);

    int updateByPrimaryKey(PChina record);
}