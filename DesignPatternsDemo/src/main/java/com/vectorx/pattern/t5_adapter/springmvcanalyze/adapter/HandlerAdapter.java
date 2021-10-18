package com.vectorx.pattern.t5_adapter.springmvcanalyze.adapter;

//定义一个Adapter接口
public interface HandlerAdapter {
    boolean supports(Object handler);

    void handle(Object handler);
}