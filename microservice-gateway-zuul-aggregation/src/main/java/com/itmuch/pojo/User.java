package com.itmuch.pojo;

import java.math.BigDecimal;

/**
 * @description: User
 * @author: ding
 * @date: 2019/12/15 10:04
 * @version: 1.0
 */


public class User {
    private Long id;
    private String username;
    private Integer age;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
