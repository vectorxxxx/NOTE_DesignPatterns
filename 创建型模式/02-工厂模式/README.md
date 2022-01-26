> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 工厂模式

**看一个具体的需求**

看一个披萨的项目：要便于披萨种类的扩展，要便于维护

- 1）披萨的种类很多（比如 GreekPizz、CheesePizz 等）
- 2）披萨的制作有 prepare、bake、cut、box
- 3）完成披萨店订购功能



## 传统方式

**UML 类图**

![image-20211013212910916](https://i.loli.net/2021/10/15/o3qrncHWfimjwaU.png)

**核心代码**

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

![image-20211013212749928](https://i.loli.net/2021/10/15/cf2RvVyFruMJzZY.png)

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



## 1、简单工厂模式

- 1）简单工厂模式是属于创建型模式，是工厂模式的一种。<mark>简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例</mark>。简单工厂模式是工厂模式家族中最简单实用的模式
- 2）简单工厂模式：定义了一个创建对象的类，由这个类来<mark>封装实例化对象的行为</mark>（代码）
- 3）在软件开发中，当我们会用到大量的创建某种、某类或者某批对象时，就会使用到工厂模式

**UML 类图**

![image-20211013220335039](https://i.loli.net/2021/10/15/siXUdGHNyaKTzZ8.png)

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



## 2、静态工厂模式

静态工厂模式也是简单工厂模式的一种，只是将工厂方法改为静态方法

**UML 类图**

![image-20211013221239242](https://i.loli.net/2021/10/15/mYWo3VSUuEr5Qvz.png)

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



## 3、工厂方法模式

工厂方法模式设计方案：将披萨项目的实例化功能抽象成抽象方法，在不同的口味点餐子类中具体实现

工厂方法模式：定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将<mark>对象的实例化推迟到子类</mark>

**看一个新的需求**

披萨项目新的需求：客户在点披萨时，可以点不同口味的披萨，比如北京的奶酪 Pizza、北京的胡椒 Pizza 或者是伦敦的奶酪 Pizza、伦敦的胡椒 Pizza

思路1：使用简单工厂模式，创建不同的简单工厂类，比如 BJPizzaFactory、LDPizzaFactory 等等。从当前这个案例来说，也是可以的，但是考虑到项目的规模，以及软件的可维护性、可扩展性并不是特别好

思路2：使用工厂方法模式

**UML 类图**

![image-20211015202748402](https://i.loli.net/2021/10/15/XI8Ljca5CyDMB3w.png)

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



## 4、抽象工厂模式

- 1）抽象工厂模式：定义了一个 interface 用于创建相关或有依赖关系的对象簇，而无需指明具体的类
- 2）抽象工厂模式可以<mark>将简单工厂模式和工厂方法模式进行整合</mark>
- 3）从设计层面看，<mark>抽象工厂模式就是对简单工厂模式的改进（或者称为进一步的抽象）</mark>
- 4）将工厂抽象成两层，AbsFactory（抽象工厂）和具体实现的工厂子类。程序员可以根据创建对象类型使用对应的工厂子类。这样将单个的简单工厂类变成了工厂簇，更利于代码的维护和扩展

**UML 类图**

![image-20211015204527615](https://i.loli.net/2021/10/15/lVnkmUpCqyMEguj.png)

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



## JDK 源码分析

JDK 中的 Calendar 类中，就使用了简单工厂模式

![image-20211015205449459](https://i.loli.net/2021/10/15/RvGfxUpXbFT81yC.png)



## 小结

- 1）工厂模式的意义：将实例化对象的代码提取出来，放到一个类中统一管理和维护，达到和主项目的<mark>依赖关系的解耦</mark>。从而提高项目的扩展和维护性
- 2）三种工厂模式：简单工厂模式（静态工厂方法也是简单工厂模式的一种）、工厂方法模式、抽象工厂模式
- 3）设计模式的<mark>依赖抽象</mark>原则
  - 创建对象实例时，不要直接 new 类，而是把这个 new 类的动作放在一个工厂的方法中并返回。有的书上说，变量不要直接持有具体类的引用
  - 不要让类继承具体类，而是继承抽象类或者是实现 interface（接口）
  - 不要覆盖基类中已经实现的方法

