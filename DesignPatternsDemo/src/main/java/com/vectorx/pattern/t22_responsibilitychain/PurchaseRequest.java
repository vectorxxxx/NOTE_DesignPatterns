package com.vectorx.pattern.t22_responsibilitychain;

/**
 * 采购申请类
 */
public class PurchaseRequest {
    private Integer id;
    private Float price;

    public PurchaseRequest(Integer id, Float price) {
        this.id = id;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Float getPrice() {
        return price;
    }
}
