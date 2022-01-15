> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 备忘录模式

## 1、游戏角色状态恢复问题

游戏鱼色有攻击力和防御力，在大战 Boss 前保存自身的状态（攻击力和防御力），当大战 Boss 后攻击力和防御万下降，从备忘录对象恢复到大战前的状态

**传统方案**

 ![image-20220112212748962](https://s2.loli.net/2022/01/12/3qDw9iHkdWQteUK.png)

**传统方案问题分析**

- 1）一个对象，就对应一个保存对象状态的对象。这样当我们游戏的对象很多时，不利于管理，开销也很大
- 2）传统的方式是简单地做备份，`new`出另外一个对象出来，再把需要备份的数据放到这个新对象，但这就暴露了对象内部的细节
- 3）解决方案：<mark>备忘录模式</mark>



## 2、备忘录模式基本介绍

- 1）备忘录模式（Memento Pattern）：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态
- 2）可以这样理解备忘录模式：现实生活中的备忘录是用来记录某些要去做的事情，或者是记录已经达成的共同意见的事情，以防忘记了。而在软件层面，备忘录模式有着相同的含义，备忘录对象主要用来记录一个对象的某种状态，或者某些数据，当要做回退时，可以从备忘录对象里获取原来的数据进行恢复操作
- 3）<mark>备忘录模式属于行为型模式</mark>

**原理类图**

![image-20220112213832425](https://s2.loli.net/2022/01/12/g6VqZ3huAMLHbjK.png)

![image-20220114223647227](https://s2.loli.net/2022/01/14/n3tB2AQZzfJDdqb.png)

**示例代码**

```java
/**
 * 源对象
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMementor() {
        return new Memento(state);
    }

    public void revertStateFromMementor(Memento memento) {
        this.state = memento.getState();
    }
}
/**
 * 备忘录对象
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
/**
 * 守护者对象
 */
public class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(Integer index) {
        return mementoList.get(index);
    }
}
```

**测试代码**

```java
Originator originator = new Originator();
Caretaker caretaker = new Caretaker();
originator.setState("当前状态：" + " 状态#1 血量 100 ");
caretaker.addMemento(originator.createMementor());
System.out.println(originator.getState());
originator.setState("当前状态：" + " 状态#2 血量 80 ");
caretaker.addMemento(originator.createMementor());
System.out.println(originator.getState());
originator.setState("当前状态：" + " 状态#3 血量 60 ");
caretaker.addMemento(originator.createMementor());
System.out.println(originator.getState());

// 恢复到状态1
originator.revertStateFromMementor(caretaker.getMemento(0));
System.out.println("恢复状态：" + originator.getState());

//当前状态： 状态#1 血量 100
//当前状态： 状态#2 血量 80
//当前状态： 状态#3 血量 60
//恢复状态：当前状态： 状态#1 血量 100
```

**备忘录模式中的角色和职责**

- `Originator`源对象：需要保存状态的对象
- `Memento`备忘录对象：负责保存`Originator`内部状态
- `Caretaker`守护者对象：负责存放多个`Memento`对象，使用集合管理，提高效率
- 如果希望保存多个`Originator`对象的不同内部状态，也可以使用`Map<String, List<Memento>>`



## 3、备忘录模式解决游戏角色状态回复问题

**UML 类图**

![image-20220114223757035](https://s2.loli.net/2022/01/14/QsfdjlzkFWa3Aut.png)

**备忘录对象**

```java
public class Memento {
    private Integer vit;
    private Integer def;

    public Memento(Integer vit, Integer def) {
        this.vit = vit;
        this.def = def;
    }

    public Integer getVit() {
        return vit;
    }

    public void setVit(Integer vit) {
        this.vit = vit;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }
}
```

**守护者对象**

```java
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
```

**游戏角色对象**

```java
public class GameRole {
    private Integer vit;
    private Integer def;

    public Integer getVit() {
        return vit;
    }

    public void setVit(Integer vit) {
        this.vit = vit;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Memento createMemento() {
        return new Memento(this.vit, this.def);
    }

    public void recoverMemento(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }

    public void display() {
        System.out.println("游戏角色当前攻击力：" + this.vit + "，当前防御力：" + this.def);
    }
}
```

**测试代码**

```java
System.out.println("======大战前状态======");
GameRole gameRole = new GameRole();
gameRole.setVit(100);
gameRole.setDef(100);
Caretaker caretaker = new Caretaker();
caretaker.setMemento(gameRole.createMemento());
gameRole.display();

System.out.println("======大战后状态======");
gameRole.setVit(10);
gameRole.setDef(10);
gameRole.display();

System.out.println("======从备忘录对象恢复到大战前的状态======");
gameRole.recoverMemento(caretaker.getMemento());
gameRole.display();

//======大战前状态======
//游戏角色当前攻击力：100，当前防御力：100
//======大战后状态======
//游戏角色当前攻击力：10，当前防御力：10
//======从备忘录对象恢复到大战前的状态======
//游戏角色当前攻击力：100，当前防御力：100
```



## 4、备忘录模式的注意事项和细节

**优点**

- 1）给用户提供了一种可以恢复状态的机制，可以使用户能够比较方便地回到某个历史的状态
- 2）实现了信息的封装，使得用户不需要关心状态的保存细节

**缺点**

- 3）如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存，这个需要注意

**其他**

- 4）适用的应用场景：
  1. 后悔药
  2. 打游戏时的存档
  3. `Windows`里的`ctrl+z`
  4. `IE`中的后退
  5. 数据库的事务管理
- 5）为了节约内存，备忘录模式可以和原型模式配合使用