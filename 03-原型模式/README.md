> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 原型模式

## 1、克隆羊问题

现在有一只羊，姓名为 Tom，年龄为 1，颜色为白色，请编写程序创建和 Tom 羊属性完全相同的 10 只羊

**传统方法**

![image-20211015215334929](https://i.loli.net/2021/10/15/CjsIenXy2RHpt3L.png)

```java
public class Sheep {
    private String name;
    private Integer age;

    public Sheep(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Sheep sheep = new Sheep("Tom", 1, "白色");
            System.out.println(sheep);
        }
    }
}
```

**传统方法优缺点**

- 1）优点是比较好理解，简单易操作
- 2）在创建新的对象时，总是需要重新获取原始对象的属性，如果创建的对象比较复杂时，效率较低
- 3）总是需要重新初始化对象，而不是动态地获得对象运行时的状态，不够灵活

**改进的思路分析**

Java 中 Object 类是所有类的根类，Object 类提供了一个 clone 方法，该方法可以将一个 Java 对象复制一份，但是需要实现 clone 的 Java 类必须要实现一个接口 Cloneable，该接口表示该类能够复制且具有复制的能力 ==> 原型模式



## 2、基本介绍

- 1）原型模式（Prototype 模式）是指：<mark>用原型实例指定创建对象种类，并通过拷贝原型创建新的对象</mark>

- 2）原型模式是一种<mark>创建型设计模式</mark>，允许一个对象再创建另外一个可定制的对象，无需知道如何创建的细节

- 3）工作原理是：通过将一个原型对象传给那个要发动创建的对象，这个要发动创建的对象通过请求原型对象拷贝它们自己来实施创建，即`对象.clone()`

- 4）形象的理解：孙大圣拔出猴毛，变出其它孙大圣

  ![image-20211015213847067](https://i.loli.net/2021/10/15/rgOc2R4si78L5mu.png)



## 3、原理结构图（UML 类图）

![image-20211015214042060](https://i.loli.net/2021/10/15/3InmGRD5MyAQcPY.png)

**原理结构图说明**

- 1）`Prototype`：原型类，声明一个克隆自己的接口
- 2）`ConcretePrototype`：具体的原型类，实现一个克隆自己的操作
- 3）`Client`：让一个原型对象克隆自己，创建一个新的对象（属性相同）



## 4、原型模式解决克隆羊问题

使用原型模式改进传统方式式，让程序具有更高的效率和扩展性

**UML 类图**

![image-20211015215241868](https://i.loli.net/2021/10/15/FHOxv9EUD3hAR2T.png)

**核心代码**

```java
public class Sheep implements Cloneable {
    private String name;
    private Integer age;
    private String color;

    public Sheep(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheep;
    }
}

public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("Tom", 1, "白色");
        for (int i = 0; i < 10; i++) {
            Sheep sheep1 = (Sheep) sheep.clone();
            System.out.println(sheep1);
        }
    }
}
```

