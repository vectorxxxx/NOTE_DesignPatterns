package com.vectorx.pattern.t19_interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.print("请输入表达式：");
        String expStr = getExpStr();
        Map<String, Integer> var = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println("运算结果：" + expStr + "=" + calculator.run(var));
        //请输入表达式：a+b
        //请输入a的值：10
        //请输入b的值：20
        //运算结果：a+b=30
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
}
