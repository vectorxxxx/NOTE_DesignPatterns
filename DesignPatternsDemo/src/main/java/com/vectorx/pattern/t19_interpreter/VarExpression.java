package com.vectorx.pattern.t19_interpreter;

import java.util.Map;

/**
 * 变量的解释器
 */
public class VarExpression extends Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     * var 就是{a=10, b=20}
     * interpret根据变量名称返回对应值
     *
     * @param var
     * @return
     */
    @Override
    public int interpret(Map<String, Integer> var) {
        return var.get(key);
    }
}
