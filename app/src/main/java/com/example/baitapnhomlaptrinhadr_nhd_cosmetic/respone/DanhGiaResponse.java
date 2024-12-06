package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.respone;

import com.google.gson.annotations.SerializedName;

public class DanhGiaResponse {
    @SerializedName("SanPhamID")
    private int SanPhamID;
    @SerializedName("averageRating")
    private double averageRating;

    public DanhGiaResponse(Integer sanPhamID, double averageRating) {
        SanPhamID = sanPhamID;
        this.averageRating = averageRating;
    }

    public DanhGiaResponse() {
    }

    public Integer getSanPhamID() {
        return SanPhamID;
    }

    public void setSanPhamID(Integer sanPhamID) {
        SanPhamID = sanPhamID;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
