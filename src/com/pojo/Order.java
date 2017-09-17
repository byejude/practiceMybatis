package com.pojo;

import java.util.List;

/**
 * Created by byebyejude on 2017/9/17.
 */
public class Order {
    private int id;
    private String code;
    List<OrderItem> orderItems;

    public void setOis(List<OrderItem> ois) {
        this.orderItems = ois;
    }

    public List<OrderItem> getOis() {

        return orderItems;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }


}
