package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class page10_Trangchu extends AppCompatActivity {
    ImageView btnhomeButton,btnhoso,img_menu,tichdiem;
    LinearLayout sanphambieutuong;
    DrawerLayout drawerLayout; // Khai báo DrawerLayout
    NavigationView navigationView; // Khai báo NavigationView
    ImageView nam,nu,phukien,lamdep,timkiem,giohang,canhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_10_trangchu); // Đảm bảo layout này tồn tại
        btnhomeButton=findViewById(R.id.imgmenu);
        timkiem=findViewById(R.id.btntimkiem);
        sanphambieutuong=findViewById(R.id.sanphambieutuong);
        nam=findViewById(R.id.pagenam);
        nu=findViewById(R.id.pagenu);
        phukien=findViewById(R.id.pagephukien);
        lamdep=findViewById(R.id.pagelamdep);
        giohang=findViewById(R.id.btngiohang);
        canhan=findViewById(R.id.btncanhan);
        tichdiem=findViewById(R.id.tichdiem);

        // Khởi tạo các thành phần
        drawerLayout = findViewById(R.id.drawer_layout);
        btnhomeButton.setOnClickListener(view -> {
            Intent intent = new Intent(page10_Trangchu.this, menu.class);
            startActivity(intent);
        });
        timkiem.setOnClickListener(view -> {
            Intent intent = new Intent(page10_Trangchu.this, timkiem.class);
            startActivity(intent);
        });
        nam.setOnClickListener(view -> {
            Intent intent = new Intent(page10_Trangchu.this, page8_Trangchu_Nam.class);
            startActivity(intent);
        });
        nu.setOnClickListener(view -> {
            Intent intent = new Intent(page10_Trangchu.this, page9_Trangchu_Nu.class);
            startActivity(intent);
        });
        phukien.setOnClickListener(view -> {
            Intent intent = new Intent(page10_Trangchu.this, page11_Trangchu.class);
            startActivity(intent);
        });
        lamdep.setOnClickListener(view -> {
            Intent intent = new Intent(page10_Trangchu.this, page12_Trangchu.class);
            startActivity(intent);
        });
        giohang.setOnClickListener(view -> {
                Intent intent = new Intent(page10_Trangchu.this, page16_giohangcuaban.class);
                startActivity(intent);
        });
        canhan.setOnClickListener(view -> {
            Intent intent = new Intent(page10_Trangchu.this, page20_donhangcuatoi.class);
            startActivity(intent);
        });
        sanphambieutuong.setOnClickListener(view -> {
            Intent intent = new Intent(page10_Trangchu.this, chitietsanpham.class);
            startActivity(intent);
        });
        tichdiem.setOnClickListener(view -> {
            Intent intent = new Intent(page10_Trangchu.this, tichdiem.class);
            startActivity(intent);
        });
//        btnhomeButton.setOnClickListener(view -> {
//            Intent intent = new Intent(page8_Trangchu.this, page10_Trangchu.class);
//            startActivity(intent);
//        });
//        img_menu.setOnClickListener(view -> {
//            Intent intent = new Intent(page8_Trangchu.this, menu.class);
//            startActivity(intent);
//        });
//         Thiết lập sự kiện cho nút quay lại

    }


}
