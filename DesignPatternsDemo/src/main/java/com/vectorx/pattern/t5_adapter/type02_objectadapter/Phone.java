package com.vectorx.pattern.t5_adapter.type02_objectadapter;

public class Phone {
    public void charing(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println("电压=5伏，正在充电~");
        } else {
            System.out.println("电压!=5伏，无法充电~");
        }
    }
}
