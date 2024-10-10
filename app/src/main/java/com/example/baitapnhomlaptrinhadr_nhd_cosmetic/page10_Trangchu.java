package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;

public class page10_Trangchu extends AppCompatActivity {
    ImageView btnhomeButton,btnhoso,img_menu;
    DrawerLayout drawerLayout; // Khai báo DrawerLayout
    NavigationView navigationView; // Khai báo NavigationView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_10_trangchu); // Đảm bảo layout này tồn tại
        btnhomeButton=findViewById(R.id.imgmenu);
        // Khởi tạo các thành phần
        drawerLayout = findViewById(R.id.drawer_layout);
        btnhomeButton.setOnClickListener(view -> {
            Intent intent = new Intent(page10_Trangchu.this, menu.class);
            startActivity(intent);
        });
        // Thiết lập sự kiện cho nút quay lại

    }


}
