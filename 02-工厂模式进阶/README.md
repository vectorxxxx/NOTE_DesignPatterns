[TOC]

# 工厂模式进阶

## 1、工厂方法模式和抽象工厂模式的区别

这里为什么只介绍工厂方法模式和抽象工厂模式的区别？为什么不把简单工厂模式、静态工厂模式也放在一起比较呢？

- 首先，静态工厂模式也是简单工厂模式的一种，仅仅是方法被定义成静态方法与否以及使用时是否直接通过类调用方法的区别
- 其次，简单工厂模式过于简单，相对比较容易理解，个人觉得没必要再拿出来与稍复杂的工厂方法模式、抽象工厂模式进行比较讲解
- 另外，简单工厂模式不符合`单一职责原则`，一度怀疑是否应该放在设计模式中进行讲解
- 最后，因为很多讲解 23 种设计模式的教程中并没有包括`简单工厂模式`，而只有`工厂方法模式`和`抽象工厂模式`

无论怎样，这里只讲工厂方法模式和抽象工厂模式的区别 :laughing:

要想搞清楚工厂方法模式和抽象工厂模式的区别，首先需要了解一个概念：<mark><u>***产品族！！！***</u></mark>

首先看下，各大搜索引擎对这一概念的相关诠释（这里剔除了其他相关性较弱或无关的解释，只贴出相关性较强的内容）

> 百度百科/搜狗百科/360搜索：产品分族,也叫成组技术.一个公司的产品从市场的角度来看,也许成千上万,但是,如果从流程的角度出发,一 般都能被分为几大类,分类的依据一般是关键的机器设备,这样的类别,就是产品族.以关键设备为依据,对生产流程进行分类的过程就是产品分族

![img](https://s2.loli.net/2022/01/21/dW8C2SyfwohpEAF.jpg)

不要灰心，官方的不行，找找技术贴

> 不同产品等级结构的一组产品组成产品族[^1]
>
> 产品族是指由同一个工厂生产的，位于不同产品等级结构中的一组产品[^2]

到这里，概念已经很清楚了：<mark>不同产品等级结构的一组产品</mark>

那什么又是产品等级结构呢？<mark>产品等级结构即产品的继承结构</mark>

`产品族`与`产品等级结构`的关系图如下

图一[^1]

![img](https://s2.loli.net/2022/01/21/G7vqi4rpDUwJYLh.jpg)

图二[^2]

![img](https://s2.loli.net/2022/01/21/lL2r4bDF98y5fNh.png)

图三[^3]

![电器工厂的产品等级与产品族](https://s2.loli.net/2022/01/22/w96NjGz8C3EvSYQ.gif)

有了对上述概念的形象理解，借鉴[抽象工厂模式-与-工厂方法模式区别_wyxhd2008的专栏-CSDN博客_工厂模式和抽象工厂模式的区别](https://blog.csdn.net/wyxhd2008/article/details/5597975)，总结内容如下表格，仅供参考

|        | 工厂方法模式                           | 抽象工厂模式                       |
| :----- | :------------------------------------- | :--------------------------------- |
| 不同点 | 一个产品等级结构，产品分类单一         | 多个产品等级结构，产品分类多样     |
|        | 一个抽象工厂只生产一个抽象产品         | 一个抽象工厂可生产多个抽象产品     |
|        | 一个具体工厂只生产一个具体产品         | 一个具体工厂可生产多个具体产品     |
|        | 不同的工厂实例创建不同的产品实例       | 不同的工厂实例创建不同的产品族实例 |
| 相同点 | 一个抽象工厂可派生出多个具体工厂       | ~                                  |
|        | 一个抽象产品可派生出多个具体产品       | ~                                  |
|        | 都是创建型模式，关心的都是如何创建对象 | ~                                  |

不过说了那么多，到底什么时候该用工厂方法模式，什么时候又该用抽象工厂模式呢？

下面，我们通过一些实际例子，来循序渐进地理解抽象工厂模式和工厂方法模式的使用场景



## 2、老徐种菜

### v1.0、老徐的菜地

最初，老徐有一块菜地，简单种了点大白菜、黄瓜和辣椒

```java
// 大白菜
public class ChineseCabbage {}
// 黄瓜
public class Cucumber {}
// 青椒
public class GreenPeper {}
```

但是，老徐也发现一些不足：容易受到病虫害的侵扰、天冷容易冻坏、大风大雨肥料容易流失等

### v2.0、老徐的菜棚子

后来，老徐赚了点钱，搭了一个菜棚子，专门种植这些蔬菜

```java
public interface Vegetable {}
// 大白菜
public class ChineseCabbage implements Vegetable {}
// 黄瓜
public class Cucumber implements Vegetable {}
// 青椒
public class GreenPeper implements Vegetable {}
public enum VegetableType {
    大白菜, 黄瓜, 青椒
}
public class VegetableShed {
    public Vegetable plantVegetable(String type) {
        Vegetable vegetable = null;
        if (VegetableType.大白菜.name().equals(type)) {
            vegetable = new ChineseCabbage();
        } else if (VegetableType.黄瓜.name().equals(type)) {
            vegetable = new Cucumber();
        } else if (VegetableType.青椒.name().equals(type)) {
            vegetable = new GreenPeper();
        }
        return vegetable;
    }
}
```

在老徐的精心栽培下，种植出来的蔬菜不仅免除了病虫害的侵扰，天冷也不很少冻坏了，而且还减少了施肥的用量，产量也大大增加了

没过多久，老徐又种了新的菜品：萝卜和胡萝卜

```java
// 萝卜
public class Radish implements Vegetable{}
// 胡萝卜
public class Carrot implements Vegetable{}
public enum VegetableType {
    大白菜, 黄瓜, 青椒, 萝卜, 胡萝卜
}
public class VegetableShed {
    public Vegetable plantVegetable(String type) {
        Vegetable vegetable = null;
        if (VegetableType.大白菜.name().equals(type)) {
            vegetable = new ChineseCabbage();
        } else if (VegetableType.黄瓜.name().equals(type)) {
            vegetable = new Cucumber();
        } else if (VegetableType.青椒.name().equals(type)) {
            vegetable = new GreenPeper();
        } else if (VegetableType.萝卜.name().equals(type)) {
            vegetable = new Radish();
        } else if (VegetableType.胡萝卜.name().equals(type)) {
            vegetable = new Carrot();
        }
        return vegetable;
    }
}
```

不过随着蔬菜产量越来越多，一个菜棚子已经放不下了

### v3.0、老徐的菜园子

于是，老徐搞了个大菜园子，然后给每种蔬菜都搭建了专门的菜棚子

```java
// 蔬菜棚子
public interface VegetableShed {
    Vegetable plantVegetable();
}
// 大白菜棚子
public class ChineseCabbageShed implements VegetableShed {
    @Override
    public ChineseCabbage plantVegetable() {
        return new ChineseCabbage();
    }
}
// 黄瓜棚子
public class CucumberShed implements VegetableShed {
    @Override
    public Cucumber plantVegetable() {
        return new Cucumber();
    }
}
// 青椒棚子
public class GreenPeperShed implements VegetableShed {
    @Override
    public GreenPeper plantVegetable() {
        return new GreenPeper();
    }
}
// 萝卜棚子
public class RadishShed implements VegetableShed {
    @Override
    public Radish plantVegetable() {
        return new Radish();
    }
}
// 胡萝卜棚子
public class CarrotShed implements VegetableShed{
    @Override
    public Carrot plantVegetable() {
        return new Carrot();
    }
}
```

没过多久，老徐又搞了点冬瓜和南瓜

```java
// 冬瓜
public class Waxgourd implements Vegetable {}
// 南瓜
public class Pumpkin implements Vegetable{}
// 冬瓜棚子
public class WaxgourdShed implements VegetableShed {
    @Override
    public Waxgourd plantVegetable() {
        return new Waxgourd();
    }
}
// 南瓜棚子
public class PumpkinShed implements VegetableShed {
    @Override
    public Pumpkin plantVegetable() {
        return new Pumpkin();
    }
}
```



## 3、小徐做手机

起初，小徐有了这个想法，于是便制定了一套标准

```java
// 电池
public interface Battery {}
// 摄像头
public interface Camera {}
// 芯片
public interface Chip {}
// 屏幕
public interface Screen {}
// 手机组件工厂
public abstract class PhoneComponentFactory {
    public abstract Chip productChip();
    public abstract Camera productCamera();
    public abstract Screen productScreen();
    public abstract Battery productBattery();
}
```

后来，小徐对手机的各个组件深入了解一番后，采购了一批手机组件，并准备生产一套手机，型号定为 X1

```java
// 镍铬电池
public class NickelCadmiumBattery implements Battery {}
// 单摄摄像头
public class SingleCamera implements Camera {}
// 麒麟芯片
public class KylinChip implements Chip {}
// OLED屏
public class OledScreen implements Screen {}
// X1 手机组件工厂
public class X1PhoneComponentFactory extends PhoneComponentFactory {
    @Override
    public Chip productChip() {
        return new KylinChip();
    }

    @Override
    public Camera productCamera() {
        return new SingleCamera();
    }

    @Override
    public Screen productScreen() {
        return new OledScreen();
    }

    @Override
    public Battery productBattery() {
        return new NickelCadmiumBattery();
    }
}
```

没想到，第一次做手机就很顺利，小徐决心做一套更好的出来，于是又采购了一套手机组件，并生产了 X2 手机

```java
// 锂离子电池
public class LithiumIonBattery implements Battery {}
// 双摄摄像头
public class DuoCamera implements Camera {}
// 骁龙芯片
public class SnapdragonChip implements Chip {}
// IPS屏
public class IpsScreen implements Screen {}
// X2 手机组件工厂
public class X2PhoneComponentFactory extends PhoneComponentFactory {
    @Override
    public Chip productChip() {
        return new SnapdragonChip();
    }

    @Override
    public Camera productCamera() {
        return new DuoCamera();
    }

    @Override
    public Screen productScreen() {
        return new IpsScreen();
    }

    @Override
    public Battery productBattery() {
        return new LithiumIonBattery();
    }
}
```

但因为成本和售价很高，小徐没有卖出多少部。于是小徐便多次进行组件搭配的调整，最终小徐找到了性价比最高的搭配方式，做出了 X3，销量遥遥领先

```java
public class X3PhoneComponentFactory extends PhoneComponentFactory {
    @Override
    public Chip productChip() {
        return new KylinChip();
    }

    @Override
    public Camera productCamera() {
        return new SingleCamera();
    }

    @Override
    public Screen productScreen() {
        return new IpsScreen();
    }

    @Override
    public Battery productBattery() {
        return new LithiumIonBattery();
    }
}
```



## 4、总结

通过上述例子，帮助我们体会到两者各自适用的使用场景，不难发现工厂方法模式和抽象工厂模式之间的区别

- 生产的产品种类只有一种，但是该产品种类会不断地扩展新的具体产品，同时需要添加对应的具体工厂，这时使用<mark>工厂方法模式</mark>更好
- 生产的产品种类会有多种，种类基本固定下来了，不会轻易更改或添加，但是每个种类的具体产品会不断扩展，并在具体工厂中形成新的组合，这时使用<mark>抽象工厂模式</mark>更好

试想一下，如果对上述种菜和做手机使用的工厂模式进行交换，即种菜使用抽象工厂模式、做手机使用工厂方法模式又会怎样？

不仅不合适，反而可能使得问题变得更加复杂化了，有可能得不偿失，所以选对设计模式也是很重要的一门学问



## 引用

[^1]:[产品族和产品等级结构 - 简书 (jianshu.com)](https://www.jianshu.com/p/f1e837cab952)
[^2]:[工厂三兄弟之抽象工厂模式（二）_刘伟技术博客-CSDN博客](https://blog.csdn.net/lovelion/article/details/9319323)

