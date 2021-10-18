package com.vectorx.pattern.t5_adapter.springmvcanalyze.adapter;

import com.vectorx.pattern.t5_adapter.springmvcanalyze.controller.AnnotationController;

public class AnnotationHandlerAdapter implements HandlerAdapter {
    @Override
    public void handle(Object handler) {
        ((AnnotationController) handler).doAnnotationHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof AnnotationController);
    }
}
