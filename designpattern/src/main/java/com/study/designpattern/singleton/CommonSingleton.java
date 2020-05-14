package com.study.designpattern.singleton;

public class CommonSingleton {
    private static CommonSingleton instance = new CommonSingleton();
    private CommonSingleton() {

    }

    public static CommonSingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        CommonSingleton singleton = CommonSingleton.getInstance();
    }
}
