package com.vectorx.principle.liskvosubstitution;

import org.junit.Test;

public class LiskvoSubstitution1 {

    @Test
    public void test() {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));
        System.out.println("---------------------");

        B b = new B();
        System.out.println("11-3=" + b.func1(11, 3));
        System.out.println("1-8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }

    class A {
        //返回两个数的差
        public int func1(int num1, int num2) {
            return num1 - num2;
        }
    }

    class B extends A {
        @Override
        public int func1(int num1, int num2) {
            return num1 + num2;
        }

        //增加了一个新功能：完成两个数相加，然后和9求和
        public int func2(int num1, int num2) {
            return func1(num1, num2) + 9;
        }
    }
}
