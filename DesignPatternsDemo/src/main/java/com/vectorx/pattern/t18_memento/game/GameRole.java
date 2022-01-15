package com.vectorx.pattern.t18_memento.game;

public class GameRole {
    private Integer vit;
    private Integer def;

    public Integer getVit() {
        return vit;
    }

    public void setVit(Integer vit) {
        this.vit = vit;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Memento createMemento() {
        return new Memento(this.vit, this.def);
    }

    public void recoverMemento(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }

    public void display() {
        System.out.println("游戏角色当前攻击力：" + this.vit + "，当前防御力：" + this.def);
    }
}
