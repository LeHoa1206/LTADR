package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.respone;

import com.google.gson.annotations.SerializedName;

public class BinhLuanRespone {
    @SerializedName("tenNguoiDung")
    private String tenNguoiDung;
    @SerializedName("NoiDung")
    private String NoiDung;

    @SerializedName("ngayDanhGia")
    private String ngayDanhGia;

    public BinhLuanRespone(String tenNguoiDung, String noiDung, String ngayDanhGia) {
        this.tenNguoiDung = tenNguoiDung;
        NoiDung = noiDung;
        this.ngayDanhGia = ngayDanhGia;
    }

    public String getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(String ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }

    public BinhLuanRespone(String tenNguoiDung, String noiDung) {
        this.tenNguoiDung = tenNguoiDung;
        NoiDung = noiDung;
    }

    public BinhLuanRespone() {
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }
}
