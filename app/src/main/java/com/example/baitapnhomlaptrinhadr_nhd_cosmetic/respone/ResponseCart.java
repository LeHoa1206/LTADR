package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.respone;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.CartItem;

import java.util.List;
public class ResponseCart {
    private List<CartItem> products;  // List<CartItem> hoặc kiểu dữ liệu bạn muốn

    public List<CartItem> getProducts() {
        return products;
    }

    public void setProducts(List<CartItem> products) {
        this.products = products;
    }
}


