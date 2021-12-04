package com.vectorx.pattern.t10_flyweight;

public class Client {
    public static void main(String[] args) {
        Website newsWebsite = WebsiteFactory.getWebsiteCategory(Type.新闻);
        newsWebsite.use(new User("Tom"));
        Website blogWebsite1 = WebsiteFactory.getWebsiteCategory(Type.博客);
        blogWebsite1.use(new User("Jerry"));
        Website blogWebsite2 = WebsiteFactory.getWebsiteCategory(Type.博客);
        blogWebsite2.use(new User("John"));
        Website blogWebsite3 = WebsiteFactory.getWebsiteCategory(Type.博客);
        blogWebsite3.use(new User("Smith"));
        Website wxWebsite = WebsiteFactory.getWebsiteCategory(Type.微信公众号);
        wxWebsite.use(new User("Mack"));
        System.out.println(WebsiteFactory.getSize());
    }
}
