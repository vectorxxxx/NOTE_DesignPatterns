>  笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 适配器模式

**泰国旅游使用插座问题**

现实生活中的适配器例子

泰国插座用的是两孔的（欧标），可以买个多功能转换插头（适配器），这样就可以使用了

![image-20211018194134795](https://i.loli.net/2021/10/18/SohGwD4NjIYRWHP.png)



## 基本介绍

- 1）适配器模式（Adapter Pattern）将某个类的接口转换成客户端期望的另一个接口表示，主的目的是<mark>兼容性</mark>，让原本因接口不匹配不能一起工作的两个类可以协同工作。其别名为包装器（Wrapper）
- 2）适配器模式属于<mark>结构型模式</mark>
- 3）主要分为三类：<mark>类适配器模式、对象适配器模式、接口适配器模式</mark>



## 工作原理

- 1）适配器模式：将一个类的接口转换成另一种接口，让原本接口不兼容的类可以<mark>兼容</mark>
- 2）从用户的角度看不到被适配者，是<mark>解耦</mark>的
- 3）用户调用适配器转化出来的目标接口方法，适配器再调用被适配者的相关接口方法
- 4）用户收到反馈结果，感觉只是和目标接口交互，如图

![image-20211018195141624](https://i.loli.net/2021/10/18/EUTe5Ao9dXhGnJY.png)



## 1、类适配器模式

**案例**

基本介绍：Adapter 类，通过继承 src 类，实现 dst 类接口，完成 src -> dst 的适配

以生活中充电器的例子来讲解适配器，充电器本身相当于 Adapter，220V 交流电相当于 src（即被适配者），我们的 dst（即目标）是 5V 直流电

![image-20211018195850891](https://i.loli.net/2021/10/18/VfG5R7U18dlcLZ2.png)

**UML 类图**

![image-20211018202103110](https://i.loli.net/2021/10/18/9Pb8Lsv2Ol7zgui.png)

**核心代码**

```java
// 被适配的类
public class Voltage220V {
    public Integer output220V() {
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}

// 适配接口
public interface IVoltage5V {
    Integer output5V();
}

// 适配器
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public Integer output5V() {
        int src = output220V();
        int dst = src / 44;
        System.out.println("电压=" + dst + "伏");
        return dst;
    }
}

// 使用适配器方法
public class Phone {
    public void charing(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println("电压=5伏，正在充电~");
        } else {
            System.out.println("电压!=5伏，无法充电~");
        }
    }
}

// 客户端
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charing(new VoltageAdapter());
    }
}
```

**注意事项和细节**

- 1）Java 是<mark>单继承机制</mark>，所以类适配器需要继承 src 类这一点算是一个缺点，因为这要求 dst 必须是接口，有一定<mark>局限性</mark>
- 2）src 类的方法在 Adapter 中都会暴露出来，也<mark>增加了使用的成本</mark>
- 3）由于其继承了 src 类，所以它可以根据需求重写 src 类的方法，使得 Adapter 的<mark>灵活性增强</mark>了



## 2、对象适配器模式

- 1）基本思路和类的适配器模式相同，只是将 Adapter 类作修改，不是继承 src 类，而是持有 src 类的实例，以解决兼容性的问题。即：持有 src 类，实现 dst 类接口，完成 src->dst 的适配
- 2）根据“合成复用原则”，在系统中尽量使用关联关系来替代继承关系
- 3）<mark>对象适配器模式是适配器模式常用的一种</mark>

以生活中充电器的例子来讲解适配器，充电器本身相当于 Adapter，220V 交流电相当于 src（即被适配者），我们的 dst（即目标）是 5V 直流电，使用对象适配器模式完成

**UML 类图**

![image-20211018203522489](https://i.loli.net/2021/10/18/AG5KruESVxmqQoM.png)

**核心代码**

只需修改 Adapter 类即可

```java
public class VoltageAdapter implements IVoltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public Integer output5V() {
        if (voltage220V == null) {
            return 0;
        }
        int src = voltage220V.output220V();
        int dst = src / 44;
        System.out.println("电压=" + dst + "伏");
        return dst;
    }
}

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charing(new VoltageAdapter(new Voltage220V()));
    }
}
```

**注意事项和细节**

- 1）<mark>对象适配器和类适配器其实算是同一种思想，只不过实现方式不同</mark>。根据合成复用原则，使用组合替代继承，所以它解决了类适配器必须继承 src 的局限性问题，也不再要求 dst 必须是接口
- 2）<mark>使用成本更低，更灵活</mark>



## 3、接口适配器模式

- 1）一些书籍称为：<mark>适配器模式或缺省适配器模式（Default Adapter Pattern）</mark>
- 2）当不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供一个默认实现（空方法），那么该抽象类的子类可有选择地覆盖父类的某些方法来实现需求
- 3）适用于一个接口不想使用其所有的方法的情况

**实例**

1）Android 中的属性动画 ValueAnimator 类可以通过 addListener（AnimatorListener listener）方法添加监听器，那么常规写法如下

```java
ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
valueAnimator.addListener(new Animator.AnimatorListener() {
    @Override
    public void onAnimatorStart(Animator animation) {
    }

    @Override
    public void onAnimatorEnd(Animator animation) {
    }

    @Override
    public void onAnimatorCancel(Animator animation) {
    }

    @Override
    public void onAnimatorRepeat(Animator animation) {
    }
});
valueAnimator.start();
```

2）有时候我们不想实现 Animator.AnimatorListener 接口的全部方法，我们只想监听 onAnimationStart，写法如下

```java
ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
valueAnimator.addListener(new AnimatorListenerAdapter() {
    @Override
    public void onAnimatorStart(Animator animation) {
        // XXXX具体实现
    }
});
valueAnimator.start();
```

3）AnimatorListenerAdapter 类就是一个接口适配器，它空实现了 Animator.AnimatorListener 类（src）的所有方法

```java
public abstract class AnimatorListenerAdapter implements Animator.AnimatorListener, Animator.AnimatorPauseListener {
    @Override
    public void onAnimationCancel(Animator animation) {
    }

    @Override
    public void onAnimationEnd(Animator animation) {
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
    }

    @Override
    public void onAnimationStart(Animator animation) {
    }

    @Override
    public void onAnimationPause(Animator animation) {
    }

    @Override
    public void onAnimationResume(Animator animation) {
    }
}
```

4）AnimatorListener 是一个接口

```java
public static interface AnimatorListener {
    void onAnimationStart(Animator animation);

    void onAnimationEnd(Animator animation);

    void onAnimationCancel(Animator animation);

    void onAnimationRepeat(Animator animation);
}
```

5）程序里的匿名内部类就是 Listener 具体实现类

```java
new AnimatorListenerAdapter() {
    @Override
    public void onAnimationStart(Animator animation){
        // xxxx具体实现
    }
}
```

现在我们按照上述步骤，自己去实现一下

**UML 类图**

![image-20211018210248150](https://i.loli.net/2021/10/18/53D1uYLzNegFtWV.png)

**核心代码**

```java
public interface Interface4 {
    void operation1();

    void operation2();

    void operation3();

    void operation4();
}

public abstract class AbsAdapter implements Interface4 {
    @Override
    public void operation1() {
    }

    @Override
    public void operation2() {
    }

    @Override
    public void operation3() {
    }

    @Override
    public void operation4() {
    }
}

public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter() {
            @Override
            public void operation1() {
                System.out.println("调用operation1方法");
            }
        };
        absAdapter.operation1();
    }
}
```



## SpringMVC 框架源码分析

1）SpringMVC 中的 HandlerAdapter，就使用了适配器模式

2）SpringMVC 处理请求的流程回顾

![image-20211018210609609](https://i.loli.net/2021/10/18/R8mGpOktzXPgbMJ.png)

![image-20211018210912269](https://i.loli.net/2021/10/18/w49rb15ES8X2opO.png)

3）使用 HandlerAdapter 的原因分析

在 DispatcherServlet 中，有一个 doDispatch 方法，其中便使用到了 HandlerAdapter 适配器

![image-20211018212840166](https://i.loli.net/2021/10/18/BRmNMufwOcvGAUF.png)

通过 request 可以获得一个 Handler，再根据这个 Handler 获得不同的 HandlerAdapter 进行处理

![image-20211018212934518](https://i.loli.net/2021/10/18/Qfm6UxbW3wC1yYo.png)

HandlerAdapter 本质上是一个适配器接口，具体的适配器实现类有多种，其中有我们较为熟悉的 HttpRequestHandlerAdapter 和 RequestMappingHandlerAdapter

![image-20211018213024886](https://i.loli.net/2021/10/18/hRZ1zrvQlX6Spb5.png)

HandlerAdapter 的实现子类是的每一种 Controller 有一种对应的适配器实现类，每种 Controller 有不同的实现方式

言归正传，拿到 HandlerAdapter 适配器之后，便会调用其中的 handle 方法， 此方法便是具体的适配器实现类需要实现的方法

![image-20211018213942824](https://i.loli.net/2021/10/18/35gkzLiVsHUXvef.png)

可以看到处理器的类型不同，有多重实现方式，那么调用方式就不是确定的。如果需要直接调用 Controller 方法，需要调用的时候就得不断使用`if-else`来进行判断是哪一种子类然后执行。那么如果后面要扩展 Controller，就得修改原来的代码，这样违背了 OCP 原则

4）为了更深刻地理解其中运用的模式思想，我们自己动手写 SpringMVC，通过适配器设计模式获取到对应的 Controller 的源码



## 自己动手写 SpringMVC

**UML 类图**

![image-20211018221312147](https://i.loli.net/2021/10/18/Lb1d3ql4wBt6nFE.png)

**核心代码**

```java
public interface Controller {
}

public class AnnotationController implements Controller {
    public void doAnnotationHandler() {
        System.out.println("annotation...");
    }
}

public class HttpController implements Controller {
    public void doHttpHandler() {
        System.out.println("http...");
    }
}

public class SimpleController implements Controller {
    public void doSimplerHandler() {
        System.out.println("simple...");
    }
}

//定义一个Adapter接口
public interface HandlerAdapter {
    boolean supports(Object handler);

    void handle(Object handler);
}

public class AnnotationHandlerAdapter implements HandlerAdapter {
    @Override
    public void handle(Object handler) {
        ((AnnotationController) handler).doAnnotationHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof AnnotationController);
    }
}

public class HttpHandlerAdapter implements HandlerAdapter {
    @Override
    public void handle(Object handler) {
        ((HttpController) handler).doHttpHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HttpController);
    }
}

public class SimpleHandlerAdapter implements HandlerAdapter {
    @Override
    public void handle(Object handler) {
        ((SimpleController) handler).doSimplerHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof SimpleController);
    }
}

public class DispatchServlet {
    public static List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    public DispatchServlet() {
        handlerAdapters.add(new AnnotationHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }

    public void doDispatch() {
        // 此处模拟 SpringMVC 从 request 取 handler 的对象，适配器可以获取到希望的 Controller
        //HttpController controller = new HttpController();
        SimpleController controller = new SimpleController();
        //AnnotationController controller = new AnnotationController();
        // 得到对应适配器
        HandlerAdapter adapter = getHandler(controller);
        //通过适配器执行对应的controller对应方法
        adapter.handle(controller);
    }

    public HandlerAdapter getHandler(Controller controller) {
        //遍历：根据得到的controller（handler），返回对应适配器
        for (HandlerAdapter adapter : this.handlerAdapters) {
            if (adapter.supports(controller)) {
                return adapter;
            }
        }
        return null;
    }
}
```

**说明**

- Spring 定义了一个适配接口，使得每一种 Controller 有一种对应的适配器实现类
- 适配器代替 Controller 执行相应的方法
- 扩展 Controller 时，只需要增加一个适配器类就完成了 SpringMVC 的扩展了
- 这就是设计模式的力量



## 注意事项和细节

- 1）三种命名方式，是根据 src 是以怎样的形式给到 Adapter（在Adapter里的形式）来命名的
- 2）三种适配器模式
  - 类适配器：以类给到，在 Adapter 里将 src 作为一个类，继承
  - 对象适配器：以对象给到，在Adapter 里将 src 作为一个对象，持有
  - 接口适配器：以接口给到，在 Adapter 里将 src 作为一个接口，实现
- 3）Adapter 模式最大的作用还是将原本不兼容的接口融合在一起工作
- 4）实际开发中，实现起来不拘泥于我们讲解的三种经典形式
