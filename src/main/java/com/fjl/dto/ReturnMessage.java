package com.fjl.dto;


import lombok.Data;

@Data
public class ReturnMessage<T> {
    /**
     * -1用户错误
     * -2密码错误
     * 0正确
     */
    private Integer encode;
    private T admin;

}
