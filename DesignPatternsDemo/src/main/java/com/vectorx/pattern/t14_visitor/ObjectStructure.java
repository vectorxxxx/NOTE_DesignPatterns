package com.vectorx.pattern.t14_visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构
 */
public class ObjectStructure {
    private List<Person> personList = new ArrayList<>();

    public void attach(Person p) {
        personList.add(p);
    }

    public void detach(Person p) {
        personList.remove(p);
    }

    public void display(Action action) {
        for (Person person : personList) {
            person.accept(action);
        }
    }
}
