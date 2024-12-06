package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class LichSuMuaHang {
    @SerializedName("lichSuMuaHangID")
    private int lichSuMuaHangID;

    @SerializedName("nguoiDungID")
    private int nguoiDungID;

    @SerializedName("donHangID")
    private int donHangID;

    @SerializedName("ngayMua")
    private Date ngayMua;

    // Getters and Setters
    public int getLichSuMuaHangID() {
        return lichSuMuaHangID;
    }

    public void setLichSuMuaHangID(int lichSuMuaHangID) {
        this.lichSuMuaHangID = lichSuMuaHangID;
    }

    public int getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(int nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    public int getDonHangID() {
        return donHangID;
    }

    public void setDonHangID(int donHangID) {
        this.donHangID = donHangID;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }
}
