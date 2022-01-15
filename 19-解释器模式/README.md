> 笔记来源：[尚硅谷Java设计模式（图解+框架源码剖析）](https://www.bilibili.com/video/BV1G4411c7N4)

[TOC]

# 解释器模式

## 1、四则运算问题

通过解释器模式来实现四则运算，如计算`a + b - c`的值，具体要求

- 1）先输入表达式的形式，比如`a + b + c - d + e`，要求表达式的字母不能重复
- 2）在分别输入`a, b, c, d, e`的值
- 3）最后求出结果：如图

![image-20220115215331808](https://s2.loli.net/2022/01/15/Br8E7vKUJHNs6ZF.png)

**传统方案解决四则运算问题分析**

- 1）编写一个方法，接收表达式的形式，然后根据用户输入的数值进行解析，得到结果
- 2）问题分析：如果加入新的运算符，比如`* / (`等等，不利于扩展，另外让一个方法来解析会造成程序结构混乱，不够清晰
- 3）解决方案：可以考虑使用解释器模式，即：表达式 => 解释器（可以有多种） => 结果



## 2、解释器模式的基本介绍

- 1）在编译原理中，一个<mark>算术表达式</mark>通过<mark>词法分析器</mark>形成<mark>词法单元</mark>，而后这些<mark>词法单元</mark>再通过<mark>语法分析器</mark>构建<mark>语法分析树</mark>，最终形成一颗<mark>抽象的语法分析树</mark>。这里的<mark>词法分析器</mark>和<mark>语法分析器</mark>都可以看做是解释器
- 2）解释器模式（Interpreter Pattern）：是指给定一个语言（表达式），定义它的文法的一种表示，并定义一个解释器，使用该解释器来解释语言中的句子（表达式）
- 3）应用场景
  - 应用可以将一个需要解释执行的语言中的句子表示为一个抽象语法树
  - 一些重复出现的问题可以用一种简单的语言来表达
  - 一个简单语法需要解释的场景
- 4）这样的例子还有，比如<mark>编译器、运算表达式计算、正则表达式、机器人</mark>等

**原理类图**

![image-20220115220756742](https://s2.loli.net/2022/01/15/kEWMS3rshKcTwOy.png)

**解释器模式的角色及职责**

- `Context`环境角色：含有解释器之外的全局信息
- `AbstractExpression`抽象表达式：声明一个抽象的解释操作，该方法为抽象语法树中所有节点共享
- `TerminalExpression`终结符表达式：实现与文法中终结符相关的解释操作
- `NonTerminalExpression`非终结符表达式：实现与文法中非终结符相关的解释操作



## 3、解释器模式解决四则运算问题

**UML 类图**

![image-20220115221726269](https://s2.loli.net/2022/01/15/5bzJAnyXdFi27fG.png)

![image-20220115231901461](https://s2.loli.net/2022/01/15/4AYWgaZBEDKCkOy.png)

**核心代码**

抽象表达式

```java
/**
 * 抽象表达式类
 */
public abstract class Expression {
    /**
     * a + b - c
     * 解释公式和数值，key就是公式（表达式）参数[a, b, c]，value就是具体值
     * HashMap{a=10, b=20}
     *
     * @param var
     * @return
     */
    public abstract int interpret(Map<String, Integer> var);
}
```

抽象运算符号解释器

```java

/**
 * 抽象运算符号解释器
 * 这里每个运算符号，都只和自己左右两个数字有关系，
 * 但左右两个数字有可能也是一个解析的结果，无论何种类型，都是Expression类的实现类
 */
public class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 因为SymbolExpression 是让其子类来实现，因此interpreter是一个默认实现
     *
     * @param var
     * @return
     */
    @Override
    public int interpret(Map<String, Integer> var) {
        return 0;
    }
}
```

加减解释器

```java
/**
 * 加法解释器
 */
public class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * 处理相加
     *
     * @param var
     * @return
     */
    @Override
    public int interpret(Map<String, Integer> var) {
        return super.left.interpret(var) + super.right.interpret(var);
    }
}
/**
 * 减法解释器
 */
public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * 处理相减
     *
     * @param var
     * @return
     */
    @Override
    public int interpret(Map<String, Integer> var) {
        return super.left.interpret(var) - super.right.interpret(var);
    }
}
```

运算器类

```java
/**
 * 运算器类
 */
public class Calculator {
    /**
     * 定义表达式
     */
    private Expression expression;

    /**
     * 构造函数传递表达式并进行解析
     *
     * @param expStr
     */
    public Calculator(String expStr) { // expStr: a+b
        //栈对象存放变量表达式及运算得到的表达式
        Stack<Expression> stack = new Stack<>();
        //将表达式拆分成字符数组 [a,+,b]
        char[] charArr = expStr.toCharArray();

        Expression left;
        Expression right;
        // 遍历字符数组 [a,+,b]
        for (int i = 0; i < charArr.length; i++) {
            switch (charArr[i]) {
                case '+':
                    // 取出 a
                    left = stack.pop();
                    // 取出下一位变量，并创建`VarExpression`
                    right = new VarExpression(String.valueOf(charArr[++i]));
                    // 将left和right值作为参数，push到`Stack`中
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArr[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    // 如果不是加减等运算符，就创建`VarExpression`，并push到`Stack`中
                    stack.push(new VarExpression(String.valueOf(charArr[i])));
                    break;
            }
        }
        // 当遍历完整个`charArr`数组后，`stack`就得到了最终的`Expression`
        this.expression = stack.pop();
    }

    public int run(Map<String, Integer> var) {
        return this.expression.interpret(var);
    }
}
```

测试代码

```java
public static void main(String[] args) throws IOException {
    System.out.print("请输入表达式：");
    String expStr = getExpStr();
    Map<String, Integer> var = getValue(expStr);
    Calculator calculator = new Calculator(expStr);
    System.out.println("运算结果：" + expStr + "=" + calculator.run(var));
}

public static String getExpStr() throws IOException {
    return new BufferedReader(new InputStreamReader(System.in)).readLine();
}

public static Map<String, Integer> getValue(String expStr) throws IOException {
    Map<String, Integer> map = new HashMap<>();
    String s;
    for (char ch : expStr.toCharArray()) {
        s = String.valueOf(ch);
        if (ch == '+' || ch == '-' || map.containsKey(s)) {
            continue;
        }
        System.out.print("请输入" + s + "的值：");
        map.put(s, Integer.valueOf(getExpStr()));
    }
    return map;
}
```

测试结果

```java
//请输入表达式：a+b
//请输入a的值：10
//请输入b的值：20
//运算结果：a+b=30
```

