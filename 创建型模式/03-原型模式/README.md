> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 原型模式

## 1、克隆羊问题

现在有一只羊，姓名为 Tom，年龄为 1，颜色为白色，请编写程序创建和 Tom 羊属性完全相同的 10 只羊

**传统方法**

![image-20211015215334929](https://i.loli.net/2021/10/15/CjsIenXy2RHpt3L.png)

```java
public class Sheep {
    private String name;
    private Integer age;

    public Sheep(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Sheep sheep = new Sheep("Tom", 1, "白色");
            System.out.println(sheep);
        }
    }
}
```

**传统方法优缺点**

- 1）优点是比较好理解，简单易操作
- 2）在创建新的对象时，总是需要重新获取原始对象的属性，如果创建的对象比较复杂时，效率较低
- 3）总是需要重新初始化对象，而不是动态地获得对象运行时的状态，不够灵活

**改进的思路分析**

Java 中 Object 类是所有类的根类，Object 类提供了一个 clone 方法，该方法可以将一个 Java 对象复制一份，但是需要实现 clone 的 Java 类必须要实现一个接口 Cloneable，该接口表示该类能够复制且具有复制的能力 ==> 原型模式



## 2、基本介绍

- 1）原型模式（Prototype 模式）是指：<mark>用原型实例指定创建对象种类，并通过拷贝原型创建新的对象</mark>

- 2）原型模式是一种<mark>创建型设计模式</mark>，允许一个对象再创建另外一个可定制的对象，无需知道如何创建的细节

- 3）工作原理是：通过将一个原型对象传给那个要发动创建的对象，这个要发动创建的对象通过请求原型对象拷贝它们自己来实施创建，即`对象.clone()`

- 4）形象的理解：孙大圣拔出猴毛，变出其它孙大圣

  ![image-20211015213847067](https://i.loli.net/2021/10/15/rgOc2R4si78L5mu.png)



## 3、原理结构图（UML 类图）

![image-20211015214042060](https://i.loli.net/2021/10/15/3InmGRD5MyAQcPY.png)

**原理结构图说明**

- 1）`Prototype`：原型类，声明一个克隆自己的接口
- 2）`ConcretePrototype`：具体的原型类，实现一个克隆自己的操作
- 3）`Client`：让一个原型对象克隆自己，创建一个新的对象（属性相同）



## 4、原型模式解决克隆羊问题

使用原型模式改进传统方式式，让程序具有更高的效率和扩展性

**UML 类图**

![image-20211015215241868](https://i.loli.net/2021/10/15/FHOxv9EUD3hAR2T.png)

**核心代码**

```java
public class Sheep implements Cloneable {
    private String name;
    private Integer age;
    private String color;

    public Sheep(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheep;
    }
}

public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("Tom", 1, "白色");
        for (int i = 0; i < 10; i++) {
            Sheep sheep1 = (Sheep) sheep.clone();
            System.out.println(sheep1);
        }
    }
}
```



## 5、JDK 源码分析

Spring 框架中，创建`ApplicationContext`时，使用的`getBean`方法中使用到了原型模式

![image-20211016112521113](https://i.loli.net/2021/10/16/oIuML7nSJEsDytl.png)



## 6、浅拷贝和深拷贝

### 浅拷贝基本介绍

- 1）对于数据类型是<mark>基本数据类型的成员变量，浅拷贝会直接进行值传递</mark>，也就是将该属性值复制一份给新的对象
- 2）对于数据类型是<mark>引用数据类型的成员变量，比如说成员变量是某个数组、某个类的对象等，那么浅拷贝会进行引用传递</mark>，也就是只是将该成员变量的引用值（内存地址）复制一份给新的对象。因为实际上两个对象的该成员变量都指向同一个实例。在这种情况下，在一个对象中修改该成员变量会影响到另一个对象的该成员变量值
- 3）前面我们克隆羊就是浅拷贝
- 4）浅拷贝是<mark>使用默认的 clone 方法</mark>来实现：`sheep=(Sheep)super.clone();`

### 深拷贝基本介绍

- 1）<mark>复制对象的所有基本数据类型的成员变量值</mark>
- 2）<mark>为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象可达的所有对象</mark>。也就是说，对象进行深拷贝要对整个对象进行拷贝
- 3）深拷贝实现方式 1：<mark>重写 clone 方法来实现深拷贝</mark>
- 4）深拷贝实现方式 2：<mark>通过对象序列化实现深拷贝</mark>

**深拷贝方式 1**

```java
public class DeepClonableTarget implements Serializable, Cloneable {

    private String cloneName;
    private String cloneClass;

    public DeepClonableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getCloneClass() {
        return cloneClass;
    }

    public void setCloneClass(String cloneClass) {
        this.cloneClass = cloneClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class DeepPrototype implements Serializable, Cloneable {
    private String name;
    private DeepClonableTarget deepClonableTarget;

    public DeepPrototype() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepClonableTarget getDeepClonableTarget() {
        return deepClonableTarget;
    }

    public void setDeepClonableTarget(DeepClonableTarget deepClonableTarget) {
        this.deepClonableTarget = deepClonableTarget;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //基本数据类型拷贝
        Object object = super.clone();
        //引用类型拷贝
        DeepPrototype deepPrototype = (DeepPrototype) object;
        deepPrototype.deepClonableTarget = (DeepClonableTarget) deepClonableTarget.clone();
        return object;
    }
}

public class DeepTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype prototype = new DeepPrototype();
        prototype.setName("宋江");
        prototype.setDeepClonableTarget(new DeepClonableTarget("及时雨", "及时雨的类"));

        DeepPrototype clone1 = (DeepPrototype) prototype.clone();
        DeepPrototype clone2 = (DeepPrototype) prototype.clone();
        DeepPrototype clone3 = (DeepPrototype) prototype.clone();
        DeepPrototype clone4 = (DeepPrototype) prototype.clone();
        DeepPrototype clone5 = (DeepPrototype) prototype.clone();
        
        System.out.println(prototype.getName() + ", " + prototype.getDeepClonableTarget().hashCode()); // 宋江, 1554874502
        System.out.println(clone1.getName() + ", " + clone1.getDeepClonableTarget().hashCode()); // 宋江, 1846274136
        System.out.println(clone2.getName() + ", " + clone2.getDeepClonableTarget().hashCode()); // 宋江, 1639705018
        System.out.println(clone3.getName() + ", " + clone3.getDeepClonableTarget().hashCode()); // 宋江, 1627674070
        System.out.println(clone4.getName() + ", " + clone4.getDeepClonableTarget().hashCode()); // 宋江, 1360875712
        System.out.println(clone5.getName() + ", " + clone5.getDeepClonableTarget().hashCode()); // 宋江, 1625635731
    }
}
```

**深拷贝方式 2**

```java
public class DeepClonableTarget implements Serializable, Cloneable {
    private String cloneName;
    private String cloneClass;

    public DeepClonableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getCloneClass() {
        return cloneClass;
    }

    public void setCloneClass(String cloneClass) {
        this.cloneClass = cloneClass;
    }
}

public class DeepPrototype implements Serializable, Cloneable {
    private String name;
    private DeepClonableTarget deepClonableTarget;

    public DeepPrototype() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepClonableTarget getDeepClonableTarget() {
        return deepClonableTarget;
    }

    public void setDeepClonableTarget(DeepClonableTarget deepClonableTarget) {
        this.deepClonableTarget = deepClonableTarget;
    }

    public DeepPrototype deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return (DeepPrototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DeepTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype prototype = new DeepPrototype();
        prototype.setName("宋江");
        prototype.setDeepClonableTarget(new DeepClonableTarget("及时雨", "及时雨的类"));

        DeepPrototype clone1 = prototype.deepClone();
        DeepPrototype clone2 = prototype.deepClone();
        DeepPrototype clone3 = prototype.deepClone();
        DeepPrototype clone4 = prototype.deepClone();
        DeepPrototype clone5 = prototype.deepClone();

        System.out.println(prototype.getName() + ", " + prototype.getDeepClonableTarget().hashCode()); // 宋江, 644117698
        System.out.println(clone1.getName() + ", " + clone1.getDeepClonableTarget().hashCode()); // 宋江, 317574433
        System.out.println(clone2.getName() + ", " + clone2.getDeepClonableTarget().hashCode()); // 宋江, 885284298
        System.out.println(clone3.getName() + ", " + clone3.getDeepClonableTarget().hashCode()); // 宋江, 1389133897
        System.out.println(clone4.getName() + ", " + clone4.getDeepClonableTarget().hashCode()); // 宋江, 1534030866
        System.out.println(clone5.getName() + ", " + clone5.getDeepClonableTarget().hashCode()); // 宋江, 664223387
    }
}
```

**方式 1 和方式 2 对比**

- 在对象引用类型的成员属性较少时，方式 1 简单；在对象引用类型的成员属性较多时，方式 2 简单
- 在对象引用类型的成员属性经常发生变化时，方式 1 需要同步修改，方式 2 不用修改
- 推荐使用方式 2：耦合性低、可维护性强、扩展性高



## 7、注意事项和细节

- 1）**优点**：创建新的对象比较复杂时，可以利用<mark>原型模式简化对象的创建过程</mark>，同时也能够提高效率
- 2）**优点**：不用重新初始化对象，而是<mark>动态地获得对象运行时的状态</mark>
- 3）**优点**：<mark>如果原始对象发生变化（增加或者减少属性），其它克隆对象的也会发生相应的变化，无需修改代码</mark>
- 4）**缺点**：在实现深克隆的时候<mark>可能需要比较复杂的代码</mark>
- 5）**缺点**：需要为每一个类配备一个克隆方法，这对全新的类来说不是很难，但对已有的类进行改造时，需要修改其源代码，违背了OCP 原则，这点请同学们注意

