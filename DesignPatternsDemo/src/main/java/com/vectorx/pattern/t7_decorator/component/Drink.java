package com.vectorx.pattern.t7_decorator.component;

public abstract class Drink {
    private String desc;
    private Float price;

    public String getDesc() {
        return desc;
    }

    protected void setDesc(String desc) {
        this.desc = desc;
    }

    public Float getPrice() {
        return price;
    }

    protected void setPrice(Float price) {
        this.price = price;
    }

    public abstract Float cost();
}
