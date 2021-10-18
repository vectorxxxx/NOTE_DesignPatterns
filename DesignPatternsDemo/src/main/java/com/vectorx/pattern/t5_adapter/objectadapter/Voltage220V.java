package com.vectorx.pattern.t5_adapter.objectadapter;

public class Voltage220V {
    public Integer output220V() {
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}
