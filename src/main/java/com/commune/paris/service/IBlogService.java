package com.commune.paris.service;

import com.commune.paris.entity.PBlog;
import com.commune.paris.utils.PageQuery;

import java.util.List;

public interface IBlogService {
    List<PBlog> getListByPage(PageQuery pageQuery);

    PBlog getOneById(Integer id);

    Integer saveOrUpdate(PBlog temp);
}
