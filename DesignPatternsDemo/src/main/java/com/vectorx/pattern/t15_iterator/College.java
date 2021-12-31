package com.vectorx.pattern.t15_iterator;

import java.util.Iterator;

/**
 * 学院类
 */
public interface College {
    String getName();

    Iterator<Department> createIterator();
}
