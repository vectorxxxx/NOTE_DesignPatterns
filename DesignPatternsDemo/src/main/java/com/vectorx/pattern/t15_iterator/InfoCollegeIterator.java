package com.vectorx.pattern.t15_iterator;

import java.util.Iterator;
import java.util.List;

/**
 * 信息学院迭代器类
 */
public class InfoCollegeIterator implements Iterator {
    private List<Department> departments;
    private Integer position = -1;

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return position + 1 < departments.size();
    }

    @Override
    public Object next() {
        return departments.get(++position);
    }
}
