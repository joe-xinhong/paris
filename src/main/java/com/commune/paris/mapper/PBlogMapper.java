package com.commune.paris.mapper;

import com.commune.paris.entity.PBlog;
import com.commune.paris.entity.PBlogExample;
import java.util.List;

import com.commune.paris.utils.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PBlogMapper {
    long countByExample(PBlogExample example);

    int deleteByExample(PBlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PBlog record);

    int insertSelective(PBlog record);

    List<PBlog> selectByExample(PBlogExample example);

    PBlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PBlog record, @Param("example") PBlogExample example);

    int updateByExample(@Param("record") PBlog record, @Param("example") PBlogExample example);

    int updateByPrimaryKeySelective(PBlog record);

    int updateByPrimaryKey(PBlog record);

    Integer countAll();

    List<PBlog> getBlogByPage(@Param("page")PageQuery page);
}