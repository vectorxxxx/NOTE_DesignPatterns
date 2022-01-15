package com.vectorx.pattern.t18_memento.theory;

/**
 * 源对象
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMementor() {
        return new Memento(state);
    }

    public void revertStateFromMementor(Memento memento) {
        this.state = memento.getState();
    }
}
