package com.company.proxy;

public class Browser implements IBroswer {
    private String url;

    public Browser(String url) {
        this.url = url;
    }


    @Override
    public Html show() {
        System.out.println("browser loading html from " + url);
        return null;
    }
}
