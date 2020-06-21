package com.commune.paris.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;


    /**
     * 状态
     */
    private boolean status;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date created;

    /**
     * 上次登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date lastLogin;
}
