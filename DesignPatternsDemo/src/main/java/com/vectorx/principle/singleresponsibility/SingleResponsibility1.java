package com.vectorx.principle.singleresponsibility;

import org.junit.Test;

public class SingleResponsibility1 {

    @Test
    public void test() {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("轮船");
        vehicle.run("飞机");
    }

    /**
     * 方式1的分析
     * 1.在方式1的run方法中，违反了单一职责原则
     * 2.解决的方案非常的简单，根据交通工具运行方法不同，分解成不同类即可
     */
    class Vehicle {
        public void run(String type) {
            if ("汽车".equals(type)) {
                System.out.println(type + "在公路上运行...");
            } else if ("轮船".equals(type)) {
                System.out.println(type + "在水面上运行...");
            } else if ("飞机".equals(type)) {
                System.out.println(type + "在天空上运行...");
            }
        }
    }
}