package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class page8_Trangchu extends AppCompatActivity {
    Button btnforward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page8_cosmetic);  // Đảm bảo layout này tồn tại

        // Tìm nút "Tiếp theo" bằng ID
//        btnforward = findViewById(R.id.btnforward);  // Đảm bảo bạn có nút với id btnforward trong layout
//
//        // Xử lý sự kiện cho nút "Tiếp theo"
//        btnforward.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Intent chuyển từ page8_Trangchu sang một activity khác
//                Intent intent = new Intent(page8_Trangchu.this, page4_khamphangay.class);
//                startActivity(intent);
//            }
//        });
    }
}
