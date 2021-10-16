package com.vectorx.pattern.t4_builder.trandition;

public class Test {
    public static void main(String[] args) {
        AbsHouse house;
        house = new NormalRoom();
        house.build();
        house = new HighRise();
        house.build();
        house = new Villa();
        house.build();
    }
}
