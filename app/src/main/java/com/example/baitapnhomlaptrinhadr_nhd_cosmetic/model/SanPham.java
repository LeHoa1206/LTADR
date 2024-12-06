package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SanPham {
    private String SanPhamID;
    private String TenSanPham;
    private String MoTa;
    private String Gia;
    private String SoLuong;
    private String HinhAnh;
    private String NgayCapNhat;
    private List<DanhGia> danhGiaList; // Danh sách đánh giá

    // Getters and Setters
    public String getSanPhamID() {
        return SanPhamID;
    }

    public void setSanPhamID(String sanPhamID) {
        SanPhamID = sanPhamID;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String soLuong) {
        SoLuong = soLuong;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getNgayCapNhat() {
        return NgayCapNhat;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        NgayCapNhat = ngayCapNhat;
    }
    public List<DanhGia> getDanhGiaList() {
        return danhGiaList;
    }

    public void addDanhGia(DanhGia danhGia) {
        danhGiaList.add(danhGia);
    }
}
