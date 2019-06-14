package com.qf.v12.entity;

import com.qf.entity.TProduct;

import java.io.Serializable;

public class TProductVO implements Serializable {
    private TProduct product;
    private String desc;

    public TProduct getProduct() {
        return product;
    }

    public void setProduct(TProduct product) {
        this.product = product;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
