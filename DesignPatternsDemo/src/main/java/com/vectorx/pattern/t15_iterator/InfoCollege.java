package com.vectorx.pattern.t15_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 信息学院
 */
public class InfoCollege implements College {
    private List<Department> departments;

    public InfoCollege() {
        departments = new ArrayList<>();
        departments.add(new Department("信息安全专业"));
        departments.add(new Department("网络安全专业"));
        departments.add(new Department("服务器安全专业"));
    }

    @Override
    public String getName() {
        return "信息学院";
    }

    @Override
    public Iterator<Department> createIterator() {
        return new InfoCollegeIterator(departments);
    }
}
