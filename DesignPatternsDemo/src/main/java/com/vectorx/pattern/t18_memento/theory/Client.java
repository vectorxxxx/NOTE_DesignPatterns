package com.vectorx.pattern.t18_memento.theory;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("当前状态：" + " 状态#1 血量 100 ");
        caretaker.addMemento(originator.createMementor());
        System.out.println(originator.getState());
        originator.setState("当前状态：" + " 状态#2 血量 80 ");
        caretaker.addMemento(originator.createMementor());
        System.out.println(originator.getState());
        originator.setState("当前状态：" + " 状态#3 血量 60 ");
        caretaker.addMemento(originator.createMementor());
        System.out.println(originator.getState());

        // 恢复到状态1
        originator.revertStateFromMementor(caretaker.getMemento(0));
        System.out.println("恢复状态：" + originator.getState());

        //当前状态： 状态#1 血量 100
        //当前状态： 状态#2 血量 80
        //当前状态： 状态#3 血量 60
        //恢复状态：当前状态： 状态#1 血量 100
    }
}
