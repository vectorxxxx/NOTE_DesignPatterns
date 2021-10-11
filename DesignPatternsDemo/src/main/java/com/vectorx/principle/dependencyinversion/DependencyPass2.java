package com.vectorx.principle.dependencyinversion;

import org.junit.Test;

public class DependencyPass2 {
    @Test
    public void test() {
        IOpenAndClose iOpenAndClose = new OpenAndClose(new ChangHongTV());
        iOpenAndClose.open();
    }

    //方式2：通过构造函数实现依赖
    //开关的接口
    interface IOpenAndClose {
        void open();//抽象方法
    }

    //实现接口
    class OpenAndClose implements IOpenAndClose {
        private ITV tv; // 成员

        public OpenAndClose(ITV tv) { // 构造器
            this.tv = tv;
        }

        @Override
        public void open() {
            this.tv.play();
        }
    }
}
