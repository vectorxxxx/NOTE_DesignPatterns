package com.vectorx.pattern.t19_interpreter;

import java.util.Map;
import java.util.Stack;

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
