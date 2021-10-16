> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 建造者模式

## 1、盖房项目需求

- 1）需要建房子：这一过程为打桩、砌墙、封顶
- 2）房子有各种各样的，比如普通房，高楼，别墅，各种房子的过程虽然一样，但是要求不要相同的
- 3）请编写程序，完成需求

**传统方式**

![image-20211016135817291](https://i.loli.net/2021/10/16/ojlHFhset8ngcZX.png)

```java
public abstract class AbsHouse {
    protected abstract void piling();

    protected abstract void walling();

    protected abstract void capping();

    public void build() {
        piling();
        walling();
        capping();
    }
}

public class NormalRoom extends AbsHouse {
    @Override
    protected void piling() {
        System.out.println("普通房打桩...");
    }

    @Override
    protected void walling() {
        System.out.println("普通房砌墙...");
    }

    @Override
    protected void capping() {
        System.out.println("普通房封顶...");
    }
}

public class HighRise extends AbsHouse {
    @Override
    protected void piling() {
        System.out.println("高楼打桩...");
    }

    @Override
    protected void walling() {
        System.out.println("高楼砌墙...");
    }

    @Override
    protected void capping() {
        System.out.println("高楼封顶...");
    }
}

public class Villa extends AbsHouse {
    @Override
    protected void piling() {
        System.out.println("别墅打桩...");
    }

    @Override
    protected void walling() {
        System.out.println("别墅砌墙...");
    }

    @Override
    protected void capping() {
        System.out.println("别墅封顶...");
    }
}
```

**问题分析**

- 1）优点是比较好理解，简单易操作
- 2）设计的程序结构，过于简单，<mark>没有设计缓存层对象，程序的扩展和维护不好</mark>。也就是说，这种设计方案把产品（即：房子）和创建产品的过程（即：建房子流程）封装在一起，耦合性增强了
- 3）解决方案：<mark>将产品和产品建造过程解耦 ==> 建造者模式</mark>



## 2、基本介绍

- 1）<mark>建造者模式</mark>（Builder Pattern）又叫<mark>生成器模式</mark>，是一种对象构建模式。它可以将复杂对象的建造过程抽象出来（抽象类别），使这个抽象过程的不同实现方法可以构造出不同表现（属性）的对象
- 2）建造者模式是一步一步创建一个复杂的对象，它允许用户只通过指定复杂对象的类型和内容就可以构建它们，用户不需要知道内部的具体构建细节

![image-20211016140232641](https://i.loli.net/2021/10/16/YLkIZJdUXF1T27a.png)



## 3、建造者模式的四个角色

- 1）<mark>Product（产品角色）：一个具体的产品对象</mark>
- 2）<mark>Builder（抽象建造者）：可建一个 Product 对象的各个部件指定的接口 / 抽象类</mark>
- 3）<mark>ConcreteBuilder（具体建造者）：实现接口，构建和装配各个部件</mark>
- 4）<mark>Director（指挥者）：构建一个使用 Builder 接口的对象</mark>。它主要是用于创建一个复杂的对象。它主要有两个作用
  - 一是<mark>隔离了客户与对象的生产过程</mark>
  - 二是<mark>负责控制产品对象的生产过程</mark>



## 4、建造者模式原理类图

![image-20211016141000338](https://i.loli.net/2021/10/16/VXpDf2YsJBOPTez.png)



## 5、建造者模式解决盖房需求

需要建房子：这一过程为打桩、砌墙、封顶。不管是普通房子也好，别墅也好都需要经历这些过程，下面我们使用建造者模式（Builder Pattern）来完成

**UML 类图**

![image-20211016142956537](https://i.loli.net/2021/10/16/nq5zE1HsDyJuwer.png)

**核心代码**

```java
public class House {
    private String pile;
    private String wall;
    private String roof;

    public String getPile() {
        return pile;
    }

    public void setPile(String pile) {
        this.pile = pile;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }
}

public abstract class HouseBuilder {
    private House house = new House();

    public abstract void piling();
    
    public abstract void walling();
    
    public abstract void capping();

    public House build() {
        return house;
    }
}

public class NormalRoomBuilder extends HouseBuilder {
    @Override
    public void piling() {
        System.out.println("普通房打桩...");
    }

    @Override
    public void walling() {
        System.out.println("普通房砌墙...");
    }

    @Override
    public void capping() {
        System.out.println("普通房封顶...");
    }
}

public class HighRiseBuilder extends HouseBuilder {
    @Override
    public void piling() {
        System.out.println("高楼打桩...");
    }

    @Override
    public void walling() {
        System.out.println("高楼砌墙...");
    }

    @Override
    public void capping() {
        System.out.println("高楼封顶...");
    }
}

public class VillaBuilder extends HouseBuilder {
    @Override
    public void piling() {
        System.out.println("别墅打桩...");
    }

    @Override
    public void walling() {
        System.out.println("别墅砌墙...");
    }

    @Override
    public void capping() {
        System.out.println("别墅封顶...");
    }
}

public class HouseDirector {
    private HouseBuilder houseBuilder;

    public HouseDirector() {
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House buildHouse() {
        houseBuilder.piling();
        houseBuilder.walling();
        houseBuilder.capping();
        return houseBuilder.build();
    }
}

public class BuilderTest {
    public static void main(String[] args) {
        HouseDirector houseDirector = new HouseDirector();
        House house;

        houseDirector.setHouseBuilder(new NormalRoomBuilder());
        house = houseDirector.buildHouse();
        houseDirector.setHouseBuilder(new HighRiseBuilder());
        house = houseDirector.buildHouse();
        houseDirector.setHouseBuilder(new VillaBuilder());
        house = houseDirector.buildHouse();
    }
}
```



## 6、JDK 源码分析

java.lang.StringBuilder 中的建造者模式

![image-20211016144102204](https://i.loli.net/2021/10/16/pLSjwcoGBXJ1uE9.png)

![image-20211016144830033](https://i.loli.net/2021/10/16/8yptWngJX5NuCBL.png)

![image-20211016144812174](https://i.loli.net/2021/10/16/NVsPmvU2Ot714BJ.png)

![image-20211016144738060](https://i.loli.net/2021/10/16/sCY7eEquWIGlp4g.png)

角色分析

- `Appendable`接口定义了多个`append`方法（抽象方法），即`Appendable`为抽象建造者，定义了抽象方法
- `AbstractStringBuilder`实现了`Appendable`接口方法，这里的`AbstractStringBuilder`已经是建造者，只是不能实例化
- `StringBuilder`既充当了指挥者角色，又充当了具体的建造者，建造方法的实现是由`AbstractStringBuilder`完成，`StringBuilder`继承了`AbstractStringBuilder`



## 7、注意事项及细节

- 1）客户端（使用程序）<mark>不必知道产品内部组成的细节，将产品本身与产品的创建过程解耦</mark>，使得相同的创建过程可以创建不同的产品对象
- 2）<mark>每一个具体建造者都相对独立，而与其他的具体建造者无关</mark>，因此可以很方便地替换具体建造者或增加新的具体建造者，用户使用不同的具体建造者即可得到不同的产品对象
  3）<mark>可以更加精细地控制产品的创建过程</mark>。将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程
- 4）<mark>增加新的具体建造者无须修改原有类库的代码</mark>，指挥者类针对抽象建造者类编程，系统扩展方便，符合<mark>“开闭原则”</mark>
- 5）<mark>建造者模式所创建的产品一般具有较多的共同点，其组成部分相似</mark>，如果产品之间的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制
- 6）如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化，导致系统变得很庞大。因此在这种情况下，要考虑是否选择建造者模式



## 8、抽象工厂模式 VS 建造者模式

抽象工厂模式实现对产品家族的创建，一个产品家族是这样的一系列产品：具有不同分类维度的产品组合，采用抽象工厂模式不需要关心构建过程，只关心什么产品由什么工厂生产即可。

而建造者模式则是要求按照指定的蓝图建造产品，它的主要目的是通过组装零配件而产生一个新产品

