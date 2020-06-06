package com.commune.paris.utils;

import com.commune.paris.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
* @Description:    处理部分转换
* @Author:         Joe
* @CreateDate:     2020/6/6 17:20
*/
public class ShiroUtil {
    public static AccountProfile getProfile(){
        return (AccountProfile)SecurityUtils.getSubject().getPrincipal();
    }
}
