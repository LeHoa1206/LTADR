package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

import com.google.gson.annotations.SerializedName;

public class AddDonHangRequest {
    @SerializedName("NguoiDungID")
    private Integer nguoiDungID;

    @SerializedName("NgayDat")
    private String ngayDat;

    @SerializedName("TrangThai")
    private String trangThai;

    // Getter và Setter
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
}
