package com.pojo;



/**
 * Created by byebyejude on 2017/9/17.
 */
public class OrderItem {
    private int id;
    private int number;
    private Order order;
    private Product product;

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }
}
