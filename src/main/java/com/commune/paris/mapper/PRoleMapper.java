package com.commune.paris.mapper;

import com.commune.paris.entity.PRole;
import com.commune.paris.entity.PRoleExample;
import java.util.List;

import com.commune.paris.utils.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PRoleMapper {
    long countByExample(PRoleExample example);

    int deleteByExample(PRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PRole record);

    int insertSelective(PRole record);

    List<PRole> selectByExample(PRoleExample example);

    PRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PRole record, @Param("example") PRoleExample example);

    int updateByExample(@Param("record") PRole record, @Param("example") PRoleExample example);

    int updateByPrimaryKeySelective(PRole record);

    int updateByPrimaryKey(PRole record);

    Integer countAll(@Param("name")String name);

    List<PRole> getRoleByPage(@Param("name")String name, @Param("page")PageQuery page);
}