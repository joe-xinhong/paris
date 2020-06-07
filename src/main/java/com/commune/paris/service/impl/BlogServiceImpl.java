package com.commune.paris.service.impl;

import com.commune.paris.entity.PBlog;
import com.commune.paris.mapper.PBlogMapper;
import com.commune.paris.service.IBlogService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    PBlogMapper blogMapper;
    @Override
    public ReturnData<PBlog> getListByPage(PageQuery pageQuery) {
        ReturnData<PBlog> pBlogReturnData = new ReturnData<>();
        Integer count = blogMapper.countAll();
        List<PBlog> blogs = blogMapper.getBlogByPage(pageQuery);
        pBlogReturnData.setTotal(count);
        pBlogReturnData.setData(blogs);
        pBlogReturnData.setPageNo(pageQuery.getPageNo());
        pBlogReturnData.setPageSize(pageQuery.getPageSize());
        return pBlogReturnData;
    }

    @Override
    public PBlog getOneById(Integer id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer saveOrUpdate(PBlog temp) {
        Integer i;
        if (temp.getId()==null){
             i = blogMapper.insert(temp);
        }else {
            i = blogMapper.updateByPrimaryKeySelective(temp);
        }
        return i;
    }
}
