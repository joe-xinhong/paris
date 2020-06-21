package com.commune.paris.mapper;

import com.commune.paris.entity.PUser;
import com.commune.paris.entity.PUserExample;
import java.util.List;

import com.commune.paris.utils.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PUserMapper {
    long countByExample(PUserExample example);

    int deleteByExample(PUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PUser record);

    int insertSelective(PUser record);

    List<PUser> selectByExample(PUserExample example);

    PUser selectByPrimaryKey(@Param("id")Integer id);

    int updateByExampleSelective(@Param("record") PUser record, @Param("example") PUserExample example);

    int updateByExample(@Param("record") PUser record, @Param("example") PUserExample example);

    int updateByPrimaryKeySelective(PUser record);

    int updateByPrimaryKey(PUser record);

    Integer countAll(@Param("username")String username);

    List<PUser> getUserByPage(@Param("username")String username, @Param("page")PageQuery page);
}