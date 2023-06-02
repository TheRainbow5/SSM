package com.jiejie.Entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class User {
    private String name;
    private int age;
    private int tall;
    private Address address;
    public User() {}
    public User(String name, int age, int tall){
        this.name=name;
        this.age=age;
        this.tall=tall;
    }
//    private Map<String,Address> addressMap;
//    private List<Address> addressList;  //集合属性
//    private String[] hobbies;  //数组属性
//    private Address address;  //关联其他实体类

}
