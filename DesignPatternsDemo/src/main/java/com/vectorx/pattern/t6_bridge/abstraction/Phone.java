package com.vectorx.pattern.t6_bridge.abstraction;

import com.vectorx.pattern.t6_bridge.implementor.Branch;

// 桥接类——手机抽象类
public abstract class Phone {
    private Branch branch;

    public Phone(Branch branch) {
        this.branch = branch;
    }

    public void open() {
        branch.open();
    }

    public void call() {
        branch.call();
    }

    public void close() {
        branch.close();
    }
}
