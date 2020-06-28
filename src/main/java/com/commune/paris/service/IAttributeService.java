package com.commune.paris.service;

import com.commune.paris.entity.PAttribute;
import com.commune.paris.entity.PAttributeValue;
import com.commune.paris.utils.Result;

import java.util.List;

public interface IAttributeService {
    Result getList(Integer cate_id, String sel);

    Result save(PAttribute attribute);

    Result getOne(Integer cate_id, Integer id, String sel);

    Result UpdateOne(PAttribute attribute);

    Result delete(Integer cate_id, Integer id);

    Result saveValue(PAttributeValue attributeValue);

    Result deleteValue(PAttributeValue attributeValue);

    List<PAttribute> getDOList(Integer cate_id, String sel);
}
