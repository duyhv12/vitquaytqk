package com.isd.vitquaytqk.Model;

/**
 * Created by Admin on 11/6/2017.
 */

public class SanPham {
    private String productCode;
    private String productName;
    private int price;
    private double qty;
    private boolean isView;

    public SanPham(String productCode, String productName, int price, double qty, boolean isView) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
        this.isView = isView;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public boolean isView() {
        return isView;
    }

    public void setView(boolean view) {
        isView = view;
    }
}
