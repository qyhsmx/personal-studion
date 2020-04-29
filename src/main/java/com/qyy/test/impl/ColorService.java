package com.qyy.test.impl;

import com.google.common.collect.Lists;
import com.qyy.test.ServiceTemplate;
import com.qyy.test.domian.Apple;
import com.qyy.test.domian.Color;
import com.qyy.test.domian.CommonRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-15 11:39
 **/
@Service
public class ColorService implements ServiceTemplate<List<Color>> {



    @Override
    public CompletableFuture<List<Color>> query(CommonRequest request) {
        System.out.println("查询颜色模块");
        return CompletableFuture.completedFuture(Lists.newArrayList());
    }
}
