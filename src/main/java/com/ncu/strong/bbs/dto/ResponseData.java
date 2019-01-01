package com.ncu.strong.bbs.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗伟
 * 2018年12月31日
 * Http请求返回数据封装类
 */
public class ResponseData {
    /**
     * 返回状态代码
     */
    private int code;

    /**
     * 请求返回消息
     */
    private String msg;

    /**
     * 请求返回数据
     */
    private Map<String, Object> data;

    public ResponseData() {
        data = new HashMap<>();
    }

    public ResponseData(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}