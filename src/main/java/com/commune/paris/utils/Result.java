package com.commune.paris.utils;

import lombok.Data;

import java.io.Serializable;
/**
* @Description:    返回数据封装
* @Author:         Joe
* @CreateDate:     2020/6/4 17:26
*/
@Data
public class Result implements Serializable {

    private Integer code;//200正常；非200异常
    private String msg;
    private Object data;

    public static Result success(Object data){
        return success(200,"操作成功",data);
    }

    public static Result success(Integer code, String msg, Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result fail(String msg){
        return fail(400,msg,null);
    }

    public static Result fail(String msg, Object data){
        return fail(400,msg,data);
    }

    public static Result fail(Integer code, String msg, Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}
