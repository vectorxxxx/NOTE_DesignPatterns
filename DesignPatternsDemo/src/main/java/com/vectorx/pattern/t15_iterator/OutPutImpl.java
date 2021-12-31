package com.vectorx.pattern.t15_iterator;

import java.util.Iterator;
import java.util.List;

/**
 * 输出类
 */
public class OutPutImpl {

    public OutPutImpl() {

    }

    public void printCollege(List<College> collegeList) {
        Iterator<College> iterator = collegeList.iterator();
        while (iterator.hasNext()) {
            College college = iterator.next();
            System.out.println("============" + college.getName() + "============");
            printDepartment(college);
        }
    }

    private void printDepartment(College college) {
        Iterator<Department> iterator = college.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
