package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class GioHang {
    @SerializedName("gioHangID")
    private int gioHangID;

    @SerializedName("nguoiDungID")
    private int nguoiDungID;

    @SerializedName("sanPhamID")
    private int sanPhamID;

    @SerializedName("soLuong")
    private int soLuong;

    @SerializedName("ngayThem")
    private Date ngayThem;

    // Getters and Setters
    public int getGioHangID() {
        return gioHangID;
    }

    public void setGioHangID(int gioHangID) {
        this.gioHangID = gioHangID;
    }

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

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }
}
