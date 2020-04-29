package com.qyy.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-02 17:18
 **/
public enum SingletonOfEnum {

    a("hell");

    private final String name;

    SingletonOfEnum(String msg) {
        this.name = msg;
    }

    public static void getValue(){
        SingletonOfEnum[] values = values();



    }
}
