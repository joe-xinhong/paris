package com.commune.paris.mapper;

import com.commune.paris.entity.PRolePermission;
import com.commune.paris.entity.PRolePermissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PRolePermissionMapper {
    long countByExample(PRolePermissionExample example);

    int deleteByExample(PRolePermissionExample example);

    int insert(PRolePermission record);

    int insertSelective(PRolePermission record);

    List<PRolePermission> selectByExample(PRolePermissionExample example);

    int updateByExampleSelective(@Param("record") PRolePermission record, @Param("example") PRolePermissionExample example);

    int updateByExample(@Param("record") PRolePermission record, @Param("example") PRolePermissionExample example);

    int delete(PRolePermission record);

    int deleteByRoleId(@Param("roleId")Integer roleId);

    int deleteByPermissionId(@Param("permissionId")Integer permissionId);
}