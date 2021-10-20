package com.vectorx.pattern.t6_bridge.implementor;

// 行为实现类——苹果品牌
public class iPhone implements Branch {
    @Override
    public void open() {
        System.out.println("苹果手机开机");
    }

    @Override
    public void call() {
        System.out.println("苹果手机打电话");
    }

    @Override
    public void close() {
        System.out.println("苹果手机关机");
    }
}
