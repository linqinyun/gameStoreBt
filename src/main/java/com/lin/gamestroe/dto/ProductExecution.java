package com.lin.gamestroe.dto;

import com.lin.gamestroe.entity.Product;
import com.lin.gamestroe.enums.ProductCategoryStateEnum;

import java.util.List;

public class ProductExecution {
    private int state;
    private String stateInfo;
    private int count;
    private Product product;
    private List<Product> productList;

    public ProductExecution() {
    }

    //失败的构造器
    public ProductExecution(ProductCategoryStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //成功的构造器 -1
    public ProductExecution(int state, String stateInfo, Product product) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.product = product;
    }

    //成功的构造器 -2
    public ProductExecution(int state, String stateInfo, List<Product> productList) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.productList = productList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
