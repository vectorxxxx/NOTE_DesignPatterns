package com.vectorx.pattern.t15_iterator;

import java.util.Iterator;

/**
 * 计算机学院迭代器类
 */
public class ComputerCollegeIterator implements Iterator {
    private Department[] departments;
    private Integer position = -1;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return position + 1 < departments.length && departments[position + 1] != null;
    }

    @Override
    public Object next() {
        return departments[++position];
    }
}
