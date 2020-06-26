package com.commune.paris.service;

import com.commune.paris.entity.PCategory;
import com.commune.paris.utils.Result;

public interface ICategoryService {
    Result findAllList(Integer type);

    Result save(PCategory category);

    Result update(PCategory category);

    Result deleteById(Integer id);
}
