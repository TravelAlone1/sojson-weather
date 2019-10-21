package com.lx.spring.cloud.weather.global;

/**
 * @Author: lx
 * @Date: 2019/10/16 16:29
 */
public enum ResultCode {


    SUCCESS(1,"成功"),
    PARAM_IS_INVALID(1001,"参数无效"),
    param_is_blank(1002,"参数为空"),
    param_type_bind_error(1003,"参数类型错误"),
    param_not_complete(1004,"参数缺失");



    private Integer code;

    private String message;


    ResultCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    public Integer code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }

}

