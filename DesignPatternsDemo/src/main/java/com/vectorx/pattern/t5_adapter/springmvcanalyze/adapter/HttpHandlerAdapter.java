package com.vectorx.pattern.t5_adapter.springmvcanalyze.adapter;

import com.vectorx.pattern.t5_adapter.springmvcanalyze.controller.HttpController;

public class HttpHandlerAdapter implements HandlerAdapter {
    @Override
    public void handle(Object handler) {
        ((HttpController) handler).doHttpHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HttpController);
    }
}
