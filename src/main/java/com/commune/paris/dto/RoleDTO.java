package com.commune.paris.dto;

import com.alibaba.fastjson.JSONArray;
import com.commune.paris.entity.PPermission;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RoleDTO {
    /**
     * 角色id
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date updateTime;
    /**
     * 对应权限集合
     */
    private JSONArray child = new JSONArray();
}
