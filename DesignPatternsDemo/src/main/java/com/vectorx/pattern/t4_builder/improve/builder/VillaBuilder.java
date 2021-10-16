package com.vectorx.pattern.t4_builder.improve.builder;

public class VillaBuilder extends HouseBuilder {
    @Override
    public void piling() {
        System.out.println("别墅打桩...");
    }

    @Override
    public void walling() {
        System.out.println("别墅砌墙...");
    }

    @Override
    public void capping() {
        System.out.println("别墅封顶...");
    }
}
