package com.vectorx.pattern.t9_facade;

// DVD播放器
public class DVDPlayer {
    private static DVDPlayer player = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return player;
    }

    public void on() {
        System.out.println("打开DVD播放器...");
    }

    public void off() {
        System.out.println("关闭DVD播放器...");
    }

    public void play() {
        System.out.println("播放DVD播放器...");
    }

    public void pause() {
        System.out.println("暂停DVD播放器...");
    }

    public void setDvd(String dvd) {
        System.out.println("选dvd：" + dvd + "...");
    }
}
