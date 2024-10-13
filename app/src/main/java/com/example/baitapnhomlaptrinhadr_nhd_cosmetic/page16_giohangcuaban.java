package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class page16_giohangcuaban extends AppCompatActivity
{
    ImageView backButton;
    Button paymentButton_page16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_16_giohangcuaban);  // Đảm bảo file XML tồn tại

        // Tìm nút backButton sau khi setContentView
        backButton = findViewById(R.id.backButton_page16);
        paymentButton_page16=findViewById(R.id.paymentButton_page16);
        // Đăng ký sự kiện click cho backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển về MainActivity (trang chủ)
                Intent intent = new Intent(page16_giohangcuaban.this, page10_Trangchu.class);
                startActivity(intent);
                // Kết thúc activity hiện tại nếu không muốn quay lại trang này
                finish();
            }
        });
        paymentButton_page16.setOnClickListener(view -> {
            Intent intent = new Intent(page16_giohangcuaban.this, page17_thanhtoan1.class);
            startActivity(intent);
        });
    }
}

