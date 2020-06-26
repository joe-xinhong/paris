package com.commune.paris.mapper;

import com.commune.paris.entity.PRoleUser;
import com.commune.paris.entity.PRoleUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PRoleUserMapper {
    long countByExample(PRoleUserExample example);

    int deleteByExample(PRoleUserExample example);

    int insert(PRoleUser record);

    int insertSelective(PRoleUser record);

    List<PRoleUser> selectByExample(PRoleUserExample example);

    int updateByExampleSelective(@Param("record") PRoleUser record, @Param("example") PRoleUserExample example);

    int updateByExample(@Param("record") PRoleUser record, @Param("example") PRoleUserExample example);

    int delete(PRoleUser record);

    int deleteByRoleId(@Param("roleId")Integer roleId);

    int deleteByUserId(@Param("userId")Integer userId);
}