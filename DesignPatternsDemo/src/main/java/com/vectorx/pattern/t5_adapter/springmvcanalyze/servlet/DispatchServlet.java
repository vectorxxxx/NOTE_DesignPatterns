package com.vectorx.pattern.t5_adapter.springmvcanalyze.servlet;

import com.vectorx.pattern.t5_adapter.springmvcanalyze.adapter.AnnotationHandlerAdapter;
import com.vectorx.pattern.t5_adapter.springmvcanalyze.adapter.HandlerAdapter;
import com.vectorx.pattern.t5_adapter.springmvcanalyze.adapter.HttpHandlerAdapter;
import com.vectorx.pattern.t5_adapter.springmvcanalyze.adapter.SimpleHandlerAdapter;
import com.vectorx.pattern.t5_adapter.springmvcanalyze.controller.Controller;
import com.vectorx.pattern.t5_adapter.springmvcanalyze.controller.SimpleController;

import java.util.ArrayList;
import java.util.List;

public class DispatchServlet {
    public static List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    public DispatchServlet() {
        handlerAdapters.add(new AnnotationHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }

    public void doDispatch() {
        // 此处模拟 SpringMVC 从 request 取 handler 的对象，适配器可以获取到希望的 Controller
        //HttpController controller = new HttpController();
        SimpleController controller = new SimpleController();
        //AnnotationController controller = new AnnotationController();
        // 得到对应适配器
        HandlerAdapter adapter = getHandler(controller);
        //通过适配器执行对应的controller对应方法
        adapter.handle(controller);
    }

    public HandlerAdapter getHandler(Controller controller) {
        //遍历：根据得到的controller（handler），返回对应适配器
        for (HandlerAdapter adapter : this.handlerAdapters) {
            if (adapter.supports(controller)) {
                return adapter;
            }
        }
        return null;
    }
}