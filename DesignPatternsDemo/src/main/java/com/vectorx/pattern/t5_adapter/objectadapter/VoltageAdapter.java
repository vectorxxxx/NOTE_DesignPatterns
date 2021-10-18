package com.vectorx.pattern.t5_adapter.objectadapter;

public class VoltageAdapter implements IVoltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public Integer output5V() {
        if (voltage220V == null) {
            return 0;
        }
        int src = voltage220V.output220V();
        int dst = src / 44;
        System.out.println("电压=" + dst + "伏");
        return dst;
    }
}
