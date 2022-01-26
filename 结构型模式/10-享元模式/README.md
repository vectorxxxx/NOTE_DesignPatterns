> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 享元模式

## 1、展示网站项目需求

小型的外包项目，给客户 A 做一个产品展示网站，客户 A 的朋友感觉效果不错，也希望做这样的产品展示网站，但是要求都有些不同：

- 1）有客户要求以新闻的形式发布
- 2）有客户人要求以博客的形式发布
- 3）有客户希望以微信公众号的形式发布

**传统方案解决网站展现项目**

- 1）直接复制粘贴一份，然后根据客户不同要求，进行定制修改
- 2）给每个网站租用一个空间
- 3）方案设计示意图

![image-20211203213310930](https://i.loli.net/2021/12/03/9MSRGJUjIW1wB7X.png)

**传统方案解决网站展现项目-问题分析**

- 1）需要的网站结构相似度很高，而且都不是高问量网站，如果分成多个虚拟空间来处理，相当于一个相同网站的实例对象很多，造成服务器的<mark>资源浪费</mark>
- 2）解决思路：<mark>整合到一个网站中，共享其相关的代码和数据</mark>，对于硬盘、内存、CPU、数据库空间等服务器资源都可以达成共享，减少服务器资源
- 3）对于代码来说，由于是一份实例，维护和扩展都更加容易
- 4）上面的解决思路就可以使用**享元模式**来解决



## 2、享元模式基本介绍

- 1）享元模式（Flyweight Pattern）也叫**蝇量模式**：<mark>运用共享技术有效地支持大量细粒度的对象</mark>
- 2）<mark>常用于系统底层开发，解决系统的性能问题</mark>。像数据库连接池，里面都是创建好的连接对象，在这些连接对象中有我们需要的则直接拿来用，避免重新创建，如果没有我们需要的，则创建一个
- 3）享元模式能够<mark>解决重复对象的内存浪费的问题</mark>。当系统中有大量相似对象，需要缓冲池时，不需总是创建新对象，可以从缓冲池里拿。这样可以<mark>降低系统内存，同时提高效率</mark>
- 4）<mark>享元模式经典的应用场景就是池技术了，String常量池、数据库连接池、缓冲池等等都是享元模式的应用</mark>，享元模式是池技术的重要实现方式

![image-20211203214444968](https://i.loli.net/2021/12/03/g4pWlK6MShdGZmF.png)



## 3、享元模式的原理类图

![image-20211203215034074](https://i.loli.net/2021/12/03/Hz19BA8xrEk4LZF.png)

**对原理图的说明——即模式的角色和职责**

- 1）Flyweight：抽象的享元角色，是抽象的产品类，同时定义出对象的<mark>外部状态</mark>和<mark>内部状态</mark>的接口和实现
- 2）ConcreteFlyweight：具体的享元角色，是具体的产品类，实现抽象角色定义的相关业务
- 3）UnsharedConcreteFlyweight：不可共享的角色，一般不会出现在享元工厂中
- 4）FlyweightFactory：享元工厂类，用于构建一个池容器（集合），同时提供从池中获取对象的方法



## 4、内部状态和外部状态

比如围棋、五子棋、跳棋，它们都有大量的棋子对象，围棋和五子棋只有黑白两色，跳棋颜色多一点。所以棋子颜色就是棋子的内部状态；而各个棋子之间的差别就是位置的不同。当我们落子后，落子颜色是定的，但位置是变化的，所以棋子坐标就是棋子的外部状态

- 1）享元模式提出了两个要求：<mark>细粒度和共享对象</mark>。即将对象的信息分为两个部分：内部状态和外部状态
- 2）**内部状态**：指对象共享出来的信息，存储在享元对象内部且不会随环境的改变而改变
- 3）**外部状态**：指对象得以依赖的一个标记，是随环境改变而改变的、不可共享的状态

举个例子：围模理论上有 361 个空位可以放棋子，每盘棋都有可能有两三百个棋子对象产生。因为内存空间有限，一台服务器很难支持更多的玩家玩围模游戏。如果用享元模式来处理棋子，那么棋子对象就可以减少到只有两个实例，这样就很好的解决了对象的开销问题



## 5、享元模式解决网站展现项目

**原理类图**

![image-20211204200105089](https://s2.loli.net/2021/12/04/lkrGJThLOsY1XqK.png)

**UML 类图**

![image-20211204203743995](https://s2.loli.net/2021/12/04/QMvt5Os3Fy2KHNi.png)

**核心代码**

```java
/**
 * 内部状态，共享角色
 */
public enum Type {
    新闻,
    博客,
    微信公众号
}
/**
 * 外部状态，非共享角色
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/**
 * 抽象的享元角色
 */
public abstract class Website {
    public abstract void use(User user);
}
/**
 * 具体的享元角色
 */
public class ConcreteWebsite extends Website {
    private Type type;

    public ConcreteWebsite(Type type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站正在使用中：类型为" + type.name() + "，使用者为" + user.getName());
    }
}
/**
 * 享元工厂类
 */
public class WebsiteFactory {
    private static Map<Type, Website> pool = new HashMap<>();

    public static Website getWebsiteCategory(Type type) {
        if (pool.get(type) == null) {
            pool.put(type, new ConcreteWebsite(type));
        }
        return pool.get(type);
    }

    public static Integer getSize() {
        return pool.size();
    }
}
```

**测试**

```java
Website newsWebsite = WebsiteFactory.getWebsiteCategory(Type.新闻);
newsWebsite.use(new User("Tom"));
Website blogWebsite1 = WebsiteFactory.getWebsiteCategory(Type.博客);
blogWebsite1.use(new User("Jerry"));
Website blogWebsite2 = WebsiteFactory.getWebsiteCategory(Type.博客);
blogWebsite2.use(new User("John"));
Website blogWebsite3 = WebsiteFactory.getWebsiteCategory(Type.博客);
blogWebsite3.use(new User("Smith"));
Website wxWebsite = WebsiteFactory.getWebsiteCategory(Type.微信公众号);
wxWebsite.use(new User("Mack"));
System.out.println(WebsiteFactory.getSize());
//网站正在使用中：类型为新闻，使用者为Tom
//网站正在使用中：类型为博客，使用者为Jerry
//网站正在使用中：类型为博客，使用者为John
//网站正在使用中：类型为博客，使用者为Smith
//网站正在使用中：类型为微信公众号，使用者为Mack
//3
```



## 6、Integer 源码分析

首先先看一段代码测试

```java
Integer x = Integer.valueOf(127);
Integer y = new Integer(127);
Integer z = Integer.valueOf(127);
Integer w = new Integer(127);
System.out.println(x.equals(y)); // true
System.out.println(x == y);      // false
System.out.println(x == z);      // true
System.out.println(w == x);      // false
System.out.println(w == y);      // false
```

我们知道：`equals`比较的是对象的内容，`==`比较的是对象的实例

- `x.equals(y)`结果为`true`：比较的是大小，所以结果为`true`
- `x == y`、`w == x`、`w == y`结果为`false`：由于 y 是 new 出来的，所以结果为`false`
- `x == z`结果为`true`：**这是为什么呢？？？**

我们追踪一下`Integer`对象的`valueOf`方法，看一下源码

![image-20211204215522874](https://s2.loli.net/2021/12/04/Qf7bJr124KyhavN.png)

这里的`low`和`high`是多少呢？

![image-20211204215651116](https://s2.loli.net/2021/12/04/mqzIcjyDXJHNfvW.png)

我们通过`IntegerCache`中源码大概基本分析出

- `low`为`-128`
- `high`为`127`

所以当`Integer`在`[-128, 127]`时，会返回`IntegerCache`的`cache[]`数组内容；否则，`valueOf`方法相当于`new Integer`了

也就是说，`Integer.valueOf(x)`方法使用的就是**享元模式** 

另外，我们也可以分析出：

- <mark>当数值范围在`[-128, 127]`时，使用`valueOf`方法执行速度比`new`更快</mark>



## 7、享元模式的注意事项和细节

- 1）在享元模式这样理解，<mark>“享”就表示共享，“元”表示对象</mark>
- 2）系统中有大量对象，这些对象消耗大量内存，并且对象的状态大部分可以外部化时，我们就可以考虑选用享元模式
- 3）用唯一标识码判断，如果在内存中有，则返回这个唯一标识码所标识的对象，用 HashMap/HashTable 存储
- 4）<mark>享元模式大大减少了对象的创建，降低了程序内存的占用，提高效率</mark>
- 5）<mark>享元模式提高了系统的复杂度，需要分离出内部状态和外部状态</mark>。而外部状态具有固化特性，不应该随着内部状态的改变而改变，这是我们使用享元模式需要注意的地方
- 6）使用享元模式时，注意划分内部状态和外部状态，并且需要有一个工厂类加以控制
- 7）<mark>享元模式经典的应用场景是需要缓冲池的场景</mark>，比如 String 常量池、数据库连接池
