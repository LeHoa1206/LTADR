package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class doidiemlayvoucher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doidiemlayvoucher); // Liên kết với file XML của bạn

        // Ánh xạ nút "Đổi ngay" cho các voucher
        Button btnVoucher1 = findViewById(R.id.btn_voucher1);
        Button btnVoucher2 = findViewById(R.id.btn_voucher2);
        Button btnVoucher3 = findViewById(R.id.btn_voucher3);

        // Thiết lập sự kiện click cho nút "Đổi ngay"
        View.OnClickListener redeemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay về trang chủ
                Intent intent = new Intent(doidiemlayvoucher.this, page10_Trangchu.class);
                startActivity(intent);
                finish(); // Kết thúc Activity hiện tại
            }
        };

        // Ánh xạ sự kiện cho cả 3 nút
        btnVoucher1.setOnClickListener(redeemClickListener);
        btnVoucher2.setOnClickListener(redeemClickListener);
        btnVoucher3.setOnClickListener(redeemClickListener);
    }
}
