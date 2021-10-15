> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# Java设计模式简介



## 1、设计模式的重要性

---

1）软件工程中，设计模式（design pattern）是对软件设计中普遍存在（反复出现）的各种问题，所提出的解决方案。

这个术语是由埃里希.伽玛（Erich Gamma）等人在1990年代从建筑设计领域引入到计算机科学的

2）大厦VS简易房

![image-20210915185536693](https://i.loli.net/2021/09/15/dU12njgvitZqc6M.png)

3）拿实际工作经历来说，当一个项目开发完后，如果客户提出增新功能，怎么办？

4）如果项目开发完后，原来程序员离职，你接手维护该项目怎么办？（维护性、可读性、规范性）

5）目前程序员门槛越来越高，一线 IT 公司（大厂），都会问你在实际项目中使用过什么设计模式，怎样使用的，解决了什么问题。

6）设计模式在软件中哪里？面向对象【OO】=》功能模块【设计模式 + 算法（数据结构）】=》框架【多种设计模式】=》架构【服务器集群】

7）如果想成为合格软件工程师，那就花时间来研究下设计模式是非常必要的



## 2、设计模式面试题

---

**原型设计模式**

- 1）有请使用 UML 类图画出原型模式核心角色

- 2）原型设计模式的深拷贝和浅拷贝是什么，并写出深拷贝的两种方式的源码（重写 clone 方法实现深拷贝、使用序列化来实现深拷贝）

- 3）在 Spring 框架中哪里使用到原型模式，并对源码进行分析

- 4）Spring 中原型 bean 的创建，就是原型模式的应用

- 5）代码分析 + Debug 源码

  ![image-20210913221302650](https://i.loli.net/2021/09/13/wDnR6PFufvY4Ndb.png)

**设计模式七大原则**

- 1）<mark>单一职责原则</mark>
- 2）<mark>接口隔离原则</mark>
- 3）<mark>依赖倒转原则</mark>
- 4）<mark>里氏替换原则</mark>
- 5）<mark>开闭原则（OCP）</mark>
- 6）<mark>迪米特法则</mark>
- 7）<mark>合成复用原则</mark>

要求：

- 1）七大设计原则核心思想
- 2）能够以类图的说明设计原则
- 3）在项目实际开发中，你在哪里使用到了 OCP 原则

**状态模式**

金融借贷平台项目：借贷平台的订单，有审核-发布-抢单等等步骤，随着操作的不同，会改变订单的状态，项目中的这个模块实现就会使用到状态模式，请你使用状态模式进行设计，并完成实际代码

问题分析：这类代码难以应对变化，在添加一种状态时，我们需要手动添加 if/else ，在添加一种功能时，要对所有的状态进行判断。因此代码会变得越来越臃肿，并且一旦没有处理某个状态，便会发生极其严重的BUG，难以维护

**解释器设计模式**

- 1）介绍解释器设计模式是什么？

- 2）画出解释器设计模式的 UML 类图，分析设计模式中的各个角色是什么？

  ![image-20210913223111095](https://i.loli.net/2021/09/13/ew51YzWvuPJIpXo.png)

- 3）请说明 Spring 的框架中，哪里使用到了解释器设计模式，并做源码级别的分析

  ![](https://i.loli.net/2021/09/13/ew51YzWvuPJIpXo.png)

**单例设计模式**

单例设计模式一共有几种实现方式？请分别用代码实现，并说明各个实现方式的优点和实点？

单例设计模式一共有8种写法，后面我们会依次讲到

- 1）<mark>饿汉式 两种</mark>
- 2）<mark>懒汉式 三种</mark>
- 3）<mark>双重检查</mark>
- 4）<mark>静态内部类</mark>
- 5）<mark>枚举</mark>

![image-20210913225416112](https://i.loli.net/2021/09/13/ZsjaXSHynLxmvNe.png)



## 3、设计模式七大原则

---

### 设计模式目的

编写软件过程中，程序员面临着来自<mark>耦合性，内聚性以及可维护性，可扩展性，重用性，灵活性</mark>等多方面的挑战

设计模式是为了让程序（软件），具有更好的

- 1）<mark>可复用性</mark>（即：相同功能的代码，不用多次编写，也叫做代码重用性）
- 2）<mark>可读性</mark>（即：编程规范性，便于其他程序员的阅读和理解）
- 3）<mark>可扩展性</mark>（即：当需要增加新的功能时，非常的方便，也叫做可维护性）
- 4）<mark>可靠性</mark>（即：当我们增加新的功能后，对原来的功能没有影响）
- 5）使程序呈现<mark>高内聚，低耦合</mark>的特性

**分享金句**

设计模式包含了面向对象的精髓，“懂了设计模式，你就懂了面向对象分析和设计（OOA/D）的精要”

Scott Mavers 在其巨著《Effective C++》就曾经说过：C++ 老手和 C++ 新手的区别就是前者手背上有很多伤疤

### 设计模式七大原则

设计模式原则，其实就是程序员在编程时，应当遵守的原则，也是各种设计模式的基础（即：设计模式为什么这样设计的依据）设计模式

常用的七大原则有：

- 1）<mark>单一职责原则</mark>
- 2）<mark>接口隔离原则</mark>
- 3）<mark>依赖倒转原则</mark>
- 4）<mark>里氏替换原则</mark>
- 5）<mark>开闭原则</mark>
- 6）<mark>迪米特法则</mark>
- 7）<mark>合成复用原则</mark>

### 3.1、单一职责原则（Single Responsibility Principle）

**基本介绍**

对类来说的，即一个类应该只负责一项职责。如类A负责两个不同职责：职责1，职责2。当职责1需求变更而改变A时，可能造成职责2执行错误，所以需要将类A的粒度分解为A1，A2

**应用实例**

1）以交通工具案例讲解

2）看老师代码演示

3）方案1[分析说明]

```java
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("轮船");
        vehicle.run("飞机");
    }
}

/**
 * 方式1的分析
 * 1.在方式1的run方法中，违反了单一职责原则
 * 2.解决的方案非常的简单，根据交通工具运行方法不同，分解成不同类即可
 */
class Vehicle{
    public void run(String type){
        if ("汽车".equals(type)) {
            System.out.println(type + "在公路上运行...");
        } else if ("轮船".equals(type)) {
            System.out.println(type + "在水面上运行...");
        } else if ("飞机".equals(type)) {
            System.out.println(type + "在天空上运行...");
        }
    }
}
```

4）方案2[分析说明]

```java
public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("汽车");
        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }
}

/**
 * 方案2的分析
 * 1.遵守单一职责原则
 * 2.但是这样做的改动很大，即将类分解，同时修改客户端
 * 3.改进：直接修改Vehicle类，改动的代码会比较少=>方案3
 */
class RoadVehicle{
    public void run(String type){
        System.out.println(type + "在公路上运行...");
    }
}
class WaterVehicle{
    public void run(String type){
        System.out.println(type + "在水面上运行...");
    }
}
class AirVehicle{
    public void run(String type){
        System.out.println(type + "在天空上运行...");
    }
}
```

- 5）方案3[分析说明]

```java
public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.run("汽车");
        vehicle.runWater("轮船");
        vehicle.runAir("飞机");
    }
}

/**
 * 方式3的分析
 * 1.这种修改方法没有对原来的类做大的修改，只是增加方法
 * 2.这里虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上，仍然是遵守单一职责
 */
class Vehicle2{
    public void run(String type){
        System.out.println(type + "在公路上运行...");
    }
    public void runWater(String type){
        System.out.println(type + "在水面上运行...");
    }
    public void runAir(String type){
        System.out.println(type + "在天空上运行...");
    }
}
```

**总结**

- 类分解，可能成本较高
- 解决方案：不在类级别上“单一职责”，往下沉，在方法级别上“单一职责”

**注意事项和细节**

- 1）降低类的复杂度，<mark>一个类只负责一项职责</mark>
- 2）提高类的<mark>可读性，可维护性</mark>
- 3）降低变更引起的风险
- 4）通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码级违反单一职责原则；只有类中方法数量足够少，可以在方法级别保持单一职责原则

###  3.2、接口隔离原则（Interface Segregation Principle）

**基本介绍**

- 1）客户端不应该依赖它不需要的接口，即<mark>一个类对另一个类的依赖应该建立在最小的接口上</mark>
- 2）先看一张图

![image-20211010105008455](https://i.loli.net/2021/10/10/B351ahicK9sFqf2.png)

- 3）类 A 通过接口 Interface1 依赖类 B，类 C 通过接口 Interface1 依赖类 D，如果接口 Interface1 对于类 A 和类 C 来说不是最小接口，那么类 B 和类 D 必须去实现他们不需要的方法
- 4）按隔离原则应当这样处理：将接口 Interface1 拆分为独立的几个接口，类 A 和类 C 分别与他们需要的接口建立依赖关系。也就是采用接口隔离原则

**应用实例**

- 1）类 A 通过接口 Interface1 依赖类 B，类 C 通过接口 Interface1 依赖类 D，请编写代码完成此应用实例
- 2）看老师代码

![image-20211010110122468](https://i.loli.net/2021/10/10/Cc6gRd9JzGbZ2ra.png)

```java
interface Interface1 {
    void operation1();

    void operation2();

    void operation3();

    void operation4();

    void operation5();
}

class B implements Interface1 {

    @Override
    public void operation1() {
        System.out.println("B 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了 operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B 实现了 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B 实现了 operation5");
    }
}

class D implements Interface1 {

    @Override
    public void operation1() {
        System.out.println("D 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D 实现了 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D 实现了 operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D 实现了 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了 operation5");
    }
}

/**
 * A类通过接口Interface1依赖（使用）B类，但是只会用到1，2，3方法
 */
class A {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface1 i) {
        i.operation2();
    }

    public void depend3(Interface1 i) {
        i.operation3();
    }
}

/**
 * C类通过接口Interface1依赖（使用）D类，但是只会用到1，4，5方法
 */
class C {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface1 i) {
        i.operation4();
    }

    public void depend5(Interface1 i) {
        i.operation5();
    }
}
```

**问题与改进**

- 1）类 A 通过接口 Interface1 依赖类 B，类 C 通过接口 Interface1 依赖类 D，如果接口 Interface1 对于类 A 和类 C 来说不是最小接口，那么类 B 和类 D 必须去实现他们不需要的方法
- 2）将接口 Interface1 拆分为独立的几个接口，类 A 和类 C 分别与他们需要的接口建立依赖关系。也就是采用接口隔离原则
- 3）接口 Interface1 中出现的方法，根据实际情况拆分为三个接口 
- 4）代码实现

![image-20211010134926811](https://i.loli.net/2021/10/10/MvjNIKDWGyba3ZS.png)

```java
interface Interface1 {
    void operation1();
}

interface Interface2 {
    void operation2();

    void operation3();
}

interface Interface3 {
    void operation4();

    void operation5();
}

class B implements Interface1, Interface2 {

    @Override
    public void operation1() {
        System.out.println("B 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了 operation3");
    }
}

class D implements Interface1, Interface3 {

    @Override
    public void operation1() {
        System.out.println("D 实现了 operation1");
    }

    @Override
    public void operation4() {
        System.out.println("D 实现了 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了 operation5");
    }
}

/**
 * A类通过接口Interface1,Interface2依赖（使用）B类，但是只会用到1，2，3方法
 */
class A {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface2 i) {
        i.operation2();
    }

    public void depend3(Interface2 i) {
        i.operation3();
    }
}

/**
 * C类通过接口Interface1,Interface3依赖（使用）D类，但是只会用到1，4，5方法
 */
class C {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface3 i) {
        i.operation4();
    }

    public void depend5(Interface3 i) {
        i.operation5();
    }
}
```

### 3.3、依赖倒转原则（Dependence Inversion Principle）

**基本介绍**

- 1）<mark>高层模块不应该依赖低层模块，二者都应该依赖其抽象</mark>
- 2）抽象不应该依赖细节，<mark>细节应该依赖抽象</mark>
- 3）依赖倒转（倒置）的中心思想是<mark>面向接口编程</mark>
- 4）依赖倒转原则是基于这样的设计理念：相对于细节的多变性，抽象的东西要稳定的多。以抽象为基础搭建的架构比以细节为基础的架构要稳定的多。<mark>在java中，抽象指的是接口或抽象类，细节就是具体的实现类</mark>
- 5）使用接口或抽象类的目的是<mark>制定好规范</mark>，而不涉及任何具体的操作，把展现细节的任务交给他们的实现类去完成

**应用实例**

1）请编程完成 Person 接收消息的功能

2）实现方案 1 + 分析说明

```java
/**
 * 方式1分析
 * 1.简单，比较容易想到
 * 2.如果我们获取的对象是微信，短信等等，则新增类，同时 Peron也要增加相应的接收方法
 * 3.解决思路：
 * 引入一个抽象的接口IReceiver，表示接收者，这样Person类与接口IReceiver发生依赖
 * 因为Email，Weixin等等属于接收的范围，他们各自实现IReceiver接口就ok，这样我们就符号依赖倒转原则
 */
class Email {
    public String getInfo() {
        return "电子邮件信息：Hello World！";
    }
}

class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
```

3）实现方案 2 + 分析说明 

```java
interface IReceiver {
    String getInfo();
}

class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件信息：Hello World！";
    }
}

class Weixin implements IReceiver {
    @Override
    public String getInfo() {
        return "微信消息：Hello World！";
    }
}

class ShortMessage implements IReceiver {
    @Override
    public String getInfo() {
        return "短信信息：Hello World！";
    }
}

class Person {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
```

### 依赖关系传递的三种方式

**1）接口传递**

```java
//方式1：通过接口传递实现依赖
//开关的接口
interface IOpenAndClose {
    void open(ITV tv);//抽象方法，接收接口
}
//ITV接口
interface ITV {
    void play();
}
//实现接口
class OpenAndClose implements IOpenAndClose {
    public void open(ITV tv){
        tv.play();
    }
}
```

**2）构造方法传递**

```java
//方式2：通过构造函数实现依赖
//开关的接口
interface IOpenAndClose {
    void open();//抽象方法
}
//ITV接口
interface ITV {
    public void play();
}
//实现接口
class OpenAndClose implements IOpenAndClose {
    private ITV tv; // 成员
    
    public OpenAndClose(ITV tv){ // 构造器
        this.tv = tv;
    }
    
    public void open(){
        this.tv.play();
    }
}
```

**3）setter 方式传递**

```java
//方式3，通过setter方法传递
interface IOpenAndClose{
    void open();//抽象方法
    void setTv(ITV tv);
}
//ITV接口
interface ITV{
    void play();
}
//实现接口
class OpenAndClose implements IOpenAndClose{
    private ITV tv;
    public void setTv(ITV tv){
        this.tv=tv;
    }
    public void open(){
        this.tv.play();
    }
}
```

**注意事项和细节**

- 1）<mark>低层模块尽量都要有抽象类或接口</mark>，或者两者都有，程序稳定性更好
- 2）<mark>变量的声明类型尽量是抽象类或接口</mark>，这样我们的变量引用和实际对象间，就存在一个缓冲层，利于程序扩展和优化
- 3）<mark>继承时遵循里氏替换原则</mark>

### 3.4、里氏替换原则（Liskov Substitution Principle）

**OO 中继承性的思考和说明**

- 1）继承包含这样一层含义：父类中凡是已经实现好的方法，实际上是在<mark>设定规范和契约</mark>，虽然它不强制要求所有的子类必须遵循这些契约，但是如果子类对这些已经实现的方法任意修改，就会对整个继承体系造成破坏
- 2）<mark>继承在给程序设计带来便利的同时，也带来了弊端。比如使用继承会给程序带来侵入性，程序的可移植性降低，增加对象间的耦合性</mark>，如果一个类被其他的类所继承，则当这个类需要修改时，必须考虑到所有的子类，并且父类修改后，所有涉及到子类的功能都有可能产生故障
- 3）问题提出：在编程中，<mark>如何正确使用继承？=>里氏替换原则</mark>

**基本介绍**

- 1）里氏替换原则在1988年，由麻省理工学院的以为姓里的女士提出的
- 2）如果对每个类型为 T1 的对象 o1，都有类型为 T2 的对象 o2，使得以 T1 定义的所有程序 P 在所有的对象 o1 都代换成 o2 时，程序 P 的行为没有发生变化，那么类型 T2 是类型 T1 的子类型。换句话说，<mark>所有引用基类的地方必须能透明地使用其子类的对象</mark>
- 3）在使用继承时，遵循里氏替换原则，<mark>在子类中尽量不要重写父类的方法</mark>
- 4）里氏替换原则告诉我们，继承实际上让两个类耦合性增强了，在适当的情况下，<mark>可以通过聚合、组合、依赖来解决问题</mark>

**一个程序引出的问题和思考**

先看个程序，思考下问题和解决思路

```java
public void test() {
    A a = new A();
    System.out.println("11-3=" + a.func1(11, 3));
    System.out.println("1-8=" + a.func1(1, 8));
    System.out.println("---------------------");

    B b = new B();
    System.out.println("11-3=" + b.func1(11, 3));
    System.out.println("1-8=" + b.func1(1, 8));
    System.out.println("11+3+9=" + b.func2(11, 3));
}

class A {
    //返回两个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends A {
    @Override
    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    //增加了一个新功能：完成两个数相加，然后和9求和
    public int func2(int num1, int num2) {
        return func1(num1, num2) + 9;
    }
}
```

**解决方法**

1）我们发现原来运行正常的相减功能发生了错误。原因就是类 B 无意中重写了父类的方法，造成原有功能出现错误。在实际编程中，我们常常会通过重写父类的方法完成新的功能，这样写起来虽然简单，但整个继承体系的复用性会比较差。特别是运行多态比较频繁的时候

2）通用的做法是：<mark>原来的父类和子类都继承一个更通俗的基类，原有的继承关系去掉，采用依赖、聚合、组合等关系代替</mark>

3）改进方案

![image-20211010151710127](https://i.loli.net/2021/10/10/RCdgm9QWfl2Gr6o.png)

```java
//创建一个更加基础的基类
class Base {
    //将更基础的成员和方法写到Base类中
}

class A extends Base {
    //返回两个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends Base {
    //如果B需要使用A类的方法，使用组合关系
    private A a;

    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    //增加了一个新功能：完成两个数相加，然后和9求和
    public int func2(int num1, int num2) {
        return func1(num1, num2) + 9;
    }

    public int func3(int num1, int num2) {
        return this.a.func1(num1, num2);
    }
}
```

### 3.5、开闭原则（Open Closed Principle）

**基本介绍**

- 1）开闭原则是编程中<mark>最基础、最重要</mark>的设计原则
- 2）一个软件实体如类、模块和函数应该<mark>对扩展开放（对提供者而言），对修改关闭（对使用者而言）</mark>。<mark>用抽象构建框架，用实现扩展细节</mark>
- 3）当软件需要变化时，尽量<mark>通过扩展软件实体的行为来实现变化，而不是通过修改已有的代码来实现变化</mark>
- 4）编程中遵循其它原则，以及使用<mark>设计模式的目的就是遵循开闭原则</mark>

**看一段代码**

一个画图形的功能，类图设计如下：

![image-20211010153848077](https://i.loli.net/2021/10/10/FaqAJDOwiYc4BKl.png)

```java
class GraphicEditor {
    public void drawShape(Shape s) {
        if (s.m_type == 1) {
            drawRectangle(s);
        } else if (s.m_type == 2) {
            drawCircle(s);

        } else if (s.m_type == 3) {
            drawTriangle(s);
        }
    }

    public void drawRectangle(Shape r) {
        System.out.println("矩形");
    }

    public void drawCircle(Shape r) {
        System.out.println("圆形");
    }

    public void drawTriangle(Shape r) {
        System.out.println("三角形");
    }
}

class Shape {
    public int m_type;
}

class RectangleShape extends Shape {
    RectangleShape() {
        m_type = 1;
    }
}

class CircleShape extends Shape {
    CircleShape() {
        m_type = 2;
    }
}

class TriangleShape extends Shape {
    TriangleShape() {
        m_type = 3;
    }
}
```

**方式 1 的优缺点**

- 1）优点是比较好理解，简单易操作
- 2）缺点是违反了设计模式的 OCP 原则，即对扩展开放（提供方），对修改关闭（使用方）。即当我们给类增加新功能的时喉，尽量不修改代码，或者尽可能少修改代码
- 3）比如我们这时要新增加一个图形种类，我们需要做如下修改，修改的地方较多4）代码演示

**方式 1 的改进的思路分析**

把创建 Shape 类做成抽象类，并提供一个抽象的 draw 方法，让子类去实现即可

这样我们有新的图形种类时，只需要让新的图形类继承 Shape，并实现 draw 方法即可

使用方的代码就不需要修改，满足了开闭原则

**方式 2 来解决**

1）方式 2 的设计方案：定义一个 Shape 抽象类

2）看代码示例

```java
class GraphicEditor {
    public void drawShape(Shape s) {
        s.draw();
    }
}

abstract class Shape {
    int m_type;

    public abstract void draw();
}

class RectangleShape extends Shape {
    RectangleShape() {
        m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("矩形");
    }
}

class CircleShape extends Shape {
    CircleShape() {
        m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("圆形");
    }
}

class TriangleShape extends Shape {
    TriangleShape() {
        m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println("三角形");
    }
}
```

3）从方式 2 看，代码满足了 OCP 原则

### 3.6、迪米特法则（Demeter Principle）

**基本介绍**

- 1）一个对象应该对其他对象保持最少的了解
- 2）类与类关系越密切，耦合度越大
- 3）迪米特法则又叫<mark>最少知道原则</mark>，即一个类对自己依赖的类知道的越少越好。也就是说，<mark>对于被依赖的类不管多么复杂，都尽量将逻辑封装在类的内部。对外除了提供的 public 方法，不对外泄露任何信息</mark>
- 4）迪米特法则还有个更简单的定义：只与直接的朋友通信
- 5）<mark>直接的朋友</mark>：每个对象都会与其他对象有耦合关系，只要两个对象之间有耦合关系，我们就说这两个对象之间是朋友关系。耦合的方式很多：依赖、关联、组合、聚合等。其中，我们称出现<mark>成员变量，方法参数，方法返回值中的类为直接的朋友，而出现在局部变量中的类不是直接的朋友</mark>。也就是说，<mark>陌生的类最好不要以局部变量的形式出现在类的内部</mark>

**应用实例**

1）有一个学校，下属有各个学院和总部，现要求打印出学校总部员工 ID 和学院员工的 id

2）编程实现上面的功能，看代码演示

```java
//总部员工
class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

//学院员工
class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

//学院员工管理 类
class CollegeManager {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<>();
        CollegeEmployee collegeEmployee;
        for (int i = 0; i < 10; i++) {
            collegeEmployee = new CollegeEmployee();
            collegeEmployee.setId("学院员工id=" + i);
            list.add(collegeEmployee);
        }
        return list;
    }
}

//总部员工管理类
class SchoolManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        Employee employee;
        for (int i = 0; i < 5; i++) {
            employee = new Employee();
            employee.setId("总部员工id=" + i);
            list.add(employee);
        }
        return list;
    }

    public void printAllEmployee(CollegeManager sub) {
        System.out.println("--------------学院员工--------------");
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        for (CollegeEmployee collegeEmployee : list1) {
            System.out.println(collegeEmployee.getId());
        }
        System.out.println("---------------总部员工-------------");
        List<Employee> list2 = this.getAllEmployee();
        for (Employee employee : list2) {
            System.out.println(employee.getId());
        }
    }
}
```

**应用实例改进**

- 1）前面设计的问题在于 SchoolManager 中，CollegeEmployee 类并不是 SchoolManager 类的直接朋友（分析）
- 2）按照迪米特法则，应该避免类中出现这样非直接朋友关系的耦合
- 3）对代码按照迪米特法则进行改进（看老师演示）

**注意事项和细节**

- 1）迪米特法则的核心是<mark>降低类之间的耦合</mark>
- 2）但是注意：由于每个类都减少了不必要的依赖，因此迪米特法则只是要求降低类间（对象间）耦合关系，并不是要求完全没有依赖关系

### 3.7、合成复用原则（Composite Reuse Principle）

**基本介绍**

原则是<mark>尽量使用合成/聚合的方式，而不是使用继承</mark>

![image-20211010164923202](C:/Users/Archimedes/AppData/Roaming/Typora/typora-user-images/image-20211010164923202.png)

### 设计原则核心思想

- 1）找出应用中<mark>可能需要变化之处，把它们独立出来</mark>，不要和那些不需要变化的代码混在一起
- 2）<mark>针对接口编程</mark>，而不是针对实现编程
- 3）为了交互对象之间的<mark>松耦合</mark>设计而努力



## 4、UML 类图

### UML 基本介绍

- 1）UML—-Unified modeling language UML（<mark>统一建模语言</mark>），是一种用于软件系统分析和设计的语言工具，它用于帮助软件开发人员进行思考和记录思路的结果

- 2）UML 本身是一套符号的规定，就像数学符号和化学符号一样，这些符号用于描述软件模型中的各个元素和他们之间的关系，比如类、接口、实现、泛化、依赖、组合、聚合等

![image-20211010170115892](C:/Users/Archimedes/AppData/Roaming/Typora/typora-user-images/image-20211010170115892.png)

- 3）使用 UML 来建模，常用的工具有 Rational Rose，也可以使用一些插件来建模

![image-20211010165611560](https://i.loli.net/2021/10/10/yvQiVlkm4D13dZN.png)

### UML 图

画 UML 图与写文章差不多，都是把自己的思想描述给别人看，关键在于思路和条理，UML图分类：

- 1）<mark>用例图</mark>（use case）
- 2）<mark>静态结构图：**类图**、对象图、包图、组件图、部署图</mark>
- 3）<mark>动态行为图：交互图（时序图与协作图）、状态图、活动图</mark>

**说明**

- 1）类图是描述类与类之间的关系的，是 UML 图中最核心的
- 2）在讲解设计模式时，我们必然会使用类图，为了让学员们能够把设计模式学到位，需要先给大家讲解类图
- 3）温馨提示：如果已经掌握 UML 类图的学员，可以直接听设计模式的章节

### UML 类图

- 1）用于描述系统中的类（对象）本身的组成和类（对象）之间的各种静态关系
- 2）类之间的关系：<mark>依赖、泛化（继承）、实现、关联、聚合与组合</mark>
- 3）类图简单举例

```java
public class Person {
    private Integer id;
    private String name;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
```

![image-20211010171055294](https://i.loli.net/2021/10/10/ouU9Jefp1QSWzqF.png)

### 4.1、类图——依赖（dependence）

<mark>只要是在类中用到了对方，那么他们之间就存在依赖关系</mark>。如果没有对方，连编译都通过不了

```java
public class PersonServiceBean {
    // 类的成员属性
    private PersonDao personDao;

    // 方法接收的参数类型
    public void save(Person person) {
    }

    // 方法的返回类型
    public IDCard getIDCard(Integer personid) {
        return null;
    }

    // 方法中使用到
    public void modify() {
        Department department = new Department();
    }

}
```

**UML 类图**

![Package dependence](https://i.loli.net/2021/10/11/lUJKYBCsefr2Qzp.png)

**小结**

- 1）类中用到了对方
- 2）类的成员属性
- 3）方法的返回类型
- 4）方法接收的参数类型
- 5）方法中使用到

### 4.2、类图——泛化（Generalization）

<mark>泛化关系实际上就是继承关系</mark>，它是依赖关系的特例

```java
public abstract class DaoSupport {
    public void save(Object entity) {
    }

    public void delete(Object id) {
    }
}
public class PersonServiceBean extends DaoSupport {
}
```

**UML 类图**

![Package generalization](https://i.loli.net/2021/10/11/VUGDcRHgQNmhq5s.png)

**小结**

- 1）泛化关系实际上就是继承关系
- 2）如果 A 类继承了 B 类，我们就说 A 和 B 存在泛化关系

### 4.3、类图——实现（Implementation）

<mark>实现关系实际上就是 A 类实现 B 类</mark>，它是依赖关系的特例

```java
public interface PersonService {
    void delete(Integer id);
}
public class PersonServiceBean implements PersonService {
    @Override
    public void delete(Integer id) {
        System.out.println("delete...");
    }
}
```

**UML 类图**

![Package implementation](https://i.loli.net/2021/10/11/FI8D3YXkr6fvHTS.png)

### 4.4、类图——关联（Association）

<mark>关联关系实际上就是类与类之间的联系</mark>，它是依赖关系的特例

- <mark>关联具有导航性</mark>：即双向关系或单向关系
- <mark>关系具有多重性</mark>：如“1”（表示有且仅有一个），“0...”（表示0个或者多个），“0，1”（表示0个或者一个），“n...m”（表示n到m个都可以），“m...*”（表示至少m个）

![image-20211011211125957](https://i.loli.net/2021/10/11/BrpbU2NcgERuvIH.png)

#### 单向一对一关系

```java
public class Person {
	private IDCard card;
}
public class IDCard {}
```

**UML 类图**

![Package unidirectional121](https://i.loli.net/2021/10/11/9RTOIJLBYCu7zvF.png)

#### 双向一对一关系

```java
public class Person {
	private IDCard card;
}
public class IDCard {
	private Person person;
}
```

**UML 类图**

![Package bidirectional121](https://i.loli.net/2021/10/11/PtBlruFH4AQ9no1.png)

### 4.5、类图——聚合（Aggregation）

<mark>聚合关系表示的是整体和部分的关系，整体与部分可以分开</mark>。聚合关系是关联关系的特例，所以它具有关联的导航性与多重性

如：一台电脑由键盘（keyboard）、显示器（monitor），鼠标等组成；组成电脑的各个配件是可以从电脑上分离出来的，使用带空心菱形的实线来表示：

![image-20211011211749247](https://i.loli.net/2021/10/11/Gi7SjJWyb1z35fm.png)

```java
public class Mouse {}
public class Monitor {}
public class Computer {
    private Mouse mouse;
    private Monitor monitor;

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}
```

**UML 类图**

![Package aggregation](https://i.loli.net/2021/10/11/qMQnyCLclTfwIHP.png)

### 4.6、类图——组合（Composition）

<mark>组合关系也是整体与部分的关系，但是整体与部分不可以分开</mark>

如果我们认为 Mouse、Monitor 和 Computer 是不可分离的，则升级为组合关系

```java
public class Mouse {}
public class Monitor {}
public class Computer {
    private Mouse mouse = new Mouse();
    private Monitor monitor = new Monitor();
}
```

**UML 类图**

![composition](https://i.loli.net/2021/10/11/VfhSGclMY5rIz3s.png)

再看一个案例，在程序中我们定义实体：Person 与 IDCard、Head，那么 Head 和 Person 就是组合，IDCard 和 Person 就是聚合

```java
public class IDCard{}
public class Head{}
public class Person{
    private IDCard card;
    private Head head = new Head();
}
```

**UML 类图**

![image-20211011215441995](https://i.loli.net/2021/10/11/dIOPNtgUzZw6D1T.png)

但是如果在程序中，Person 实体中定义了对 IDCard 进行级联删除，即删除 Person 时连同 IDCard 一起删除，那么 IDCard 和 Person 就是组合了



## 5、设计模式概述和分类

### 5.1、设计模式层次

- 1）第1层：刚开始学编程不久，听说过什么是设计模式
- 2）第2层：有很长时间的编程经验，自己写了很多代码，其中用到了设计模式，但是自己却不知道
- 3）第3层：学习过了设计模式，发现自己已经在使用了，并且发现了一些新的模式挺好用的
- 4）第4层：阅读了很多别人写的源码和框架，在其中看到别人设计模式，并且能够领会设计模式的精妙和带来的好处
- 5）第5层：代码写着写着，自己都没有意识到使用了设计模式，并且熟练的写了出来

### 5.2、设计模式介绍

- 1）设计模式是程序员在面对同类软件工程设计问题所总结出来的有用的经验。<mark>模式不是代码，而是某类问题的通用解决方案</mark>，设计模式（Design pattern）代表了<mark>最佳实践</mark>。这些解决方案是众多软件开发人员经过相当长的一段时间的试验和错误总结出来的
- 2）设计模式的本质<mark>提高软件的维护性、通用性和扩展性，并降低软件的复杂度</mark>
- 3）《设计模式》是经典的书，作者是 Erich Gamma、Richard Helm、Ralph Johnson 和 John Vlissides Design（俗称“四人组GOF”）
- 4）设计模式并不局限于某种语言，Java、PHP、C++ 都有设计模式

### 5.3、设计模式类型

设计模式分为至种类型，共 23 种

- 1）**创建型模式**：<mark>单例模式</mark>、抽象工厂模式、原型模式、建造者模式、<mark>工厂模式</mark>
- 2）**结构型模式**：适配器模式、桥接模式、<mark>装饰模式</mark>、组合模式、外观模式、享元模式、<mark>代理模式</mark>
- 3）**行为型模式**：模版方法模式、命令模式、访问者模式、迭代器模式、<mark>观察者模式</mark>、中介者模式、备忘录模式、解释器模式（Interpreter 模式）、状态模式、策略模式、职责链模式（责任链模式）

注意：不同的书籍上对分类和名称略有差别



## 6、单例模式

所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类<mark>只能存在一个对象实例</mark>，并且该类只提供一个取得其对象实例的方法（静态方法）

比如 Hibernate 的 SessionFactory，它充当数据存储源的代理，并负责创建 Session 对象。SessionFactory 并不是轻量级的，一般情况下，一个项目通常只需要一个 SessionFactory 就够，这是就会使用到单例模式

### 八种方式

- 1）<mark>饿汉式（静态常量）</mark>
- 2）<mark>饿汉式（静态代码块）</mark>
- 3）<mark>懒汉式（线程不安全）</mark>
- 4）<mark>懒汉式（线程安全，同步方法）</mark>
- 5）<mark>懒汉式（线程安全，同步代码块）</mark>
- 6）<mark>双重检查</mark>
- 7）<mark>静态内部类</mark>
- 8）<mark>枚举</mark>

### 6.1、饿汉式（静态常量）

- 1）构造器私有化（防止外部 new）
- 2）类的内部创建对象
- 3）向外暴露一个静态的公共方法 getInstance

```java
public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、类的内部创建对象
    private static final Singleton instance = new Singleton();

    // 3、向外暴露一个静态的公共方法
    public static Singleton getInstance() {
        return instance;
    }
}
```

**优缺点**

- 1）优点：这种写法比较简单，就是在类装载的时候就完成实例化。<mark>避免了线程同步问题</mark>
- 2）缺点：在类装载的时候就完成实例化，<mark>没有达到 Lazy Loading 的效果</mark>。如果从始至终从未使用过这个实例，则会<mark>造成内存的浪费</mark>
- 3）这种方式基于 classloder 机制避免了多线程的同步问题。不过，instance 在类装载时就实例化，在单例模式中大多数都是调用getlnstance 方法，但是导致类装载的原因有很多种，因此不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 就没有达到 Lazy loading 的效果
- 4）结论：这种单例模式可用，可能造成内存浪费

### 6.2、饿汉式（静态代码块）

- 1）构造器私有化
- 2）类的内部声明对象
- 3）在静态代码块中创建对象
- 4）向外暴露一个静态的公共方法

```java
public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、类的内部声明对象
    private static Singleton instance;

    // 3、在静态代码块中创建对象
    static {
        instance = new Singleton();
    }

    // 4、向外暴露一个静态的公共方法
    public static Singleton getInstance() {
        return instance;
    }
}
```

**优缺点**

- 1）这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
- 2）结论：这种单例模式可用，但是可能造成内存浪费

### 6.3、懒汉式（线程不安全）

- 1）构造器私有化
- 2）类的内部创建对象
- 3）向外暴露一个静态的公共方法，当使用到该方法时，才去创建 instance

```java
// 1、构造器私有化
private Singleton() {
}

// 2、类的内部声明对象
private static Singleton instance;

// 3、向外暴露一个静态的公共方法，当使用到该方法时，才去创建 instance
public static Singleton getInstance() {
    if (instance == null) {
        instance = new Singleton();
    }
    return instance;
}
```

**优缺点**

- 1）<mark>起到了 Lazy Loading 的效果，但是只能在单线程下使用</mark>
- 2）如果在多线程下，一个线程进入了判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例
- 3）结论：在实际开发中，不要使用这种方式

### 6.4、懒汉式（线程安全，同步方法）

- 1）构造器私有化
- 2）类的内部创建对象
- 3）向外暴露一个静态的公共方法，加入同步处理的代码，解决线程安全问题

```java
public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、类的内部声明对象
    private static Singleton instance;

    // 3、向外暴露一个静态的公共方法，加入同步处理的代码，解决线程安全问题
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

**优缺点**

- 1）<mark>解决了线程不安全问题</mark>
- 2）<mark>效率太低</mark>了，每个线程在想获得类的实例时候，执行`getlnstance()`方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接`return`就行了。方法进行同步效率太低
- 3）结论：在实际开发中，不推荐使用这种方式

### 6.5、懒汉式（线程安全，同步代码块）

- 1）构造器私有化
- 2）类的内部创建对象
- 3）向外暴露一个静态的公共方法，加入同步处理的代码块

```java
public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、类的内部声明对象
    private static Singleton instance;

    // 3、向外暴露一个静态的公共方法，加入同步处理的代码，解决线程安全问题
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
```

**优缺点**

- 1）这种方式，本意是想对第四种实现方式的改进，因为前面同步方法效率太低，改为同步产生实例化的的代码块
- 2）但是这种同步并<mark>不能起到线程同步的作用</mark>。跟第3种实现方式遇到的情形一致，假如一个线程进入了判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例
- 3）结论：在实际开发中，不能使用这种方式

### 6.6、双重检查

- 1）构造器私有化
- 2）类的内部创建对象，同时用`volatile`关键字修饰修饰
- 3）向外暴露一个静态的公共方法，加入同步处理的代码块，并进行双重判断，解决线程安全问题

```java
public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、类的内部声明对象，同时用`volatile`关键字修饰修饰
    private static volatile Singleton instance;

    // 3、向外暴露一个静态的公共方法，加入同步处理的代码块，并进行双重判断，解决线程安全问题
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

**优缺点**

- 1）Double-Check 概念是多线程开发中常使用到的，我们进行了两次检查，这样就可以保证线程安全了
- 2）这样实例化代码只用执行一次，后面再次访问时直接 return 实例化对象，也避免的反复进行方法同步
- 3）<mark>线程安全；延迟加载；效率较高</mark>
- 4）结论：在实际开发中，推荐使用这种单例设计模式

### 6.7、静态内部类

- 1）构造器私有化
- 2）定义一个静态内部类，内部定义当前类的静态属性
- 3）向外暴露一个静态的公共方法

```java
public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、定义一个静态内部类，内部定义当前类的静态属性
    private static class SingletonInstance {
        private static final Singleton instance = new Singleton();
    }

    // 3、向外暴露一个静态的公共方法
    public static Singleton getInstance() {
        return SingletonInstance.instance;
    }
}
```

**优缺点**

- 1）这种方式采用了类装载的机制，来保证初始化实例时只有一个线程
- 2）静态内部类方式在 Singleton 类被装载时并不会立即实例化，而是在需要实例化时，调用`getlnstance`方法，才会装载Singletonlnstance 类，从而完成 Singleton 的实例化
- 3）类的静态属性只会在第一次加载类的时候初始化，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的
- 4）优点：<mark>避免了线程不安全</mark>，利用静态内部类特点实现<mark>延迟加载，效率高</mark>
- 5）结论：推荐使用

### 6.8、枚举

```java
public enum Singleton {
    INSTANCE;

    public void sayHello() {
        System.out.println("Hello World");
    }
}
```

**优缺点**

- 1）这借助 JDK1.5 中添加的枚举来实现单例模式。不仅能<mark>避免多线程同步问题，而且还能防止反序列化重新创建新的对象</mark>
- 2）这种方式是 Effective Java 作者 Josh Bloch 提倡的方式
- 3）结论：推荐使用

### JDK 源码分析

JDK中 java.lang.Runtime 就是经典的单例模式

![image-20211012225547978](https://i.loli.net/2021/10/12/4kVzZ6mKBNsPdy3.png)

### 注意事项和细节说明

- 1）单例模式保证了系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能
- 2）当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用 new
- 3）单例模式使用的场景：<mark>需要频繁的进行创建和销毁的对象</mark>、<mark>创建对象时耗时过多或耗费资源过多但又经常用到的对象</mark>（即：重量级对象）、<mark>工具类对象</mark>、<mark>频繁访问数据库或文件的对象</mark>（比如数据源、session 工厂等）

### 小结

虽然上述提到的概念中，将<mark>双重检查、静态内部类、枚举</mark>三种方式的单例模式单独列举出来说明，但个人觉得本质也可以归类到饿汉式和懒汉式中；另外，同步代码块虽然上述中归类到线程安全，实际上并不是线程安全的

总结如下

- |——饿汉式：静态常量、静态代码块、枚举（本质就是静态常量）
- |——懒汉式
  - |——线程不安全：一次检查、同步代码块
  - |——线程安全：同步方法、双重检查、静态内部类

|  分类  | 方式       |       懒加载       |      线程安全      |        效率        |        内存        | 推荐指数（仅供参考） |
| :----: | :--------- | :----------------: | :----------------: | :----------------: | :----------------: | :------------------: |
| 饿汉式 | 静态变量   |        :x:         | :heavy_check_mark: | :heavy_check_mark: |        :x:         |     :star::star:     |
|   ~    | 静态代码块 |        :x:         | :heavy_check_mark: | :heavy_check_mark: |        :x:         |     :star::star:     |
|   ~    | 枚举       |        :x:         | :heavy_check_mark: | :heavy_check_mark: |        :x:         |  :star::star::star:  |
| 懒汉式 | 线程不安全 | :heavy_check_mark: |        :x:         | :heavy_check_mark: | :heavy_check_mark: |        :star:        |
|   ~    | 同步代码块 | :heavy_check_mark: |        :x:         | :heavy_check_mark: | :heavy_check_mark: |       不要使用       |
|   ~    | 同步方法   | :heavy_check_mark: | :heavy_check_mark: |        :x:         | :heavy_check_mark: |        :star:        |
|   ~    | 双重检查   | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |  :star::star::star:  |
|   ~    | 静态内部类 | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |  :star::star::star:  |



## 7、工厂模式

**看一个具体的需求**

看一个披萨的项目：要便于披萨种类的扩展，要便于维护

- 1）披萨的种类很多（比如 GreekPizz、CheesePizz 等）
- 2）披萨的制作有 prepare、bake、cut、box
- 3）完成披萨店订购功能

**使用传统方式**

![image-20211013212910916](https://i.loli.net/2021/10/13/wjfcsWzigrGCLBA.png)

```java
public abstract class Pizza {
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking...");
    }

    public void cut() {
        System.out.println(name + " cutting...");
    }

    public void box() {
        System.out.println(name + " boxing...");
    }
}

//希腊风味披萨
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("GreekPizza");
        System.out.println(name + " preparing...");
    }
}

// 奶酪披萨
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("CheesePizza");
        System.out.println(name + " preparing...");
    }
}

public class OrderPizza {
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            if ("cheese".equals(orderType)) {
                pizza = new CheesePizza();
            } else if ("greek".equals(orderType)) {
                pizza = new GreekPizza();
            } else {
                System.out.println("输入类型错误，程序退出");
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    private String getType() {
        System.out.println("请输入披萨类型：");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

```

**传统方式优缺点**

- 1）优点是比较好理解，简单易操作
- 2）缺点是违反了设计模式的 OCP 原则，即对扩展开放，对修改关闭。即当我们给类增加新能的时候，尽量不修改代码，或者尽可能少修改代码
- 3）比如我们这时要新增加一个Pizza的种类（Cheese技萨），我们需要做如下修改

![image-20211013212749928](https://i.loli.net/2021/10/13/ZMB123qYPvkxeuh.png)

```java
// 胡椒披萨
public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("PepperPizza");
        System.out.println(name + " preparing...");
    }
}

public class OrderPizza {
    public OrderPizza() {
        // ...
        else if ("pepper".equals(orderType)) {
            pizza = new PepperPizza();
        } 
        // ...
    }
    // ...
}
```

**改进的思路分析**

- 分析：修改代码可以接受，但是如果我们在其它的地方也有创建 Pizza 的代码，就意味着也需要修改。而创建Pizza的代码，往往有多处
- 思路：把创建 Pizza 对象封装到一个类中，这样我们有新的 Pizza 种类时，只需要修改该类就可，其它有创建到 Pizza 对象的代码就不需要修改了 ==> 简单工厂模式

### 7.1、简单工厂模式

- 1）简单工厂模式是属于创建型模式，是工厂模式的一种。<mark>简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例</mark>。简单工厂模式是工厂模式家族中最简单实用的模式
- 2）简单工厂模式：定义了一个创建对象的类，由这个类来<mark>封装实例化对象的行为</mark>（代码）
- 3）在软件开发中，当我们会用到大量的创建某种、某类或者某批对象时，就会使用到工厂模式

![image-20211013220335039](https://i.loli.net/2021/10/13/joYCU5OeEadGz3Z.png)

**核心代码**

```java
public class PizzaFactory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "greek":
                pizza = new GreekPizza();
                break;
            case "pepper":
                pizza = new PepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}

public class OrderPizza {
    private PizzaFactory pizzaFactory;

    public OrderPizza(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
        orderPizza();
    }

    public void orderPizza() {
        Pizza pizza = null;
        do {
            pizza = pizzaFactory.createPizza(getType());
            if (pizza == null) {
                System.out.println("Failed to Order Pizza");
            } else {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }
        } while (true);
    }
    // ...
}
```

### 7.2、静态工厂模式

静态工厂模式也是简单工厂模式的一种，只是将工厂方法改为静态方法

![image-20211013221239242](https://i.loli.net/2021/10/13/4mkIDlJT1wuzeVq.png)

**核心代码**

```java
public class PizzaFactory {
    public static Pizza createPizza(String orderType) {
        // ...
    }
}

public class OrderPizza {
    public OrderPizza() {
        Pizza pizza;
        do {
            pizza = PizzaFactory.createPizza(getType());
            // ...
        } while (true);
    }
```

### 7.3、工厂方法模式

**基本介绍**

工厂方法模式设计方案：将披萨项目的实例化功能抽象成抽象方法，在不同的口味点餐子类中具体实现

工厂方法模式：定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将<mark>对象的实例化推迟到子类</mark>

**看一个新的需求**

披萨项目新的需求：客户在点披萨时，可以点不同口味的披萨，比如北京的奶酪 Pizza、北京的胡椒 Pizza 或者是伦敦的奶酪 Pizza、伦敦的胡椒 Pizza

思路1：使用简单工厂模式，创建不同的简单工厂类，比如 BJPizzaFactory、LDPizzaFactory 等等。从当前这个案例来说，也是可以的，但是考虑到项目的规模，以及软件的可维护性、可扩展性并不是特别好

思路2：使用工厂方法模式

![image-20211015202748402](https://i.loli.net/2021/10/15/lRj6AnyOwpmh2dJ.png)

**核心代码**

```java
public abstract class OrderPizza {

    public void orderPizza() {
        Pizza pizza = null;
        do {
            pizza = createPizza(getType());
            if (pizza == null) {
                System.out.println("Failed to Order Pizza");
            } else {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }
        } while (true);
    }

    public abstract Pizza createPizza(String orderType);
     
    // ...
}

public class LDOrderPizza extends OrderPizza {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "cheese":
                pizza = new LDCheesePizza();
                break;
            case "pepper":
                pizza = new LDPepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}

public class BJOrderPizza extends OrderPizza {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "cheese":
                pizza = new BJCheesePizza();
                break;
            case "pepper":
                pizza = new BJPepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
```

### 7.4、抽象工厂模式

- 1）抽象工厂模式：定义了一个 interface 用于创建相关或有依赖关系的对象簇，而无需指明具体的类
- 2）抽象工厂模式可以<mark>将简单工厂模式和工厂方法模式进行整合</mark>
- 3）从设计层面看，<mark>抽象工厂模式就是对简单工厂模式的改进（或者称为进一步的抽象）</mark>
- 4）将工厂抽象成两层，AbsFactory（抽象工厂）和具体实现的工厂子类。程序员可以根据创建对象类型使用对应的工厂子类。这样将单个的简单工厂类变成了工厂簇，更利于代码的维护和扩展

![image-20211015204527615](https://i.loli.net/2021/10/15/JfW85CldjOyHu2T.png)

**核心代码**

```java
public interface AbsPizzaFactory {
    Pizza createPizza(String orderType);
}

public class BJPizzaFactory implements AbsPizzaFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "cheese":
                pizza = new BJCheesePizza();
                break;
            case "pepper":
                pizza = new BJPepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}

public class LDPizzaFactory implements AbsPizzaFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "cheese":
                pizza = new LDCheesePizza();
                break;
            case "pepper":
                pizza = new LDPepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
```

### JDK 源码分析

JDK 中的 Calendar 类中，就使用了简单工厂模式

![image-20211015205449459](https://i.loli.net/2021/10/15/evkPmUFASCgKsV6.png)

### 小结

- 1）工厂模式的意义：将实例化对象的代码提取出来，放到一个类中统一管理和维护，达到和主项目的<mark>依赖关系的解耦</mark>。从而提高项目的扩展和维护性
- 2）三种工厂模式：简单工厂模式、工厂方法模式、抽象工厂模式
- 3）设计模式的<mark>依赖抽象</mark>原则
  - 创建对象实例时，不要直接 new 类，而是把这个 new 类的动作放在一个工厂的方法中并返回。有的书上说，变量不要直接持有具体类的引用
  - 不要让类继承具体类，而是继承抽象类或者是实现 interface（接口）
  - 不要覆盖基类中已经实现的方法

