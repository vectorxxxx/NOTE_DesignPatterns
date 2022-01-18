package com.vectorx.pattern.t21_strategy.improve;

import com.vectorx.pattern.t21_strategy.improve.duck.Duck;
import com.vectorx.pattern.t21_strategy.improve.duck.PekingDuck;
import com.vectorx.pattern.t21_strategy.improve.duck.ToyDuck;
import com.vectorx.pattern.t21_strategy.improve.duck.WildDuck;
import com.vectorx.pattern.t21_strategy.improve.fly.NoFlyBehavior;

public class Client {
    public static void main(String[] args) {
        Duck wildDuck = new WildDuck();
        wildDuck.quark();
        wildDuck.swim();
        wildDuck.fly();

        Duck pekingDuck = new PekingDuck();
        pekingDuck.quark();
        pekingDuck.swim();
        pekingDuck.fly();
        System.out.println("===改变策略===");
        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        pekingDuck.fly();

        Duck toyDuck = new ToyDuck();
        toyDuck.quark();
        toyDuck.swim();
        toyDuck.fly();

        //======野鸭子======
        //咯咯叫~
        //会游泳~
        //很会飞~
        //======北京鸭======
        //嘎嘎叫~
        //会游泳~
        //不太会飞~
        //===改变策略===
        //不会飞~
        //======玩具鸭======
        //不会叫~
        //不会游泳~
        //不会飞~
    }
}
