package com.vectorx.pattern.t5_adapter.springmvcanalyze.adapter;

import com.vectorx.pattern.t5_adapter.springmvcanalyze.controller.SimpleController;

public class SimpleHandlerAdapter implements HandlerAdapter {
    @Override
    public void handle(Object handler) {
        ((SimpleController) handler).doSimplerHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof SimpleController);
    }
}
