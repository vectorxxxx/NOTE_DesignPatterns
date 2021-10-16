package com.vectorx.pattern.t4_builder.trandition;

public class HighRise extends AbsHouse {
    @Override
    protected void piling() {
        System.out.println("高楼打桩...");
    }

    @Override
    protected void walling() {
        System.out.println("高楼砌墙...");
    }

    @Override
    protected void capping() {
        System.out.println("高楼封顶...");
    }
}
