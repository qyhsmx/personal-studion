package com.qyy.test;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-02 16:38
 **/
public class Singleton {
    private Singleton() {
    }
    private static class SingletonHolder{
        private static final Singleton SINGLETON = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.SINGLETON;
    }
}
