package com.vectorx.pattern.t14_visitor;

public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());
        objectStructure.display(new Success());
        System.out.println("============");
        objectStructure.display(new Fail());
        System.out.println("============");
        objectStructure.display(new Wait());
        //男生给了通过
        //女生给了通过
        //============
        //男生给了不通过
        //女生给了不通过
        //============
        //男生给了待定
        //女生给了待定
    }
}
