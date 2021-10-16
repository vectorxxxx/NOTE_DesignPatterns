package com.vectorx.pattern.t4_builder.improve.builder;

public class NormalRoomBuilder extends HouseBuilder {
    @Override
    public void piling() {
        System.out.println("普通房打桩...");
    }

    @Override
    public void walling() {
        System.out.println("普通房砌墙...");
    }

    @Override
    public void capping() {
        System.out.println("普通房封顶...");
    }
}
