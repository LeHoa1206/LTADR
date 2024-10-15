package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class tichdiem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tichdiem); // Liên kết với file XML của bạn

        // Ánh xạ nút "Đổi điểm lấy voucher"
        Button btnRedeemVoucher = findViewById(R.id.btn_redeem_voucher);

        // Thiết lập sự kiện click cho nút
        btnRedeemVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang DoiVoucherActivity
                Intent intent = new Intent(tichdiem.this, doidiemlayvoucher.class);
                startActivity(intent);
            }
        });
    }
}
