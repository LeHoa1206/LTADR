package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;

public class page8_Trangchu extends AppCompatActivity {
    ImageView btnhomeButton,btnhoso,img_menu;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page8_cosmetic);
        img_menu = findViewById(R.id.imgmenu);
        btnhomeButton = findViewById(R.id.btnhome);
        drawerLayout = findViewById(R.id.drawer_layout);


        btnhomeButton.setOnClickListener(view -> {
            Intent intent = new Intent(page8_Trangchu.this, page10_Trangchu.class);
            startActivity(intent);
        });
        img_menu.setOnClickListener(view -> {
            Intent intent = new Intent(page8_Trangchu.this, menu.class);
            startActivity(intent);
        });



}


}
