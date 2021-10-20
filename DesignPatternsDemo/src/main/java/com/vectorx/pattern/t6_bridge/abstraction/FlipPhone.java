package com.vectorx.pattern.t6_bridge.abstraction;

import com.vectorx.pattern.t6_bridge.implementor.Branch;

// 桥接子类——翻盖式手机
public class FlipPhone extends Phone {
    public FlipPhone(Branch branch) {
        super(branch);
        System.out.println("翻盖式手机");
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
