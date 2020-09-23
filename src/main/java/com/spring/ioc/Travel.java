package com.spring.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Travel {
    @Value("${config.name:qhl}")
    public String n;
}
