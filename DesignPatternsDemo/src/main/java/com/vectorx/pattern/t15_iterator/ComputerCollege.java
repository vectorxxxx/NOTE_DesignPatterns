package com.vectorx.pattern.t15_iterator;

import java.util.Iterator;

/**
 * 计算机学院
 */
public class ComputerCollege implements College {
    private Department[] departments;
    private Integer position = 0;

    public ComputerCollege() {
        departments = new Department[5];
        departments[position++] = new Department("Java专业");
        departments[position++] = new Department("PHP专业");
        departments[position++] = new Department("Python专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public Iterator<Department> createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
