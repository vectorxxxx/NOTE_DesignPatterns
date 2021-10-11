package com.vectorx.principle.dependencyinversion;

import org.junit.Test;

public class DependencyPass3 {
    @Test
    public void test() {
        IOpenAndClose iOpenAndClose = new OpenAndClose();
        iOpenAndClose.setTv(new ChangHongTV());
        iOpenAndClose.open();
    }

    //方式3，通过setter方法传递
    interface IOpenAndClose {
        void open();//抽象方法

        void setTv(ITV tv);
    }

    //实现接口
    class OpenAndClose implements IOpenAndClose {
        private ITV tv;

        @Override
        public void setTv(ITV tv) {
            this.tv = tv;
        }

        @Override
        public void open() {
            this.tv.play();
        }
    }
}
