package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class page8_Trangchu extends AppCompatActivity {
   ImageView btnhomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page8_cosmetic);  // Đảm bảo layout này tồn tại
        btnhomeButton=findViewById(R.id.btnhome);
        btnhomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(page8_Trangchu.this,page10_Trangchu.class);
                startActivity(intent);
            }
        });
    }
}
