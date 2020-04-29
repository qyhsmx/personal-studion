package com.qyy.test.domian;

import lombok.Data;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-02 10:52
 **/
@Data
@Component
@SuppressWarnings("all")
public class Yellow implements EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String[] getAllProfiles(){
        return environment.getActiveProfiles();
    }
}
