> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 外观模式

## 1、影院管理项目

组建一个家庭影院：

DVD 播放器、投影仪、自动屏幕、环绕立体声、爆米花机，要求完成使用家庭影院的功能，其过程为：

- 直接用遥控器：统筹各设备开关
- 开爆米花机
- 放下屏幕
- 开投影仪
- 开音响
- 开DVD，选dvd
- 去拿爆米花
- 调暗灯光
- 播放
- 观影结束后，关闭各种设备

**传统方式解决影院管理**

![传统方式解决影院管理](https://i.loli.net/2021/10/26/tB9qjkFxLSsyrOm.png)

```java
ClientTest{
    public static void main(String[] args){
        // 1、创建相关的对象
        // 2、调用创建的各个对象的一系列方法
        // 3、调用DVDPlayer对象的play方法
    }
}
```

**传统方式解决影院管理问题分析**

- 1）在 ClientTest 的 main 方法中，创建各个子系统的对象，并直接去调用子系统（对象）相关方法，会造成调用过程混乱，没有清晰的过程
- 2）不利于在 ClientTest 中去维护对子系统的操作
- 3）解决思路：定义一个高层接口，给子系统中的一组接口提供一个<mark>一致的界面（比如在高层接口提供四个方法ready，play，pause，end）</mark>，用来访问子系统中的一群接口
- 4）也就是说就是通过定义一个一致的接口（界面类），用以屏蔽内部子系统的细节，使得调用端只需跟这个接口发生调用，而无需关心这个子系统的内部细节 ==》外观模式



## 2、外观模式基本介绍

外观模式（Facade），也叫<mark>过程模式</mark>

外观模式为子系统中的一组接口提供一个一致的界面，此模式定义了一个高层接口，用以屏蔽内部子系统的细节，使得调用端只需跟这个接口发生调用，而无需关心这个子系统的内部细节，这个接口使得这一子系统更加容易使用

**原理类图**

![外观模式原理类图](https://i.loli.net/2021/10/27/uFrRGDghApwx9iC.png)

**原理类图的说明（外观模式的角色）**

- 1）外观类（Facade）：为调用端提供统一的调用接口，外观类知道哪些子系统负责处理请求，从而将调用端的请求代理给适当子系统对象
- 2）调用者（Client）：外观接口的调用者
- 3）子系统的集合：指模块或者子系统，处理 Facade 对象指派的任务，是功能的实际提供者



## 3、外观模式解决影院管理

- 1）外观模式可以理解为转换一群接口，客户只要调用一个接口，而不用调用多个接口才能达到目的，比如：
  - 在 PC 上安装软件的时候经常有一键安装选项（省去选择安装目录、安装的组件等等）
  - 手机的重启功能（把关机和启动合为一个操作）
- 2）外观模式就是解决多个复杂接口带来的使用困难，起到简化用户操作的作用

![image-20211027210310018](https://i.loli.net/2021/10/27/q8lHi1rwvszZjpW.png)

**使用外观模式来完成家庭影院项目**

![未命名文件 (2)](https://i.loli.net/2021/10/27/wRaZKJqL6vCsI5y.png)

**UML 类图**

![image-20211027224917586](https://i.loli.net/2021/10/27/si6uGzN74XrT25U.png)

**核心代码**

【投影仪】

```java
public class Projector {
    private static Projector projector = new Projector();

    public static Projector getInstance() {
        return projector;
    }

    public void on() {
        System.out.println("打开投影仪...");
    }

    public void off() {
        System.out.println("关闭投影仪...");
    }

    public void focus() {
        System.out.println("投影仪聚焦...");
    }

    public void zoom() {
        System.out.println("投影仪放大...");
    }
}
```

【DVD 播放器】

```java
public class DVDPlayer {
    private static DVDPlayer player = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return player;
    }

    public void on() {
        System.out.println("打开DVD播放器...");
    }

    public void off() {
        System.out.println("关闭DVD播放器...");
    }

    public void play() {
        System.out.println("播放DVD播放器...");
    }

    public void pause() {
        System.out.println("暂停DVD播放器...");
    }

    public void setDvd(String dvd) {
        System.out.println("选dvd：" + dvd + "...");
    }
}
```

【荧幕】

```java
public class Screen {
    private static Screen screen = new Screen();

    public static Screen getInstance() {
        return screen;
    }

    public void up() {
        System.out.println("升起荧幕...");
    }

    public void down() {
        System.out.println("拉下荧幕...");
    }
}
```

【立体声】

```java
public class Stereo {
    private static Stereo stereo = new Stereo();

    public static Stereo getInstance() {
        return stereo;
    }

    public void on() {
        System.out.println("打开立体声...");
    }

    public void off() {
        System.out.println("关闭立体声...");
    }

    public void setVolume(Integer volume) {
        System.out.println("立体声音量+" + volume + "...");
    }
}
```

【灯光】

```java
public class TheaterLights {
    private static TheaterLights lights = new TheaterLights();

    public static TheaterLights getInstance() {
        return lights;
    }

    public void on() {
        System.out.println("打开灯光...");
    }

    public void off() {
        System.out.println("关闭灯光...");
    }

    public void dim() {
        System.out.println("调暗灯光...");
    }

    public void bright() {
        System.out.println("调亮灯光...");
    }
}
```

【爆米花机器】

```java
public class Popcorn {
    private static Popcorn popcorn = new Popcorn();

    public static Popcorn getInstance() {
        return popcorn;
    }

    public void on() {
        System.out.println("打开爆米花机器...");
    }

    public void off() {
        System.out.println("关闭爆米花机器...");
    }

    public void pop() {
        System.out.println("取出爆米花...");
    }
}
```

【家庭影院 Facade】

```java
public class HomeTheaterFacade {
    private Popcorn popcorn;
    private Screen screen;
    private Stereo stereo;
    private TheaterLights lights;
    private Projector projector;
    private DVDPlayer player;

    public HomeTheaterFacade() {
        this.popcorn = Popcorn.getInstance();
        this.screen = Screen.getInstance();
        this.stereo = Stereo.getInstance();
        this.lights = TheaterLights.getInstance();
        this.projector = Projector.getInstance();
        this.player = DVDPlayer.getInstance();
    }

    public void ready() {
        lights.on(); // 打开灯光
        popcorn.on(); // 开爆米花机
        screen.down(); // 放下屏幕
        projector.on(); // 开投影仪
        projector.focus();
        projector.zoom();
        stereo.on(); // 开音响，设置音量
        stereo.setVolume(8);
        player.on(); // 开DVD，选dvd
        player.setDvd("坦塔尼克号");
        popcorn.pop(); // 去拿爆米花，关闭机器
        popcorn.off();
        lights.dim(); // 调暗灯光
    }

    public void play() {
        player.play();
    }

    public void pause() {
        player.pause();
    }

    public void end() {
        player.off();
        projector.off();
        stereo.off();
        lights.bright();
        screen.up();
    }
}
```

【客户端】

```java
public class Client {
    public static void main(String[] args) throws InterruptedException {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        System.out.println("===========家庭影院初始化============");
        homeTheaterFacade.ready();
        System.out.println("===========家庭影院沉浸式播放============");
        homeTheaterFacade.play();
        Thread.sleep(1000);
        System.out.println("===========家庭影院暂停============");
        homeTheaterFacade.pause();
        Thread.sleep(1000);
        System.out.println("===========家庭影院沉浸式播放============");
        homeTheaterFacade.play();
        Thread.sleep(1000);
        System.out.println("===========家庭影院结束============");
        homeTheaterFacade.end();
    }
}
```



## 4、MyBatis 框架源码分析

MyBatis 中 Configuration 去创建 MetaObject 对象时使用到了外观模式

**代码分析**

![image-20211204162630730](https://s2.loli.net/2021/12/04/sAGHt6NuxOMbLXU.png)

![image-20211204162725272](https://s2.loli.net/2021/12/04/FrNBzkZv64hnYpL.png)

**示意图**

![image-20211204164131376](https://s2.loli.net/2021/12/04/qeZIgyzsLcnBHh3.png)



## 5、外观模式的注意事项和细节

- 1）外观模式对外屏蔽了子系统的细节，因此外观模式降低了客户端对子系统使用的复杂性
- 2）外观模式对客户端与子系统的耦合关系，让子系统内部的模块更易维护和扩展
- 3）通过合理的使用外观模式，可以帮我们更好的划分访问的层次
- 4）当系统需要进行分层设计时，可以考虑使用 Facade 模式
- 5）在维护一个遗留的大型系统时，可能这个系统已经变得非常难以维护和扩展，此时可以考虑为新系统开发一个 Facade 类，来提供遗留系统的比较清晰简单的接口，让新系统与 Facade 类交互，提高复用性
- 6）不能过多的或者不合理的使用外观模式，使用外观模式好，还是直接调用模块好。要以让系统有层次，利于维护为目的
