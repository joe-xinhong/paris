package com.commune.paris.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.commune.paris.entity.PCategory;
import com.commune.paris.entity.PPermission;

import java.util.List;

public class TreeUtils {

    /**
     * 权限菜单树
     * @param parentId
     * @param permissionList
     * @param array
     */
    public static void setPermissionsTree(Integer parentId, List<PPermission> permissionList, JSONArray array){
        for (PPermission per : permissionList){
            if (per.getParentId().equals(parentId)){
                String string = JSONObject.toJSONString(per);
                JSONObject parent = (JSONObject)JSONObject.parse(string);
                array.add(parent);
                if (permissionList.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null){
                    JSONArray child = new JSONArray();
                    parent.put("child",child);
                    setPermissionsTree(per.getId(),permissionList,child);
                }
            }
        }
    }
    /**
     * 商品分类树
     * @param parentId
     * @param categoryList
     * @param array
     */
    public static void setCategoryTree(Integer parentId, List<PCategory> categoryList, JSONArray array){
        for (PCategory cate : categoryList){
            if (cate.getParentId().equals(parentId)){
                String string = JSONObject.toJSONString(cate);
                JSONObject parent = (JSONObject)JSONObject.parse(string);
                array.add(parent);
                if (categoryList.stream().filter(p -> p.getParentId().equals(cate.getId())).findAny() != null && categoryList.size()>0){
                    JSONArray children = new JSONArray();
                    parent.put("children",children);
                    setCategoryTree(cate.getId(),categoryList,children);
                }
            }
        }
    }
}
