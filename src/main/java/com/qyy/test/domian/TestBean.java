package com.qyy.test.domian;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-09 09:35
 **/
public class TestBean {

    Apple apple;
    Color color;
    Person person;

    public TestBean(Apple apple, Color color) {
        this.apple = apple;
        this.color = color;
    }

    public TestBean() {
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "apple=" + apple +
                ", color=" + color +
                ", person=" + person +
                '}';
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
