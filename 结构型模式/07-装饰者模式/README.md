>  笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 装饰者模式

## 1、星巴克咖啡订单项目

星巴克咖啡订单项目（咖啡馆）：

- 1）咖啡种类/单品咖啡：Espresso（意大利浓咖）、ShortBlack、LongBlack（美式咖啡）、Decaf（无因咖啡）
- 2）调料：Mik、Soy（豆浆）、Chocolate
- 3）要求在扩展新的咖啡种类时，具有良好的扩展性、改动方便、维护方便
- 4）使用 OO 的来计算不同种类咖啡的费用：客户可以点单品咖啡，也可以单品咖啡+调料组合



## 2、方案 1-解决星巴克咖啡订单项目（较差的方案）

![image-20211023165815602](https://i.loli.net/2021/10/23/KvMQ2y5PZC3xdnO.png)

**方案 1-解决星巴克咖啡订单问题分析**

- 1）Drink 是一个抽象类，表示饮料
- 2）description 就是对咖啡的描述，比如咖啡的名字
- 3）cost 方法就是计算费用，Drink 类中做成一个抽象方法
- 4）Decaf 就是单品咖啡，继承 Drink，并实现 cost
- 5）Espresso && Milk 就是单品咖啡+调料，这个组合很多
- 6）问题：这样设计，会有很多类。当我们增加一个单品咖啡，或者一个新的调料，类的数量就会倍增，出现类爆炸



## 3、方案 2-解决星巴克咖啡订单项目（好点的方案）

前面分析到方案 1 因为咖啡单品+调料组合会造成类的倍增，因此可以做改进，将调料内置到 Drink 类，这样就不会造成类数量过多。从而提高项目的维护性（如图）

![image-20211023170550925](https://i.loli.net/2021/10/23/168WlhknHGS4Ocg.png)

说明：Milk、Soy、Chocolate 可以设计为 Boolean，表示是否要添加相应的调料

**方案 2-解决星巴克咖啡订单问题分析**

- 1）方案 2 可以控制类的数量，不至于造成很多的类
- 2）在增加或者删除调料种类时，代码的维护量很大
- 3）考虑到用户可以添加多份调料时，可以将 hasMilk 返回一个对应 int
- 4）考虑使用装饰者模式



## 4、装饰者模式

**定义**

1）装饰者模式：<mark>动态地将新功能附加到对象上</mark>。在对象功能扩展方面，它比继承更有弹性，装饰者模式体现了<mark>开闭原则（OCP）</mark>

2）这里提到的动态的将新功能附加到对象和 OCP 原则，在后面的应用实例上会以代码的形式体现，请同学们注意体会

**原理**

- 1）装饰者模式就像打包一个快递
  - 主体：比如陶瓷、衣服（Component）
  - 包装：比如报纸填充、塑料泡沫、纸板、木板（Decorator）
- 2）主体（Component）：比如前面的 Drink
- 3）具体的主体（ConcreteComponent）：比如前面的各个单品咖啡
- 4）装饰者（Decorator）：比如各调料
- 4）Component 与 ConcreteComponent 之间，如果 ConcreteComponent 类很多，还可以设计一个缓冲层，将共有的部分提取出来，抽象成一个类

![image-20211023181332821](https://i.loli.net/2021/10/23/9Zz6G4VrQJ2EaHh.png)



## 5、装饰者模式解决星巴克咖啡订单项目

![image-20211023181701216](https://i.loli.net/2021/10/23/g3b4cOhZj1iG9Ep.png)

**说明**

- 1）Drink 就是抽象类 Component
- 2）ShortBlack 单品咖啡就是具体的主体
- 3）Decorator 是一个装饰类，含有一个被装饰的对象（Drink）
- 4）Decorator 的 cost 方法进行一个费用的叠加，递归地计算价格

装饰者模式下的订单：2份巧克力 + 一份牛奶的 LongBlack

![image-20211023182107273](https://i.loli.net/2021/10/23/dG3VDIAOyzRlFua.png)

**说明**

- 1）Milk 包含了 LongBlack
- 2）一份 Chocolate 包含了 Milk + LongBlack
- 3）一份 Chocolate 包含了 Chocolate + Milk + LongBlack
- 4）这样不管是什么形式的单品咖啡 + 调料组合，通过递归方式可以方便的组合和维护

**UML类图**

![image-20211023194905182](https://i.loli.net/2021/10/23/JGufy6b1i8FTg47.png)

**核心代码**

```java
// 抽象主体
public abstract class Drink {
    private String desc;
    private Float price;

    public String getDesc() {
        return desc;
    }

    protected void setDesc(String desc) {
        this.desc = desc;
    }

    public Float getPrice() {
        return price;
    }

    protected void setPrice(Float price) {
        this.price = price;
    }

    public abstract Float cost();
}
// 具体主体
public class Coffee extends Drink {

    @Override
    public Float cost() {
        return super.getPrice();
    }
}
public class Decaf extends Coffee {
    public Decaf() {
        setDesc("无因咖啡");
        setPrice(20.0f);
    }
}
public class Espresso extends Coffee {
    public Espresso() {
        setDesc("意大利浓咖");
        setPrice(30.0f);
    }
}
public class ShortBlack extends Coffee {
    public ShortBlack() {
        setDesc("短黑咖啡");
        setPrice(40.0f);
    }
}
public class LongBlack extends Coffee {
    public LongBlack() {
        setDesc("美式咖啡");
        setPrice(50.0f);
    }
}
//装饰者
public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public Float cost() {
        return super.getPrice() + drink.cost();
    }
}
public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        setDesc("牛奶");
        setPrice(3.0f);
    }
}
public class Soy extends Decorator {
    public Soy(Drink drink) {
        super(drink);
        setDesc("豆浆");
        setPrice(4.0f);
    }
}
public class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
        setDesc("巧克力");
        setPrice(5.0f);
    }
}
// 调用者
public class CoffeeBar {
    public static void main(String[] args) {
        Drink drink = new Espresso();
        System.out.println("意大利浓咖：" + drink.cost() + "美元"); // 意大利浓咖：30.0美元

        drink = new Milk(drink);
        System.out.println("意大利浓咖 + 1份牛奶：" + drink.cost() + "美元"); // 意大利浓咖 + 1份牛奶：33.0美元

        drink = new Chocolate(drink);
        System.out.println("意大利浓咖 + 1份牛奶 + 1份巧克力：" + drink.cost() + "美元"); // 意大利浓咖...：38.0美元

        drink = new Chocolate(drink);
        System.out.println("意大利浓咖 + 1份牛奶 + 2份巧克力：" + drink.cost() + "美元"); // 意大利浓咖...：43.0美元
    }
}
```



## 6、JDK 源码分析

Java 的 IO 结构，FilterlnputStream 就是一个装饰者

![image-20211023210853809](https://i.loli.net/2021/10/23/YMfI15ruUsnDNkQ.png)

**核心代码**

```java
// 是一个抽象类，即Component
public abstract class InputStream implements Closeable {} 
// 是一个装饰类，即Decorator
public class FilterInputStream extends InputStream { 
    protected volatile InputStream in;
    protected FilterInputStream(InputStream in) {
        this.in = in;
    }
}
// FilterInputStream子类，也继承了被装饰的对象 in
public class DataInputStream extends FilterInputStream implements DataInput { 
    public DataInputStream(InputStream in) {
        super(in);
    }
```

**分析**

- 1）InputStream 是抽象类，类似我们前面讲的 Drink
- 2）FileInputStream 是 InputStream 子类，类似我们前面的 DeCaf、LongBlack
- 3）FilterInputStream 是 InputStream 子类，类似我们前面的 Decorator，修饰者
- 4）DataInputStream 是 FilterInputStream 子类，类似前面的Milk，Soy等，具体的修饰者
- 5）FilterInputStream 类有`protected volatile InputStream in;`，即含被装饰者
- 6）分析得出在 JDK 的 IO 体系，就是使用装饰者模式

