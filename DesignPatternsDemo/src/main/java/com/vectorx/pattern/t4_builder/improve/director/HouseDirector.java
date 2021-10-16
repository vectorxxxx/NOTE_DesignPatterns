package com.vectorx.pattern.t4_builder.improve.director;

import com.vectorx.pattern.t4_builder.improve.builder.HouseBuilder;
import com.vectorx.pattern.t4_builder.improve.product.House;

public class HouseDirector {
    private HouseBuilder houseBuilder;

    public HouseDirector() {
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House buildHouse() {
        houseBuilder.piling();
        houseBuilder.walling();
        houseBuilder.capping();
        return houseBuilder.build();
    }
}
