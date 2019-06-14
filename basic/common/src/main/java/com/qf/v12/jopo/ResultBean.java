package com.qf.v12.jopo;

public class ResultBean<T> {
    private int status;
    private T info;

    public ResultBean(int status, T info) {
        this.status = status;
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
