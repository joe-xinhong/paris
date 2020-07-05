package com.commune.paris.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.commune.paris.entity.PCategory;
import com.commune.paris.entity.PCategoryExample;
import com.commune.paris.mapper.PCategoryMapper;
import com.commune.paris.service.ICategoryService;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.TreeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private PCategoryMapper categoryMapper;

    @Override
    public Result findAllList(Integer type) {
        List<PCategory> categories = getType(type);
        JSONArray array = new JSONArray();
        setCategory(0,categories,array);
        return Result.success(array);
    }

    @Override
    public Result save(PCategory category) {
        PCategory queryCategory = getCateByParentIdAndName(category.getParentId(), category.getName());
        if (queryCategory!=null){
            return Result.fail("信息已经存在");
        }
        categoryMapper.insertSelective(category);
        return Result.success(category);
    }

    @Override
    @Transactional
    public Result update(PCategory category) {
        PCategory queryCategory = getCateByParentIdAndName(category.getParentId(), category.getName());
        if (queryCategory==null && queryCategory.getId()!=null){
            categoryMapper.updateByPrimaryKeySelective(category);
            return Result.success(null);
        }
        if (queryCategory!=null && queryCategory.getId()==category.getId()){
            categoryMapper.updateByPrimaryKeySelective(category);
            return Result.success(null);
        }
        return Result.fail("信息已经存在");
    }

    @Override
    @Transactional
    public Result deleteById(Integer id) {
        PCategory category = categoryMapper.selectByPrimaryKey(id);
        if (category==null){
            return Result.fail("信息有误");
        }
        //创建保存的ids
        List<Integer> ids = new ArrayList<>();
        //判断可能删除的第二级
        List<PCategory> categories = getListById(category.getId());
        if (!categories.isEmpty()){
            categories.forEach(category1 ->
                ids.add(category1.getId())
            );
        }
        //判断可能删除的第三级
        if (ids!=null && ids.size()>0){
            ids.forEach(Id ->{
                List<PCategory> list = getListById(Id);
                if (!list.isEmpty()){
                    list.forEach(category1 ->
                        ids.add(category1.getId())
                    );
                }
            });
        }
        //判断可能删除的第一级
        ids.add(id);

        return Result.success(ids);
    }

    /**
     * 按条件查询所有分类的集合
     * @param type
     * @return
     */
    private List<PCategory> getType(Integer type){
        PCategoryExample example = new PCategoryExample();
        PCategoryExample.Criteria criteria = example.createCriteria();
        if (type==1){
            criteria.andLevelEqualTo(0);
        }else if(type==2){
            criteria.andLevelNotEqualTo(2);
        }
        example.setOrderByClause("sort asc");
        List<PCategory> categories = categoryMapper.selectByExample(example);
        return categories;
    }

    /**
     * 根据父级id与名称查询是否存在
     * @param parentId
     * @param name
     * @return
     */
    private PCategory getCateByParentIdAndName(Integer parentId, String name){
        PCategoryExample example = new PCategoryExample();
        example.createCriteria().andParentIdEqualTo(parentId).andNameEqualTo(name);
        List<PCategory> categories = categoryMapper.selectByExample(example);
        if (categories.isEmpty()){
            return null;
        }
        return categories.get(0);
    }

    /**
     * 根据id查询下级全部分类集合
     * @param id
     * @return
     */
    private List<PCategory> getListById(Integer id){
        PCategoryExample example = new PCategoryExample();
        example.createCriteria().andParentIdEqualTo(id);
        List<PCategory> categories = categoryMapper.selectByExample(example);
        return categories;
    }

    public boolean getCateBool(Integer pid, List<PCategory> categoryList){
        if (categoryList.isEmpty()){
            return false;
        }
        List<PCategory> newList = new ArrayList<>();
        categoryList.forEach(cate ->{
            if (cate.getParentId().equals(pid)){
                newList.add(cate);
            }
        });
        if (newList.size()>0){
            return true;
        }
        return false;
    }
    /**
     * 商品分类树
     * @param parentId
     * @param categoryList
     * @param array
     */
    public void setCategory(Integer parentId, List<PCategory> categoryList, JSONArray array){
        for (PCategory cate : categoryList){
            if (cate.getParentId().equals(parentId)){
                String string = JSONObject.toJSONString(cate);
                JSONObject parent = (JSONObject)JSONObject.parse(string);
                array.add(parent);
                if (getCateBool(cate.getId(),categoryList)){
                    JSONArray children = new JSONArray();
                    parent.put("children",children);
                    setCategory(cate.getId(),categoryList,children);
                }
            }
        }
    }
}
