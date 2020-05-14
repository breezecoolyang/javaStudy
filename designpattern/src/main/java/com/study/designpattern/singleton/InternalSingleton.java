package com.study.designpattern.singleton;

public class InternalSingleton {
    private static InternalSingleton instance;

    private static class SingleHolder {
        private static InternalSingleton holder = new InternalSingleton();

    }
    private InternalSingleton () {}
    public static InternalSingleton getInstance() {
        return SingleHolder.holder;
    }
}
