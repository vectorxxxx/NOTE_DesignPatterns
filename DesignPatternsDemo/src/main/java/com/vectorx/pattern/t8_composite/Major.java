package com.vectorx.pattern.t8_composite;

public class Major extends OrganizationComponent {

    public Major(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
