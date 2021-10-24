package com.vectorx.pattern.t8_composite;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        //大学
        OrganizationComponent university = new University("清华大学");
        //学院
        OrganizationComponent computerCollege = new College("计算机学院");
        OrganizationComponent infoEngineerCollege = new College("信息工程学院");
        //专业
        computerCollege.add(new Major("软件工程"));
        computerCollege.add(new Major("网络工程"));
        computerCollege.add(new Major("计算机科学与技术"));
        infoEngineerCollege.add(new Major("通信工程"));
        infoEngineerCollege.add(new Major("信息工程"));

        university.add(computerCollege);
        university.add(infoEngineerCollege);
        university.print();
        //=============计算机学院=============
        //软件工程
        //网络工程
        //计算机科学与技术
        //=============信息工程学院=============
        //通信工程
        //信息工程
        HashMap
    }
}
