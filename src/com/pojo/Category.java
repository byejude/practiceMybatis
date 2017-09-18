package com.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by byebyejude on 2017/9/16.
 */
public class Category implements Serializable{
    private int id;
    private String name;
    List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Category [id=" + id + ", name=" + name + "]";
    }
}
