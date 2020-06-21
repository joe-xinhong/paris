package com.commune.paris.mapper;

import com.commune.paris.entity.PPermission;
import com.commune.paris.entity.PPermissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PPermissionMapper {
    long countByExample(PPermissionExample example);

    int deleteByExample(PPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PPermission record);

    int insertSelective(PPermission record);

    List<PPermission> selectByExample(PPermissionExample example);

    PPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PPermission record, @Param("example") PPermissionExample example);

    int updateByExample(@Param("record") PPermission record, @Param("example") PPermissionExample example);

    int updateByPrimaryKeySelective(PPermission record);

    int updateByPrimaryKey(PPermission record);
}