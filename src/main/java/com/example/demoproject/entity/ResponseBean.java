package com.example.demoproject.entity;

import lombok.Data;

@Data
public class ResponseBean<T> {
    private String code;

    private String message;

    /**
     * 返回结果
     */
    private T result;

    @Override
    public String toString() {
        return "ResponseBean{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    public ResponseBean(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ResponseBean() {
    }
}
