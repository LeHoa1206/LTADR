package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

import com.google.gson.annotations.SerializedName;

public class DonHangAdmin {
    @SerializedName("DonHangID")
    private int donHangID;

    @SerializedName("NguoiDungID")
    private Integer nguoiDungID; // Có thể nhận giá trị null

    @SerializedName("NgayDat")
    private String ngayDat; // Duy trì dưới dạng String

    @SerializedName("TrangThai")
    private String trangThai;

    @SerializedName("ThoiGianCapNhat")
    private String thoiGianCapNhat; // Duy trì dưới dạng String

    // Getter và Setter
    public int getDonHangID() {
        return donHangID;
    }

    public void setDonHangID(int donHangID) {
        this.donHangID = donHangID;
    }

    public Integer getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(Integer nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getThoiGianCapNhat() {
        return thoiGianCapNhat;
    }

    public void setThoiGianCapNhat(String thoiGianCapNhat) {
        this.thoiGianCapNhat = thoiGianCapNhat;
    }

}
