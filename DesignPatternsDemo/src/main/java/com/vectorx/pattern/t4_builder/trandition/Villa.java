package com.vectorx.pattern.t4_builder.trandition;

public class Villa extends AbsHouse {
    @Override
    protected void piling() {
        System.out.println("别墅打桩...");
    }

    @Override
    protected void walling() {
        System.out.println("别墅砌墙...");
    }

    @Override
    protected void capping() {
        System.out.println("别墅封顶...");
    }
}
