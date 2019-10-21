package com.lx.spring.cloud.weather.global;/**
 * @Author: lx
 * @Date: 2019/10/16 16:18
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @program: weather
 *
 * @author: lx
 *
 * @create: 2019-10-16 16:18
 **/
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -3305179565029139895L;

    private Integer code;

    private String message;

    private Object data;

    public Result(){

    }
    public Result(ResultCode resultCode, Object data){
        this.code=resultCode.code();
        this.message=resultCode.message();
        this.data=data;
    }


    public void setResultCode(ResultCode resultCode){
        this.code=resultCode.code();
        this.message=resultCode.message();
    }

    public static Result success(){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

}
