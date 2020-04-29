package com.qyy.test.observermode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-28 09:59
 **/
public class NewsSubject implements Subject{
    private final List<Observer> observers;

    public NewsSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void tellAll(String msg) {
        for (Observer observer : observers) {
            observer.receiveMsg(msg);
        }
    }
}
