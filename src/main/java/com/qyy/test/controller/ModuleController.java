package com.qyy.test.controller;

import com.qyy.test.domian.CommonRequest;
import com.qyy.test.util.SpringContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-15 11:42
 **/
public class ModuleController {

    private List<String> list = new ArrayList<>();

    void query(CommonRequest request){
        for(String str : list){
            CompletableFuture query = SpringContextHolder.getBeanByName(str).query(request);
        }
    }
}
