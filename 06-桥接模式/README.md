>  笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 桥接模式

## 1、传统方式解决手机操作问题

现在对不同手机类型的不同品牌实现操作编程（比如：开机、关机、上网，打电话等），如图：

![image-20211020192526079](https://i.loli.net/2021/10/20/hVNkLu8QWOR9MBe.png)

**UML 类图**

![image-20211020192702004](https://i.loli.net/2021/10/20/7l4DogcRJCxOrPh.png)

**问题分析**

1. **扩展性问题（类爆炸）**：如果我们再增加手机的样式（旋转式），就需要增加各个品牌手机的类；同样如果我们增加一个手机品牌，也要在各个手机样式类下增加
2. **违反了单一职责原则**：当我们增加手机样式时，要同时增加所有品牌的手机，这样增加了代码维护成本
3. 解决方案——**使用桥接模式**



## 2、桥接模式基本介绍

1. **桥接模式（Bridge模式）：**<mark>一种结构型设计模式</mark>：将实现与抽象放在两个不同的类层次中，使两个层次可以独立改变
2. Bridge模式基于<mark>类的最小设计原则</mark>，通过使用封装、聚合及继承等行为让不同的类承担不同的职责
3. 它的主要特点是把<mark>抽象（Abstraction）与行为实现（Implementation）分离开来</mark>，从而可以保持各部分的独立性以及应对他们的功能扩展

**原理类图**

![image-20211020193532371](https://i.loli.net/2021/10/20/WBDYcv4ih3qTRm5.png)

**原理类图说明**

- **Client**：桥接模式的调用者
- **Abstraction**：Abstraction 充当桥接类，维护了 Implementor，即 ConcreteImplementorA / ConcreteImplementorB
- **RefinedAbstraction**：Abstraction 抽象类的子类
- **Implementor**：行为实现类的接口
- **ConcreteImplementorA / ConcreteImplementorB**：行为的具体实现类
- 这里的抽象类和接口是聚合的关系，也是调用者和被调用者的关系



## 3、桥接模式解决手机操作问题

**UML 类图**

![image-20211020202203186](https://i.loli.net/2021/10/20/4fFRSVWwzLcNdUi.png)

**核心代码**

```java
// 行为接口——品牌接口
public interface Branch {
    void open();

    void call();

    void close();
}
// 行为实现类——华为品牌
public class Huawei implements Branch {
    @Override
    public void open() {
        System.out.println("华为手机开机");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void close() {
        System.out.println("华为手机关机");
    }
}
// 行为实现类——小米品牌
public class Xiaomi implements Branch {
    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }
}
// 行为实现类——苹果品牌
public class iPhone implements Branch {
    @Override
    public void open() {
        System.out.println("苹果手机开机");
    }

    @Override
    public void call() {
        System.out.println("苹果手机打电话");
    }

    @Override
    public void close() {
        System.out.println("苹果手机关机");
    }
}

// 桥接类——手机抽象类
public abstract class Phone {
    private Branch branch;

    public Phone(Branch branch) {
        this.branch = branch;
    }

    public void open() {
        branch.open();
    }

    public void call() {
        branch.call();
    }

    public void close() {
        branch.close();
    }
}
// 桥接子类——翻盖式手机
public class FlipPhone extends Phone {
    public FlipPhone(Branch branch) {
        super(branch);
        System.out.println("翻盖式手机");
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    public void call() {
        super.call();
    }

    @Override
    public void close() {
        super.close();
    }
}
// 桥接子类——滑盖式手机
public class SlidePhone extends Phone {
    public SlidePhone(Branch branch) {
        super(branch);
        System.out.println("滑盖式手机");
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    public void call() {
        super.call();
    }

    @Override
    public void close() {
        super.close();
    }
}
// 桥接子类——直立式手机
public class UprightPhone extends Phone {
    public UprightPhone(Branch branch) {
        super(branch);
        System.out.println("直立式手机");
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    public void call() {
        super.call();
    }

    @Override
    public void close() {
        super.close();
    }
}
```



## 4、JDK 源码分析

JDBC 的 Driver 接口：如果从桥接模式来看，Driver 就是一个接口，下面可以有 MySQL 的 Driver、Oracle 的 Driver，这些就可以当做实现接口类

![image-20211020203253562](https://i.loli.net/2021/10/20/mvARNLYcw7z8ef3.png)

**Connection 继承体系**

![image-20211020205255371](https://i.loli.net/2021/10/20/xS6KrvtTkeLUOgy.png)

**Driver源码**

```java
public class Driver extends NonRegisteringDriver implements java.sql.Driver {
    static {
        try {
            java.sql.DriverManager.registerDriver(new Driver());
        } catch (SQLException E) {
            throw new RuntimeException("Can't register driver!");
        }
    }
    public Driver() throws SQLException {
        // Required for Class.forName().newInstance()
    }
}
```

**DriverManager 结构**

![image-20211020204343366](https://i.loli.net/2021/10/20/CPBiVY6y7fSmXWg.png)

**说明**

- MySQL 有自己的 Connectionlmpl 类，同样 Oracle 也有对应的实现类
- Driver 和 Connection 之间是通过 DriverManager 类进行桥连接的



## 5、注意事项和细节

1. <mark>实现了抽象和实现部分的分离</mark>，从而极大的提供了系统的灵活性，让抽象部分和实现部分独立开来。这有助于系统进行<mark>分层设计</mark>，从而产生更好的<mark>结构化系统</mark>
2. 对于系统的高层部分，只需要知道抽象部分和实现部分的接口就可以了，其它的部分由具体业务来完成
3. 桥接模式替代<mark>多层继承方案</mark>，可以减少子类的个数，降低系统的管理和维护成本
4. 桥接模式的引入增加了系统的理解和设计难度，由于聚合关联关系建立在抽象层，要求开发者针<mark>对抽象进行设计和编程</mark>
5. 桥接模式要求正确识别出系统中两个独立变化的维度，因此其使用范围有一定的后限性，即需要有这样的应用场景



## 6、桥接模式其他应用场景

对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥接模式尤为适用

常见的应用场景

1. JDBC 驱动程序
2. 银行转账系统
   - 转账分类：网上转账、柜台转账、AMT 转账
   - 转账用户类型：普通用户、银卡用户、金卡用户
3. 消息管理
   - 消息类型：即时消息、延时消息
   - 消息分类：手机短信、邮件消息、QQ消息…