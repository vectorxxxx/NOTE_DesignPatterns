package com.vectorx.pattern.t13_command;

/**
 * 接收者
 */
public class TVReceiver {
    public void on() {
        System.out.println("电视打开了...");
    }

    public void off() {
        System.out.println("电视关闭了...");
    }
}
