package com.qyy.test.observermode;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-28 09:58
 **/
@FunctionalInterface
public interface Observer {
    void receiveMsg(String msg);
}
