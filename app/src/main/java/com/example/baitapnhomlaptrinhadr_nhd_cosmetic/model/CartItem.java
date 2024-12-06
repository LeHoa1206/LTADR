package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

public class CartItem {
    private int SanPhamID;
    private String TenSanPham;
    private double Gia;
    private int SoLuong;
    private String HinhAnh;
    boolean isSelected ;


    // Constructor, Getter và Setter
    public CartItem(int SanPhamID,String tenSanPham, double gia, int soLuong, String hinhAnh) {
        this.SanPhamID = SanPhamID;
        this.TenSanPham = tenSanPham;
        this.Gia = gia;
        this.SoLuong = soLuong;
        this.HinhAnh = hinhAnh;
    }
    public int getSanPhamID() {
        return SanPhamID;
    }

    public void setSanPhamID(int sanPhamID) {
        this.SanPhamID = sanPhamID;
    }

    // Getters và Setters
    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.TenSanPham = tenSanPham;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        this.Gia = gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        this.SoLuong = soLuong;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.HinhAnh = hinhAnh;
    }
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

