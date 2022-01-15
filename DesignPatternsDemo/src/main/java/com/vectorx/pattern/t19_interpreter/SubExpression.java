package com.vectorx.pattern.t19_interpreter;

import java.util.Map;

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
