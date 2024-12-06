package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

public class AddToCartRequest {
    private int nguoiDungID;
    private int sanPhamID;
    private int soLuong;

    public AddToCartRequest(int nguoiDungID, int sanPhamID, int soLuong) {
        this.nguoiDungID = nguoiDungID;
        this.sanPhamID = sanPhamID;
        this.soLuong = soLuong;
    }

    // Getter và Setter
    public int getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(int nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    public int getSanPhamID() {
        return sanPhamID;
    }

    public void setSanPhamID(int sanPhamID) {
        this.sanPhamID = sanPhamID;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}

