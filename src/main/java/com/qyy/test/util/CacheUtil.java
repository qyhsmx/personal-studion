package com.qyy.test.util;

import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-15 19:17
 **/
public class CacheUtil {
    private static LoadingCache<Integer, Object> cache ;

    static {
//        cache = CacheBuilder.newBuilder()
//                .softValues()
//                .maximumSize(5000)
//                .expireAfterWrite(2, TimeUnit.SECONDS)
//                .build(new CacheLoader<Integer,Object>() {
//                    @Override
//                    public Object load(Integer integer) throws Exception {
//                        return "从缓存中获取的数据";
//                    }
//                });

    }

    public void get(Integer id) throws ExecutionException {
        Object o = cache.get(1);
    }
}
