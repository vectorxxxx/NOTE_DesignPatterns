package com.vectorx.pattern.t4_builder.improve.builder;


import com.vectorx.pattern.t4_builder.improve.product.House;

public abstract class HouseBuilder {
    private House house = new House();

    public abstract void piling();

    public abstract void walling();

    public abstract void capping();

    public House build() {
        return house;
    }
}
