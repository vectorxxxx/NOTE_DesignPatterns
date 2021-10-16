package com.vectorx.pattern.t3_prototype.deepclone1;

public class DeepTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype prototype = new DeepPrototype();
        prototype.setName("宋江");
        prototype.setDeepClonableTarget(new DeepClonableTarget("及时雨", "及时雨的类"));

        DeepPrototype clone1 = (DeepPrototype) prototype.clone();
        DeepPrototype clone2 = (DeepPrototype) prototype.clone();
        DeepPrototype clone3 = (DeepPrototype) prototype.clone();
        DeepPrototype clone4 = (DeepPrototype) prototype.clone();
        DeepPrototype clone5 = (DeepPrototype) prototype.clone();
        
        System.out.println(prototype.getName() + ", " + prototype.getDeepClonableTarget().hashCode()); // 宋江, 1554874502
        System.out.println(clone1.getName() + ", " + clone1.getDeepClonableTarget().hashCode()); // 宋江, 1846274136
        System.out.println(clone2.getName() + ", " + clone2.getDeepClonableTarget().hashCode()); // 宋江, 1639705018
        System.out.println(clone3.getName() + ", " + clone3.getDeepClonableTarget().hashCode()); // 宋江, 1627674070
        System.out.println(clone4.getName() + ", " + clone4.getDeepClonableTarget().hashCode()); // 宋江, 1360875712
        System.out.println(clone5.getName() + ", " + clone5.getDeepClonableTarget().hashCode()); // 宋江, 1625635731
    }
}
