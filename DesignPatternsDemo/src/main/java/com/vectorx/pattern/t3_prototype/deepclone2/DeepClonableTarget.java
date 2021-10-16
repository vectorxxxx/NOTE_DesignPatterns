package com.vectorx.pattern.t3_prototype.deepclone2;

import java.io.Serializable;

public class DeepClonableTarget implements Serializable, Cloneable {
    private String cloneName;
    private String cloneClass;

    public DeepClonableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getCloneClass() {
        return cloneClass;
    }

    public void setCloneClass(String cloneClass) {
        this.cloneClass = cloneClass;
    }
}
