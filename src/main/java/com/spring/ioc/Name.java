package com.spring.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Name {
    @Value("#{travel.n}")
    public String name;
}
