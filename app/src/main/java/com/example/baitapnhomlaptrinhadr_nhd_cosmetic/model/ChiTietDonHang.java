package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

import com.google.gson.annotations.SerializedName;

public class ChiTietDonHang {
    @SerializedName("chiTietDonHangID")
    private int chiTietDonHangID;

    @SerializedName("donHangID")
    private int donHangID;

    @SerializedName("sanPhamID")
    private int sanPhamID;

    @SerializedName("soLuong")
    private int soLuong;

    @SerializedName("gia")
    private double gia;

    // Getters and Setters
    public int getChiTietDonHangID() {
        return chiTietDonHangID;
    }

    public void setChiTietDonHangID(int chiTietDonHangID) {
        this.chiTietDonHangID = chiTietDonHangID;
    }

    public int getDonHangID() {
        return donHangID;
    }

    public void setDonHangID(int donHangID) {
        this.donHangID = donHangID;
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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
