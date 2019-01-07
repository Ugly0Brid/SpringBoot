package com.example.demo.controller;

public class JsonResult<T> {
    private Integer status;
    private String message;
    private Integer total;


    private T data;

    public JsonResult() {

    }

    public JsonResult(Integer status, String message, Integer total) {
        this.status = status;
        this.message = message;
        this.total = total;
    }

    public JsonResult(Integer status, String message, Integer total, T data) {
        this(status, message, total);
        this.setData(data);
    }

    public static <T> JsonResult<T> successResult(Integer status, String message, Integer total, T data) {
        return new JsonResult(status, message, total, data);
    }

    public static <T> JsonResult<T> errorResult(int status, String message, T data) {
        return new JsonResult(status, message, 0, data);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setData(T data) {
        this.data = data;
    }
}
