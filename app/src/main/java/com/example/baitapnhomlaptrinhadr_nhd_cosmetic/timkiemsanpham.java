package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class timkiemsanpham extends AppCompatActivity {
    TextView xemtatca;
    LinearLayout timkiemsanpham;
    ImageButton btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timkiemsanpham);

        // Ánh xạ các thành phần giao diện


//        btnback=findViewById(R.id.btnBack);

        // Sự kiện khi nhấn nút quay lại
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kết thúc Activity khi nhấn nút quay lại
                finish();
            }
        });
    }
}