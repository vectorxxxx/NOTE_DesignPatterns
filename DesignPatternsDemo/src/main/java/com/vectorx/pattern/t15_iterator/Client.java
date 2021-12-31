package com.vectorx.pattern.t15_iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<College> collegeList = new ArrayList<>();
        collegeList.add(new ComputerCollege());
        collegeList.add(new InfoCollege());
        new OutPutImpl().printCollege(collegeList);
        //============计算机学院============
        //Java专业
        //PHP专业
        //Python专业
        //============信息学院============
        //信息安全专业
        //网络安全专业
        //服务器安全专业
    }
}
