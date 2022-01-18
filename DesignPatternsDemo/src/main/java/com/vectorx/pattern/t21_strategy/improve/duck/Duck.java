package com.vectorx.pattern.t21_strategy.improve.duck;

import com.vectorx.pattern.t21_strategy.improve.fly.FlyBehavior;
import com.vectorx.pattern.t21_strategy.improve.quark.QuarkBehavior;
import com.vectorx.pattern.t21_strategy.improve.swim.SwimBehavior;

/**
 * 抽象鸭子类
 */
public abstract class Duck {
    protected QuarkBehavior quarkBehavior;
    protected SwimBehavior swimBehavior;
    protected FlyBehavior flyBehavior;

    public Duck() {
        display();
    }

    public void quark() {
        if (quarkBehavior != null) {
            quarkBehavior.quark();
        }
    }

    public void swim() {
        if (swimBehavior != null) {
            swimBehavior.swim();
        }
    }

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }

    public void setQuarkBehavior(QuarkBehavior quarkBehavior) {
        this.quarkBehavior = quarkBehavior;
    }

    public void setSwimBehavior(SwimBehavior swimBehavior) {
        this.swimBehavior = swimBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public abstract void display();
}
