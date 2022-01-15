package com.vectorx.pattern.t19_interpreter;

import java.util.Map;

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
