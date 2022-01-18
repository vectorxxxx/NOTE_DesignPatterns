# NOTE_DesignPatterns

## 介绍

:sparkles: 尚硅谷Java设计模式（图解+框架源码剖析）学习笔记



## 更新

- :link: Github：[GitHub - vectorxxxx/NOTE_DesignPatterns: 尚硅谷Java设计模式（图解+框架源码剖析）学习笔记](https://github.com/vectorxxxx/NOTE_DesignPatterns)
- :link: Gitee：[NOTE_DesignPatterns: 尚硅谷Java设计模式（图解+框架源码剖析）学习笔记 (gitee.com)](https://gitee.com/vectorx/NOTE_DesignPatterns)
- :link: GitCode：[VectorUx / NOTE_DesignPatterns · GitCode](https://gitcode.net/qq_35925558/NOTE_DesignPatterns)
- :link: 语雀：[设计模式从入门到精通 · 语雀 (yuque.com)](https://www.yuque.com/u21195183/fnz31h)
- :link: 博客园：[设计模式从入门到精通 - 随笔分类 - VectorX - 博客园 (cnblogs.com)](https://www.cnblogs.com/vectorx/category/2046320.html)
- :link: CSDN：[设计模式从入门到精通_VectorX's Blog-CSDN博客](https://blog.csdn.net/qq_35925558/category_11416999.html)
- :link: 掘金：[设计模式从入门到精通 - VectorX的专栏 - 掘金 (juejin.cn)](https://juejin.cn/column/7019529168140369951)

<mark>**整理不易，还望各位看官一键三连 :heart: :heart: :heart: **</mark>

<mark>**整理不易，还望各位看官一键三连 :heart: :heart: :heart: **</mark>

<mark>**整理不易，还望各位看官一键三连 :heart: :heart: :heart: **</mark>

:sparkles:下面开始吧~

---

## 0、设计模式境界

境界大多是相通的

:person_fencing: 剑魔独孤求败的五层剑法境界

- :crossed_swords: **青钢利剑**：一招一式，极致招式
- :crossed_swords: **紫薇软剑**：招式变化，以柔克刚
- :crossed_swords: **玄铁重剑**：运劲法门，力度压制
- :crossed_swords: **木剑**：以快打慢，持强克弱
- :crossed_swords: **无剑**：内力外放，化气攻击

:book: 清代文学家王国维在《人间词话》提出的读书三层境界

- :city_sunrise: **昨夜西风凋碧树，独上高楼，望尽天涯路**
- :womans_clothes: **衣带渐宽终不悔，为伊消得人憔悴**
- :izakaya_lantern: **众里寻他千百度，蓦然回首，那人却在灯火阑珊处**



## 1、设计模式目的

:computer: 设计模式是为了让程序（软件），具有更好的

- :recycle: **可复用性**
- :book: **可读性**
- :link: **可扩展性**
- :policeman: **可靠性**
- :wrench: **可维护性**
- :snowboarder: **灵活性**
- :pushpin: **高内聚，低耦合**



## 2、设计模式七大原则

- :one: **单一职责原则**（Single Responsibility Principle）：一个类只负责一项职责
- :two: **接口隔离原则**（Interface Segregation Principle）：一个类对另一个类的依赖应该建立在最小的接口上
- :three: **依赖倒转原则**（Dependence Inversion Principle）：面向接口编程
- :four: **里氏替换原则**（Liskov Substitution Principle）：用聚合、组合代替继承
- :five: **开闭原则**（OCP，Open Closed Principle）：对扩展开放，对修改关闭
- :six: **迪米特法则**（Demeter Principle）：最少知道原则，只与直接的朋友通信
- :seven: **合成复用原则**（Composite Reuse Principle）：尽量使用合成/聚合的方式，而不是使用继承



## 3、UML 类图关系

- **依赖**（dependence）
- **泛化**（Generalization）：即继承
- **实现**（Implementation）
- **关联**（Association）：单向一对一关系；双向一对一关系
- **聚合**（Aggregation）
- **组合**（Composition）



## 4、设计模式分类（5 + 7 + 11）

- **创建型模式**（5种）：单例模式、工厂模式、抽象工厂模式、原型模式、建造者模式
- **结构型模式**（7种）：适配器模式、桥接模式、装饰模式、组合模式、外观模式、享元模式、代理模式
- **行为型模式**（11种）：模版方法模式、命令模式、访问者模式、迭代器模式、观察者模式、中介者模式、备忘录模式、解释器模式、状态模式、策略模式、职责链模式



## 5、23 种设计模式定义

1. **单例模式**（Single Pattern）：某个类只能存在一个对象实例
2. **工厂模式**（Factory Pattern）：由工厂对象决定创建出哪种产品类的实例
3. **原型模式**（Prototype Pattern）：用原型实例指定创建对象种类，并通过拷贝原型创建新的对象
4. **建造者模式 / 生成器模式**（Builder Pattern）：将复杂对象的建造过程抽象出来，使这个抽象过程的不同实现方法可以构造出不同表现（属性）的对象
5. **适配器模式**（Adapter Pattern）：将某个类的接口转换成客户端期望的另一个接口表示
6. **桥接模式**（Bridge Pattern）：将实现与抽象分离，放在两个不同的类层次中，可以独立改变
7. **装饰者模式**（Decorator Pattern）：动态地将新功能附加到对象上
8. **组合模式 / 部分整体模式**（Composite Pattern）：依据树形结构来组合对象，用来表示部分以及整体层次
9. **外观模式 / 过程模式**（Facade Pattern）：为调用端提供统一的调用接口
10. **享元模式 / 蝇量模式**（Flyweight Pattern）：运用共享技术有效地支持大量细粒度的对象
11. **代理模式**（Proxy Pattern）：通过代理对象访问目标对象
12. **模板模式 / 模板方法模式**（Template Method Pattern）：定义一个操作中的算法骨架，将一些步骤延迟到子类中
13. **命令模式**（Command Pattern）：将发起请求的对象与执行请求的对象解耦
14. **访问者模式**（Visitor Pattern）：将数据结构与数据操作分离
15. **迭代器模式**（Iterator Pattern）：提供一种遍历集合元素的统一接口，用一致的方法遍历集合元素
16. **观察者模式**（Observer Pattern）：对象之间多对一依赖的一种设计方案
17. **中介者模式**（Mediator Pattern）：用一个中介对象来封装一系列的对象交互
18. **备忘录模式**（Memento Pattern）：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态
19. **解释器模式**（Interpreter Pattern）：给定一个语言并定义其文法表示，使用该解释器来解释语言中的句子
20. **状态模式**（State Pattern）：解决对象在多种状态转换时，需要对外输出不同的行为的问题
21. **策略模式**（Strategy Pattern）：定义算法族，分别封装起来，让他们之间可以互相替换
22. **职责链模式 / 责任链模式**（Chain of Responsibility Pattern）：为请求创建一个接收者对象的链



## 6、23种设计模式举例、源码及优缺点

| 分类   | 设计模式   | 举例             | 源码                                  | 优点               | 缺点                                       |
| :----- | :--------- | :--------------- | :------------------------------------ | :----------------- | ------------------------------------------ |
| 创建型 | 单例模式   | `Singleton`      | JDK 中`java.lang.Runtime`             | 节省资源，提高性能 |                                            |
| ~      | 工厂模式   | 披萨店           | JDK 中`Calendar`                      | 统一管理，便于维护 |                                            |
| ~      | 原型模式   | 克隆羊           | Spring 中`ApplicationContext`         | 简化过程，提高效率 | <font color='red'>复杂</font>；违背 OCP    |
| ~      | 建造者模式 | 盖房子           | JDK 中`StringBuilder`                 | 解耦创建过程       |                                            |
| 结构型 | 适配器模式 | 插座             | SpringMVC 中`HandlerAdapter`          | 兼容性             |                                            |
| ~      | 桥接模式   | 手机             | JDBC 中`Driver`                       | 分离抽象与实现     |                                            |
| ~      | 装饰者模式 | 星巴克咖啡       | JDK 中`FilterlnputStream`             | 动态扩展功能       |                                            |
| ~      | 组合模式   | 学校院系         | JDK 中`HashMap`                       | 明确部分与整体层次 |                                            |
| ~      | 外观模式   | 影院管理         | MyBatis 中`Configuration`             | 屏蔽细节，简化操作 | <font color='orange'>过多不利于维护</font> |
| ~      | 享元模式   | 网站展示         | JDK 中`Integer`                       | 降低内存，提高效率 | <font color='red'>复杂</font>              |
| ~      | 代理模式   | 教师教书         | JDK 中`Proxy`                         | 扩展功能，更加安全 |                                            |
| 行为型 | 模板模式   | 豆浆制作         | Spring 中`AbstractApplicationContext` | 统一算法，代码复用 | <font color='orange'>过多不利于维护</font> |
| ~      | 命令模式   | 智能生活         | Spring 中`JdbcTemplate`               | 解耦请求发起与执行 | <font color='red'>复杂</font>              |
| ~      | 访问者模式 | 测评系统         |                                       | 解耦数据结构与操作 | 违背迪米特、依赖倒转                       |
| ~      | 迭代器模式 | 学校院系         | JDK 中`ArrayList`                     | 统一遍历           | <font color='orange'>过多不利于维护</font> |
| ~      | 观察者模式 | 天气预报         | JDK 中`Observable`                    | 动态添加三方       |                                            |
| ~      | 中介者模式 | 智能家庭         |                                       | 封装交互           | <font color='red'>复杂</font>              |
| ~      | 备忘录模式 | 游戏角色状态恢复 |                                       | 方便恢复状态       | 占用资源，消耗内存                         |
| ~      | 解释器模式 | 四则运算         | Spring 中`SpelExpressionParser`       | 可扩展性           | 调试复杂；效率低                           |
| ~      | 状态模式   | APP 抽奖         | 借贷平台                              | 分离状态           | <font color='orange'>过多不利于维护</font> |
| ~      | 策略模式   | 鸭子             | JDK 中`Comparator`                    | 分离不变与变化     | <font color='orange'>过多不利于维护</font> |
| ~      | 职责链模式 | 采购审批         | SpringMVC 中`HandlerExecutionChain`   | 分离请求与处理     | 调试复杂；影响性能                         |



整理难免有误，欢迎大家批评指正！

---

> 署名 4.0 国际 (CC BY 4.0)。您可以自由地：共享 — 在任何媒介以任何形式复制、发行本作品；演绎 — 修改、转换或以本作品为基础进行创作；在任何用途下，甚至商业目的。只要你遵守许可协议条款，许可人就无法收回你的这些权利。惟须遵守下列条件：署名 — 您必须给出适当的署名，提供指向本许可协议的链接，同时标明是否（对原始作品）作了修改。您可以用任何合理的方式来署名，但是不得以任何方式暗示许可人为您或您的使用背书。
