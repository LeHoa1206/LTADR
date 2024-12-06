package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class NguoiDung_Firebase {
    @SerializedName("nguoiDungID")
    private int nguoiDungID;

    @SerializedName("tenDangNhap")
    private String tenDangNhap;

    @SerializedName("matKhau")
    private String matKhau;

    @SerializedName("hoTen")
    private String hoTen;

    @SerializedName("email")
    private String email;

    @SerializedName("soDienThoai")
    private String soDienThoai;

    @SerializedName("diaChi")
    private String diaChi;

    @SerializedName("loaiNguoiDung")
    private String loaiNguoiDung;

    @SerializedName("ngayDangKy")
    private Date ngayDangKy;

    // Getters and Setters
    public int getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(int nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoaiNguoiDung() {
        return loaiNguoiDung;
    }

    public void setLoaiNguoiDung(String loaiNguoiDung) {
        this.loaiNguoiDung = loaiNguoiDung;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
}
