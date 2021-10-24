> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 组合模式

## 1、学校院系展示需求

编写程序展示一个学校院系结构：

需求是这样，要在一个页面中展示出学校的院系组成，一个学校有多个学院，一个学院有多个系。如图：

![image-20211023221436485](https://i.loli.net/2021/10/23/wL2yh7jspaBfo58.png)

**传统方式解决学校院系展示（类图）**

![image-20211023221531826](https://i.loli.net/2021/10/23/2kWFsvJmPiGRw1N.png)

**问题分析**

- 1）将学院看做是学校的子类，系是学院的子类，这样实际上是站在组织大小来进行分层次的
- 2）实际上我们的要求是：在一个页面中展示出学校的院系组成，一个学校有多个学院，一个学院有多个系。因此这种方案，不能很好实现的 *管理* 的操作，比如对学院、系的添加、删除、遍历等
- 3）解决方案：把学校、院、系都看做是组织结构，他们之间没有继承的关系，而是一个树形结构，可以更好的实现管理操作 ==> 组合模式



## 2、组合模式基本介绍

- 1）组合模式（Composite Pattern），又叫<mark>部分整体模式</mark>。它创建了对象组的树形结构，将对象组合成树状结构以表示“整体-部分”的层次关系
- 2）组合模式<mark>依据树形结构来组合对象</mark>，用来表示部分以及整体层次
- 3）这种类型的设计模式属于<mark>结构型模式</mark>
- 4）组合模式使得用户对单个对象和组合对象的访问具有一致性，即：组合能让客户以一致的方式处理个别对象以及组合对象

**原理类图**

![image](https://i.loli.net/2021/10/24/Dog8fanyjBJPXOp.jpg)

**对原理结构图的说明一即组合模式的角色及职责**

- 1）`Component`：这是组合中对象声明接口。在适当情况下，实现所有类共有的接口默认行为，用于访问和管理 `Component`子部件。`Component`可以是抽象类或者接口
- 2）`Leaf`：在组合中表示叶子结点，叶子结点没有子节点
- 3）`Composite`：非叶子结点，用于存储子部件，在`Component`接口中实现子部件的相关操作。比如增加、删除 

**解决的问题**

组合模式解决这样的问题，当我们的要处理的对象可以生成一棵树形结构，而我们要对树上的节点和叶子进行操作时，它能够提供一致的方式，而不用考虑它是节点还是叶子

![image-20211023222839054](https://i.loli.net/2021/10/23/4K8IGk3bAHUNxLw.png)



## 3、组合模式解决学校院系展示

**UML 类图**

![image-20211023230113883](https://i.loli.net/2021/10/23/sR46tbZn8ydgM53.png)

**核心代码**

```java
// Component 抽象类
public abstract class OrganizationComponent {
    private String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    public abstract void print();
}
// Composite 非叶子节点
public class University extends OrganizationComponent {
    List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public University(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        organizationComponent.remove(organizationComponent);
    }

    @Override
    public void print() {
        for (OrganizationComponent organizationComponent : organizationComponentList) {
            organizationComponent.print();
        }
    }
}
public class College extends OrganizationComponent {
    List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public College(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        organizationComponent.remove(organizationComponent);
    }

    @Override
    public void print() {
        System.out.println("=============" + getName() + "=============");
        for (OrganizationComponent organizationComponent : organizationComponentList) {
            organizationComponent.print();
        }
    }
}
// Leaf 叶子结点
public class Major extends OrganizationComponent {
    public Major(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
// 客户端
public class Client {
    public static void main(String[] args) {
        //大学
        OrganizationComponent university = new University("清华大学");
        //学院
        OrganizationComponent computerCollege = new College("计算机学院");
        OrganizationComponent infoEngineerCollege = new College("信息工程学院");
        //专业
        computerCollege.add(new Major("软件工程"));
        computerCollege.add(new Major("网络工程"));
        computerCollege.add(new Major("计算机科学与技术"));
        infoEngineerCollege.add(new Major("通信工程"));
        infoEngineerCollege.add(new Major("信息工程"));

        university.add(computerCollege);
        university.add(infoEngineerCollege);
        university.print();
        //=============计算机学院=============
        //软件工程
        //网络工程
        //计算机科学与技术
        //=============信息工程学院=============
        //通信工程
        //信息工程
    }
}
```



## 4、JDK 源码分析

Java 的集合类—— HashMap 就使用了组合模式

**UML 类图**

![image-20211024160404083](https://i.loli.net/2021/10/24/zTigmx6NwlVWDR7.png)

**核心代码**

```java
// Component
public interface Map<K,V> {
    interface Entry<K,V> {}
}
public abstract class AbstractMap<K,V> implements Map<K,V> {}
// Composite
public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable {
    // Leaf
    static class Node<K,V> implements Map.Entry<K,V> {}
}
```

**说明**

- 1）Map 就是一个抽象的构建，类似`Component`
- 2）HashMap 是一个中间的构建，类似`Composite`，实现 / 继承了相关方法 put、putAll
- 3）Node 是 HashMap 的静态内部类，类似`Leaf`叶子节点，这里就没有 put



## 5、注意事项和细节

- 1）<mark>简化客户端操作</mark>：客户端只需要面对一致的对象，而不用考虑整体部分或者节点叶子的问题
- 2）<mark>具有较强扩展性</mark>：当我们要更改组合对象时，我们只需要调整内部的层次关系，客户端不用做出任何改动
- 3）<mark>方便创建复杂的层次结构</mark>：客户端不用理会组合里面的组成细节，容易添加节点或者叶子，从而创建出复杂的树形结构
- 4）<mark>需要遍历组织机构，或者处理的对象具有树形结构时，非常适合使用组合模式</mark>
- 5）<mark>要求较高的抽象性，如果节点和叶子有很多差异性的话，比如很多方法和属性都不一样，不适合使用组合模式</mark>

