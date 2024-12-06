package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

public class NguoiDung {
    private int NguoiDungID;
    private String TenDangNhap;
    private String HoTen;
    private String Email;
    private String SoDienThoai;
    private String DiaChi;
    private String LoaiNguoiDung;

    // Getter và Setter
    public int getNguoiDungID() {
        return NguoiDungID;
    }

    public void setNguoiDungID(int nguoiDungID) {
        NguoiDungID = nguoiDungID;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        TenDangNhap = tenDangNhap;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getLoaiNguoiDung() {
        return LoaiNguoiDung;
    }

    public void setLoaiNguoiDung(String loaiNguoiDung) {
        LoaiNguoiDung = loaiNguoiDung;
    }
}
