package com.example.common.errorhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * 控制器的异常处理类
 * @author Sky
 *
 */
//这个注解是指这个类是处理其他controller抛出的异常
@ControllerAdvice
public class RestErrorHander {

    //这个注解是指当controller中抛出这个指定的异常类的时候，都会转到这个方法中来处理异常
    @ExceptionHandler(MissingServletRequestParameterException.class)
    //将返回的值转成json格式的数据
    @ResponseBody
    //返回的状态码
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)     //服务内部错误
    public Map<String,Object> handlerMissingRequestParameterException(MissingServletRequestParameterException ex){

        Map<String,Object> result= new HashMap<String,Object>();
        result.put("msg", ex.getParameterName());
        result.put("message", ex.getMessage());
        return result;
    }


    //这个注解是指当controller中抛出这个指定的异常类的时候，都会转到这个方法中来处理异常
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    //将返回的值转成json格式的数据
    @ResponseBody
    //返回的状态码
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)     //参数错误
    public Map<String,Object> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        Map<String,Object> result= new HashMap<String,Object>();
        result.put("paramsname", ex.getName());
        result.put("paramsvalue", ex.getValue());
        result.put("message", ex.getMessage());
        return result;
    }

    //这个注解是指当controller中抛出这个指定的异常类的时候，都会转到这个方法中来处理异常
    @ExceptionHandler(NoHandlerFoundException.class)
    //将返回的值转成json格式的数据
    @ResponseBody
    //返回的状态码
    @ResponseStatus(value=HttpStatus.NOT_FOUND)     //参数错误
    public Map<String,Object> handlerNotFoundException(NoHandlerFoundException ex){
        Map<String,Object> result= new HashMap<String,Object>();
        result.put("url", ex.getRequestURL());
        result.put("message", ex.getMessage());
        return result;
    }
}

