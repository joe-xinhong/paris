package com.commune.paris.exception;

import com.commune.paris.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
* @Description:    全局异常
* @Author:         Joe
* @CreateDate:     2020/6/5 21:21
*/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 全局大范围补充
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e){
        log.error("运行时异常：----------------------");
        return Result.fail(e.getMessage());
    }

    /**
     * shiro的异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public Result handler(ShiroException e){
        log.error("权限异常：----------------------");
        return Result.fail(401,e.getMessage(),null);
    }
}
