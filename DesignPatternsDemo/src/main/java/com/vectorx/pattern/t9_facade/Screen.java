package com.vectorx.pattern.t9_facade;

// 荧幕
public class Screen {
    private static Screen screen = new Screen();

    public static Screen getInstance() {
        return screen;
    }

    public void up() {
        System.out.println("升起荧幕...");
    }

    public void down() {
        System.out.println("拉下荧幕...");
    }
}
