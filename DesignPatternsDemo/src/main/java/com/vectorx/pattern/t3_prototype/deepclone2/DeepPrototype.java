package com.vectorx.pattern.t3_prototype.deepclone2;

import java.io.*;

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

    public DeepPrototype deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return (DeepPrototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
