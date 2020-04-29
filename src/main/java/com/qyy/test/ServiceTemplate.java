package com.qyy.test;

import com.qyy.test.domian.CommonRequest;

import java.util.concurrent.CompletableFuture;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-15 11:37
 **/
public interface ServiceTemplate<T> {

    CompletableFuture<T> query(CommonRequest request);
}
