package com.hippot.bilibili.function.model;

/**
 * Created by teng on 17/9/25.
 */

public class HttpResult<T> {

    private int resultCode;
    private String reason;
    private T result;


    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
