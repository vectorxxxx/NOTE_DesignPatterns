package com.vectorx.pattern_advance.t2_factory.vegetable.v2;

/**
 * 菜棚子
 */
public class VegetableShed {
    public Vegetable plantVegetable(String type) {
        Vegetable vegetable = null;
        if (VegetableType.大白菜.name().equals(type)) {
            vegetable = new ChineseCabbage();
        } else if (VegetableType.黄瓜.name().equals(type)) {
            vegetable = new Cucumber();
        } else if (VegetableType.青椒.name().equals(type)) {
            vegetable = new GreenPeper();
        } else if (VegetableType.萝卜.name().equals(type)) {
            vegetable = new Radish();
        } else if (VegetableType.胡萝卜.name().equals(type)) {
            vegetable = new Carrot();
        }
        return vegetable;
    }
}
