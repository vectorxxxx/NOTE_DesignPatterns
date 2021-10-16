package com.vectorx.pattern.t4_builder.improve;

import com.vectorx.pattern.t4_builder.improve.builder.HighRiseBuilder;
import com.vectorx.pattern.t4_builder.improve.builder.NormalRoomBuilder;
import com.vectorx.pattern.t4_builder.improve.builder.VillaBuilder;
import com.vectorx.pattern.t4_builder.improve.director.HouseDirector;
import com.vectorx.pattern.t4_builder.improve.product.House;

public class BuilderTest {
    public static void main(String[] args) {
        HouseDirector houseDirector = new HouseDirector();
        House house;

        houseDirector.setHouseBuilder(new NormalRoomBuilder());
        house = houseDirector.buildHouse();
        houseDirector.setHouseBuilder(new HighRiseBuilder());
        house = houseDirector.buildHouse();
        houseDirector.setHouseBuilder(new VillaBuilder());
        house = houseDirector.buildHouse();
    }
}
