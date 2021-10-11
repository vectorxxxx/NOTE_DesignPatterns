package com.vectorx.principle.dependencyinversion;

public class ChangHongTV implements ITV {
    @Override
    public void play() {
        System.out.println("长虹电视机...");
    }
}
