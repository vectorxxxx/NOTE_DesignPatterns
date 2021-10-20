package com.vectorx.pattern.t6_bridge.abstraction;

import com.vectorx.pattern.t6_bridge.implementor.Branch;

// 桥接子类——滑盖式手机
public class SlidePhone extends Phone {
    public SlidePhone(Branch branch) {
        super(branch);
        System.out.println("滑盖式手机");
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
