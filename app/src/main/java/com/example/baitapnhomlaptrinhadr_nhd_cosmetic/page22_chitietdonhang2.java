package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class page22_chitietdonhang2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_22_chitietdonhang2);  // Đảm bảo file XML tồn tại

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
    }
}
