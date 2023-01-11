> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)
>

[TOC]

# 单例模式

## 介绍

所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类<mark>只能存在一个对象实例</mark>，并且该类只提供一个取得其对象实例的方法（静态方法）

比如 Hibernate 的 SessionFactory，它充当数据存储源的代理，并负责创建 Session 对象。SessionFactory 并不是轻量级的，一般情况下，一个项目通常只需要一个 SessionFactory 就够，这是就会使用到单例模式



## 八种方式

- 1）<mark>饿汉式（静态常量）</mark>
- 2）<mark>饿汉式（静态代码块）</mark>
- 3）<mark>懒汉式（线程不安全）</mark>
- 4）<mark>懒汉式（线程安全，同步方法）</mark>
- 5）<mark>懒汉式（线程安全，同步代码块）</mark>
- 6）<mark>双重检查</mark>
- 7）<mark>静态内部类</mark>
- 8）<mark>枚举</mark>



## 1、饿汉式（静态常量）

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



## 2、饿汉式（静态代码块）

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



## 3、懒汉式（线程不安全）

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



## 4、懒汉式（线程安全，同步方法）

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



## 5、懒汉式（线程不安全，同步代码块）

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



## 6、双重检查

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



## 7、静态内部类

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



## 8、枚举

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



## JDK 源码分析

JDK中 java.lang.Runtime 就是经典的单例模式

![image-20211012225547978](https://i.loli.net/2021/10/12/4kVzZ6mKBNsPdy3.png)



## 注意事项和细节说明

- 1）单例模式保证了系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能
- 2）当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用 new
- 3）单例模式使用的场景：<mark>需要频繁的进行创建和销毁的对象</mark>、<mark>创建对象时耗时过多或耗费资源过多但又经常用到的对象</mark>（即：重量级对象）、<mark>工具类对象</mark>、<mark>频繁访问数据库或文件的对象</mark>（比如数据源、session 工厂等）



## 小结

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

