package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class page2_khamphangay extends AppCompatActivity {
    Button btnforward;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_2_khamphangay);
        btnforward=findViewById(R.id.button_page2);
        // Xử lý sự kiện cho nút "Tiếp theo"
        btnforward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(page2_khamphangay.this, page3_khamphangay.class);
                startActivity(intent);

            }
        });
    }
}