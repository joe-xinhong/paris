package com.commune.paris.shiro;

import lombok.Data;

import java.io.Serializable;

/**
* @Description:    账户封装
* @Author:         Joe
* @CreateDate:     2020/6/5 21:14
*/
@Data
public class AccountProfile implements Serializable {

    private Integer id;

    private String username;

    private String avatar;

    private String email;
}
