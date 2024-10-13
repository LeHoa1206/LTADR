package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class theodoidonhang extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theo_doi_don_hang);  // Đảm bảo tên tệp XML đúng

        // Ánh xạ ImageView cho nút quay lại (nếu có)
        ImageView backButton = findViewById(R.id.back);

        // Thiết lập sự kiện khi nhấn vào backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đóng Activity hiện tại
                finish();
            }
        });


    }
}
