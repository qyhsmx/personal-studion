package com.qyy.test.observermode;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-28 10:01
 **/
public class TestMain {
    public static void main(String[] args) {
        NewsSubject news = new NewsSubject();
        news.subscribe(System.out::println);
        news.subscribe(msg -> System.out.println(msg.toUpperCase()));
        news.tellAll("hello everyone");
    }
}
