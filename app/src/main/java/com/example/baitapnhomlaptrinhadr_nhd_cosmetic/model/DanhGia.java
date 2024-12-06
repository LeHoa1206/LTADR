package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class DanhGia {
    @SerializedName("danhGiaID")
    private int danhGiaID;

    @SerializedName("sanPhamID")
    private int sanPhamID;

    @SerializedName("nguoiDungID")
    private int nguoiDungID;

    @SerializedName("danhGia")
    private String danhGia;

    @SerializedName("diem")
    private int diem;

    @SerializedName("ngayDanhGia")
    private Date ngayDanhGia;

    // Getters and Setters
    public int getDanhGiaID() {
        return danhGiaID;
    }

    public void setDanhGiaID(int danhGiaID) {
        this.danhGiaID = danhGiaID;
    }

    public int getSanPhamID() {
        return sanPhamID;
    }

    public void setSanPhamID(int sanPhamID) {
        this.sanPhamID = sanPhamID;
    }

    public int getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(int nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Date getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(Date ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }
}
