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

public class page18_thanhtoan2 extends AppCompatActivity
{
    ImageView back;
    Button btndathang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_18_thanhtoan2);
        btndathang = findViewById(R.id.Dathang);
         back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // Set up button click listener
        btndathang.setOnClickListener(view -> {
            Intent intent = new Intent(page18_thanhtoan2.this, page19_thanhtoan3.class);
            startActivity(intent);
        });
    }
}

