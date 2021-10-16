package com.vectorx.pattern.t3_prototype.deepclone2;

public class DeepTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype prototype = new DeepPrototype();
        prototype.setName("宋江");
        prototype.setDeepClonableTarget(new DeepClonableTarget("及时雨", "及时雨的类"));

        DeepPrototype clone1 = prototype.deepClone();
        DeepPrototype clone2 = prototype.deepClone();
        DeepPrototype clone3 = prototype.deepClone();
        DeepPrototype clone4 = prototype.deepClone();
        DeepPrototype clone5 = prototype.deepClone();

        System.out.println(prototype.getName() + ", " + prototype.getDeepClonableTarget().hashCode()); // 宋江, 644117698
        System.out.println(clone1.getName() + ", " + clone1.getDeepClonableTarget().hashCode()); // 宋江, 317574433
        System.out.println(clone2.getName() + ", " + clone2.getDeepClonableTarget().hashCode()); // 宋江, 885284298
        System.out.println(clone3.getName() + ", " + clone3.getDeepClonableTarget().hashCode()); // 宋江, 1389133897
        System.out.println(clone4.getName() + ", " + clone4.getDeepClonableTarget().hashCode()); // 宋江, 1534030866
        System.out.println(clone5.getName() + ", " + clone5.getDeepClonableTarget().hashCode()); // 宋江, 664223387
    }
}
