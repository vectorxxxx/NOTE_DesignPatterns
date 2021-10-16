package com.vectorx.pattern.t4_builder.improve.builder;

public class HighRiseBuilder extends HouseBuilder {
    @Override
    public void piling() {
        System.out.println("高楼打桩...");
    }

    @Override
    public void walling() {
        System.out.println("高楼砌墙...");
    }

    @Override
    public void capping() {
        System.out.println("高楼封顶...");
    }
}
