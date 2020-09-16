package com.text.pack02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/22  21:55
 */
//使用注解创建对象 默认类的第一个字母小写
@Component( "mySchool")
@PropertySource(value = "classpath:pack02/config.properties",encoding = "utf-8")
public class School {
    @Value("${school}")
    private String name;
    @Value("${address}")
    private String address;

    public School() {
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
