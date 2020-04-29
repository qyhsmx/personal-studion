package com.qyy.test.processor;

import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Component;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-09 13:28
 **/
@Component
public class TestLoadTimeWeaverAware implements LoadTimeWeaverAware {
    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        System.out.println("------------------"+loadTimeWeaver);

    }
}
