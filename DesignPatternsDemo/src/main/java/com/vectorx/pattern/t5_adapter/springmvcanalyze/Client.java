package com.vectorx.pattern.t5_adapter.springmvcanalyze;

import com.vectorx.pattern.t5_adapter.springmvcanalyze.servlet.DispatchServlet;

public class Client {
    public static void main(String[] args) {
        new DispatchServlet().doDispatch();
    }
}
