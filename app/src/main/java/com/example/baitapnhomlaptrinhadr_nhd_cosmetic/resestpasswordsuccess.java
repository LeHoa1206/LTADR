package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.Chatactivity.SignupActivity;

public class resestpasswordsuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resestmatkhauthanhcong);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay lại trang đăng nhập
                Intent intent = new Intent(resestpasswordsuccess.this, SignupActivity.class);
                startActivity(intent);
                finish(); // Kết thúc Activity này
            }
        });
    }
}
