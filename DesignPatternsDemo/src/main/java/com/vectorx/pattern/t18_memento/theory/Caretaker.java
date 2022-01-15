package com.vectorx.pattern.t18_memento.theory;

import java.util.ArrayList;
import java.util.List;

/**
 * 守护者对象
 */
public class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(Integer index) {
        return mementoList.get(index);
    }
}
