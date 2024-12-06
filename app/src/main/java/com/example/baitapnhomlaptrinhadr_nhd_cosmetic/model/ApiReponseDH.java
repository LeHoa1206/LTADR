package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiReponseDH {
    @SerializedName("success")
    private boolean success;  // Biến để kiểm tra trạng thái thành công

    @SerializedName("message")
    private String message;   // Biến để lưu thông điệp từ API

    @SerializedName("result")
    private List<DonHangAdmin> result; // Danh sách các đơn hàng

    // Constructor
    public ApiReponseDH(boolean success, String message, List<DonHangAdmin> result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    // Getter và Setter
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DonHangAdmin> getResult() {
        return result; // Trả về danh sách DonHang
    }

    public void setResult(List<DonHangAdmin> result) {
        this.result = result; // Thiết lập danh sách DonHang
    }

    @Override
    public String toString() {
        return "ApiReponseDH{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
