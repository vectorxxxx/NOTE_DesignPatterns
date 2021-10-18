package com.vectorx.pattern.t5_adapter.classadapter;

public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public Integer output5V() {
        int src = output220V();
        int dst = src / 44;
        System.out.println("电压=" + dst + "伏");
        return dst;
    }
}
