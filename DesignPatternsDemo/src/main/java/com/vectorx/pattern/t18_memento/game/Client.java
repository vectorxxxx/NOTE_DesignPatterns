package com.vectorx.pattern.t18_memento.game;

public class Client {
    public static void main(String[] args) {
        System.out.println("======大战前状态======");
        GameRole gameRole = new GameRole();
        gameRole.setVit(100);
        gameRole.setDef(100);
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());
        gameRole.display();

        System.out.println("======大战后状态======");
        gameRole.setVit(10);
        gameRole.setDef(10);
        gameRole.display();

        System.out.println("======从备忘录对象恢复到大战前的状态======");
        gameRole.recoverMemento(caretaker.getMemento());
        gameRole.display();

        //======大战前状态======
        //游戏角色当前攻击力：100，当前防御力：100
        //======大战后状态======
        //游戏角色当前攻击力：10，当前防御力：10
        //======从备忘录对象恢复到大战前的状态======
        //游戏角色当前攻击力：100，当前防御力：100
    }
}
