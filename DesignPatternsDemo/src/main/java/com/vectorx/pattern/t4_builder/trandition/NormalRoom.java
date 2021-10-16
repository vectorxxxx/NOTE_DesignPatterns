package com.vectorx.pattern.t4_builder.trandition;

public class NormalRoom extends AbsHouse {
    @Override
    protected void piling() {
        System.out.println("普通房打桩...");
    }

    @Override
    protected void walling() {
        System.out.println("普通房砌墙...");
    }

    @Override
    protected void capping() {
        System.out.println("普通房封顶...");
    }
}
