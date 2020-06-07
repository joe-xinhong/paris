package com.commune.paris.service;

import com.commune.paris.entity.PBlog;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.ReturnData;


public interface IBlogService {
    ReturnData<PBlog> getListByPage(PageQuery pageQuery);

    PBlog getOneById(Integer id);

    Integer saveOrUpdate(PBlog temp);
}
