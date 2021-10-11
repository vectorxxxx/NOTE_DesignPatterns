package com.vectorx.principle.singleresponsibility;

import org.junit.Test;

public class SingleResponsibility2 {

    @Test
    public void test() {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("汽车");
        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }

    /**
     * 方案2的分析
     * 1.遵守单一职责原则
     * 2.但是这样做的改动很大，即将类分解，同时修改客户端
     * 3.改进：直接修改Vehicle类，改动的代码会比较少=>方案3
     */
    class RoadVehicle {
        public void run(String type) {
            System.out.println(type + "在公路上运行...");
        }
    }

    class WaterVehicle {
        public void run(String type) {
            System.out.println(type + "在水面上运行...");
        }
    }

    class AirVehicle {
        public void run(String type) {
            System.out.println(type + "在天空上运行...");
        }
    }
}