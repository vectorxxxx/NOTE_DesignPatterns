package com.vectorx.principle.singleresponsibility;

import org.junit.Test;

public class SingleResponsibility3 {

    @Test
    public void test() {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.runWater("轮船");
        vehicle.runAir("飞机");
    }

    /**
     * 方式3的分析
     * 1.这种修改方法没有对原来的类做大的修改，只是增加方法
     * 2.这里虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上，仍然是遵守单一职责
     */
    class Vehicle {
        public void run(String type) {
            System.out.println(type + "在公路上运行...");
        }

        public void runWater(String type) {
            System.out.println(type + "在水面上运行...");
        }

        public void runAir(String type) {
            System.out.println(type + "在天空上运行...");
        }
    }
}