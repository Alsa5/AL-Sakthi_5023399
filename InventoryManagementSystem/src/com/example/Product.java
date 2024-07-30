package com.example;

public class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;
    private double priceOfone;
    public Product(String productId, String productName, int quantity, double price, double priceOfone) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.priceOfone= priceOfone;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceOfone() {
        return priceOfone;
    }

    public void setPriceOfone(double priceOfone) {
        this.priceOfone = priceOfone;
    }

    @Override
    public String toString() {
        return   '\n'+"Product Details:" + '\n'+'\n' +
                "productId = " + productId + '\n' +
                "productName = " + productName + '\n' +
                "quantity = " + quantity + '\n' +
                "PriceOfOne = " + priceOfone + '\n' +
                "tot.price = " + price + '\n'+'\n';
    }
}
