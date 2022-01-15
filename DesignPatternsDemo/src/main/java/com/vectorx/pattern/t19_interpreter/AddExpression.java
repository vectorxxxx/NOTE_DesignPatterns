package com.vectorx.pattern.t19_interpreter;

import java.util.Map;

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
