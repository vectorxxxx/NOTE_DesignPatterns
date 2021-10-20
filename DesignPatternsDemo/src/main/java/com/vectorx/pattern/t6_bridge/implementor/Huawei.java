package com.vectorx.pattern.t6_bridge.implementor;

// 行为实现类——华为品牌
public class Huawei implements Branch {
    @Override
    public void open() {
        System.out.println("华为手机开机");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void close() {
        System.out.println("华为手机关机");
    }
}
