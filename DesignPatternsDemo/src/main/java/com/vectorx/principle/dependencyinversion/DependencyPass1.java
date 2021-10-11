package com.vectorx.principle.dependencyinversion;

import org.junit.Test;

public class DependencyPass1 {
    @Test
    public void test() {
        IOpenAndClose iOpenAndClose = new OpenAndClose();
        iOpenAndClose.open(new ChangHongTV());
    }

    //方式1：通过接口传递实现依赖
    //开关的接口
    interface IOpenAndClose {
        void open(ITV tv);//抽象方法，接收接口
    }

    //实现接口
    class OpenAndClose implements IOpenAndClose {
        @Override
        public void open(ITV tv) {
            tv.play();
        }
    }
}
