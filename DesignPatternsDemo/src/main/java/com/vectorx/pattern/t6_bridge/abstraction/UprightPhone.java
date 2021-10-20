package com.vectorx.pattern.t6_bridge.abstraction;

import com.vectorx.pattern.t6_bridge.implementor.Branch;

// 桥接子类——直立式手机
public class UprightPhone extends Phone {
    public UprightPhone(Branch branch) {
        super(branch);
        System.out.println("直立式手机");
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    public void call() {
        super.call();
    }

    @Override
    public void close() {
        super.close();
    }
}
