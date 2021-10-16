package com.vectorx.pattern.t3_prototype.deepclone1;

import java.io.Serializable;

public class DeepPrototype implements Serializable, Cloneable {
    private String name;
    private DeepClonableTarget deepClonableTarget;

    public DeepPrototype() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepClonableTarget getDeepClonableTarget() {
        return deepClonableTarget;
    }

    public void setDeepClonableTarget(DeepClonableTarget deepClonableTarget) {
        this.deepClonableTarget = deepClonableTarget;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //基本数据类型拷贝
        Object object = super.clone();
        //引用类型拷贝
        DeepPrototype deepPrototype = (DeepPrototype) object;
        deepPrototype.deepClonableTarget = (DeepClonableTarget) deepClonableTarget.clone();
        return object;
    }
}
