package com.example.homie_.model;

public class ProductCategory {
    Integer product_img;
    String productName;

    public ProductCategory(Integer product_img, String productName) {
        this.product_img = product_img;
        this.productName = productName;
    }

    public Integer getProduct_img() {
        return product_img;
    }

    public void setProduct_img(Integer product_img) {
        this.product_img = product_img;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
