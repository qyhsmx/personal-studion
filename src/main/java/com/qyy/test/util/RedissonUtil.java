package com.qyy.test.util;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.IOException;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2019-12-30 16:43
 **/
public class RedissonUtil {

   public static RedissonClient  instance(){
       Config config = new Config();
       config.useSingleServer()
               .setAddress("redis://127.0.0.1:6379")
               .setDatabase(2);
       RedissonClient client = Redisson.create(config);
       return client;
   }
}
