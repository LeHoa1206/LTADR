package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class page9_Trangchu_Nu extends AppCompatActivity {
    ImageView btnhomeButton,btnhoso,img_menu;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView nam,nu,phukien,lamdep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_9_cosmetic_nu);
        img_menu = findViewById(R.id.imgmenu);
        btnhomeButton = findViewById(R.id.btnhome);
        drawerLayout = findViewById(R.id.drawer_layout);
        nam=findViewById(R.id.pagenam);
        nu=findViewById(R.id.pagenu);
        phukien=findViewById(R.id.pagephukien);
        lamdep=findViewById(R.id.pagelamdep);

        btnhomeButton.setOnClickListener(view -> {
            Intent intent = new Intent(page9_Trangchu_Nu.this, page10_Trangchu.class);
            startActivity(intent);
        });
        img_menu.setOnClickListener(view -> {
            Intent intent = new Intent(page9_Trangchu_Nu.this, menu.class);
            startActivity(intent);
        });

        nam.setOnClickListener(view -> {
            Intent intent = new Intent(page9_Trangchu_Nu.this, page8_Trangchu_Nam.class);
            startActivity(intent);
        });
        nu.setOnClickListener(view -> {
            Intent intent = new Intent(page9_Trangchu_Nu.this, page9_Trangchu_Nu.class);
            startActivity(intent);
        });
        phukien.setOnClickListener(view -> {
            Intent intent = new Intent(page9_Trangchu_Nu.this, page11_Trangchu.class);
            startActivity(intent);
        });
        lamdep.setOnClickListener(view -> {
            Intent intent = new Intent(page9_Trangchu_Nu.this, page12_Trangchu.class);
            startActivity(intent);
        });
    }


}
