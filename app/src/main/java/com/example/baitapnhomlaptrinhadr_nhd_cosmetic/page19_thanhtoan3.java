package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class page19_thanhtoan3 extends AppCompatActivity
{
    ImageView back;

    Button tieptuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_19_thanhtoan3);  // Đảm bảo file XML tồn tại
        tieptuc = findViewById(R.id.Tieptucmuasam);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // Set up button click listener
        tieptuc.setOnClickListener(view -> {
            Intent intent = new Intent(page19_thanhtoan3.this, page10_Trangchu.class);
            startActivity(intent);
        });
    }

}

