package com.pojo;

/**
 * Created by byebyejude on 2017/9/16.
 */
public class Product {

    private  int id;
    private String name;
    private  float price;
    private  Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString(){
         return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
