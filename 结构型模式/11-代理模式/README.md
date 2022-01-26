> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 代理模式

## 1、代理模式的基本介绍

- 1）代理模式：为一个对象提供一个替身，以控制对这个对象的访问。即<mark>通过代理对象访问目标对象</mark>
- 2）这样做的好处是：可以在目标对象实现的基础上，增强额外的功能操作，即扩展目标对象的功能
- 3）被代理的对象可以是远程对象、创建开销大的对象或需要安全控制的对象
- 4）代理模式有不同的形式，主要有三种：
  - <mark>静态代理</mark>
  - <mark>动态代理</mark>：JDK 代理、接口代理
  - <mark>Cglib 代理</mark>：可以在内存动态的创建对象，而不需要实现接口，它是属于动态代理的范畴

![image-20211208201506612](https://s2.loli.net/2021/12/08/Mkpx2ge5R8GzoAv.png)



## 2、静态代理

### 2.1、基本介绍

静态代理在使里时，需要定义接口或者父类，被代理对象（即目标对象）与代理对象一起实现租同的接口或者是继承和同父类—
应用实例

### 2.2、应用实例

- 1）定义一个接口：`ITeacherDao`
- 2）目标对象`TeacherDAO`实现接口`ITeacherDAO`
- 3）使用静态代理方式，就需要在代理对象`TeacherDAOProxy`中也实现`ITeacherDAO`
- 4）调用的时候通过调用代理对象的方法来调用目标对象
- 5）**特别提醒**：代理对象与目标对象要实现相同的接口，然后通过调用相同的方法来调用目标对象的方法

**UML 类图**

![image-20211208211044367](https://s2.loli.net/2021/12/08/Mk1nsGFtADowXmY.png)

![image-20211208212227224](https://s2.loli.net/2021/12/08/k4aXGKCedrq3sO6.png)

**核心代码**

```java
/**
 * 代理接口
 */
public interface ITeacherDao {
    void teach();
}
/**
 * 被代理对象
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师授课中...");
    }
}
/**
 * 代理对象
 */
public class TeacherDaoProxy implements ITeacherDao {
    private ITeacherDao iTeacherDao;

    public TeacherDaoProxy(ITeacherDao iTeacherDao) {
        this.iTeacherDao = iTeacherDao;
    }

    @Override
    public void teach() {
        System.out.println("准备授课...");
        iTeacherDao.teach();
        System.out.println("结束授课...");
    }
}
```

**调用代理**

```java
//创建被代理对象
TeacherDao teacherDao = new TeacherDao();
//创建代理对象，聚合被代理对象
TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
//通过代理对象，调用被代理对象的方法
teacherDaoProxy.teach();
```

### 2.3、静态代理优缺点

- 1）**优点**：在不修改目标对象的功能前提下，能通过代理对象对目标功能扩展
- 2）**缺点**：因为代理对象需要与目标对象实现一样的接口，所以会有很多代理类
- 3）**缺点**：一旦接口增加方法，目标对象与代理对象都要维护



## 3、动态代理

### 3.1、基本介绍

- 1）代理对象不需要实现接口，但是目标对象要实现接口，否则不能用动态代理
- 2）代理对象的生成，是利用 JDK 的 APl，动态的在内存中构建代理对象
- 3）动态代理也叫做：<mark>JDK 代理、接口代理</mark>

### 3.2、JDK 中生成代理对象的 API

- 1）代理类所在包：`java.lang.reflect.Proxy`

- 2）JDK 实现代理只需要使用`newProxyInstance`方法，但是该方法需要接收三个参数，完整的写法是：

  ```java
  static Object newProxylnstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
  ```

**UML 类图**

![image-20211208214530692](https://s2.loli.net/2021/12/08/TUNlHKZL4jVabDg.png)

**核心代码**

```java
// ITeacherDao与TeacherDao同上
/**
 * 代理工厂
 */
public class TeacherFactory {
    /**
     * 目标对象
     */
    private Object target;

    public TeacherFactory(Object target) {
        this.target = target;
    }

    public Object newProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK代理授课开始...");
                Object returnVal = method.invoke(target, args);
                System.out.println("JDK代理授课结束...");
                return returnVal;
            }
        });
    }
}
```

其中几个参数

- 1）`ClassLoader loader`：指定当前目标对象使用的类加载器，获取加载器的方法固定
- 2）`Class<?>[] interfaces`：目标对象实现的接口类型，使用泛型方法确认类型
- 3）`InvocationHandler h`：事情处理，执行目标对象的方法时触发事情处理器方法，把当前执行的目标对象方法作为参数传入



## 4、Cglib 代理

### 4.1、基本介绍

- 1）静态代理和 JDK 代理模式都要求目标对象是实现一个接口，但是有时候目标对象只是一个单独的对象，并没有实现任何的接口，这个时候可使用目标对象子类来实现代理——这就是 Cglib 代理
- 2）<mark>Cglib 代理也叫作子类代理</mark>，它是在内存中构建一个子类对象从而实现对目标对象功能扩展，有些书也将 Cglib 代理归属到动态代理。
- 3）Cglib 是一个强大的高性能的代码生成包，它可以在运行期扩展 java 类与实现 java 接口。它广泛的被许多 AOP 的框架使用，例如 Spring AOP，实现方法拦截
- 4）在 AOP 编程中如何选择代理模式：
  - 目标对象需要实现接口，用 JDK 代理
  - 目标对象不需要实现接口，用 Cglib 代理
- 5）Cglib 包的底层是通过使用字节码处理框架 ASM 来转换字节码并生成新的类

### 4.2、实现步骤

- 1）需要引入`cglib`的 jar 文件

  ![image-20211210213734267](https://s2.loli.net/2021/12/10/t6PbNaGwj8FT1gA.png)

- 2）在内存中动态构建子类，注意代理的类不能为`final`，否则报错`java.lang.IllegalArgumentException`

- 3）目标对象的方法如果为`final`/`static`，那么就不会被拦截，即不会执行目标对象额外的业务方法

### 4.3、应用实例

**UML 类图**

![image-20211210202524247](https://s2.loli.net/2021/12/10/jMtwO2nBWPRurlh.png)

![image-20211210223144446](https://s2.loli.net/2021/12/10/4yxZ27L5DVbOtp1.png)

**核心代码**

```java
/**
 * 被代理对象
 */
public class TeacherDao {
    public String teach() {
        System.out.println("老师授课中...");
        return "Good";
    }
}

/**
 * 代理工厂类
 */
public class ProxyFactory implements MethodInterceptor {
    /**
     * 目标对象
     */
    private Object target;

    /**
     * 构造函数
     *
     * @param target
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 返回代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        // 1、创建工具类
        Enhancer enhancer = new Enhancer();
        // 2、设置父类
        enhancer.setSuperclass(target.getClass());
        // 3、设置回调函数
        enhancer.setCallback(this);
        // 4、创建子类对象，即代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理开始...");
        Object retVal = method.invoke(target, args);
        System.out.println("cglib代理结束...");
        return retVal;
    }
}
```

**调用代理**

```java
//创建目标对象
TeacherDao teacherDao = new TeacherDao();
//通过代理工厂创建代理对象
TeacherDao proxyInstance = (TeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
//通过代理对象调用目标对象方法
String retVal = proxyInstance.teach();
System.out.println("retVal=" + retVal);
```



### 5、代理模式的变体

几种常见的代理模式介绍一几种变体

- 1）**防火墙代理**：内网通过代理穿透防火墙，实现对公网的访问

- 2）**缓存代理**：比如：当请求图片文件等资源时，先到缓存代理取，如果取到资源则 ok；如果取不到资源，再到公网或者数据库取，然后缓存

- 3）**远程代理**：远程对象的本地代表，通过它可以把远程对象当本地对象来调用。远程代理通过网络和真正的远程对象沟通信息

  ![image-20211211095830914](https://s2.loli.net/2021/12/11/TEyYHr7ZoB3KcjS.png)

- 4）**同步代理**：主要使用在多线程编程中，完成多线程间同步工作
