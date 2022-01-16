package com.vectorx.pattern.t19_interpreter;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Client2 {
    public static void main(String[] args) {
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression expression = spelExpressionParser.parseExpression("10*(2+1)*1+66");
        int result = (Integer) expression.getValue();
        System.out.println(result);
    }
}
