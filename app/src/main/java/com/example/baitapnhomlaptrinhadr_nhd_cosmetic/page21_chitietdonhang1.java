package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class page21_chitietdonhang1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_21_chitietdonhang1);  // Đảm bảo file XML tồn tại

        // Ánh xạ ImageView từ layout
        ImageView backButton = findViewById(R.id.back);

        // Thiết lập sự kiện khi nhấn vào backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đóng Activity hiện tại
                finish();
            }
        });

        // Ánh xạ Button thứ hai từ layout
        Button button2 = findViewById(R.id.button2);

        // Thiết lập sự kiện khi nhấn vào button2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở page22 (Activity thứ hai)
                Intent intent = new Intent(page21_chitietdonhang1.this, theodoidonhang.class);
                startActivity(intent);
            }
        });
    }
}
