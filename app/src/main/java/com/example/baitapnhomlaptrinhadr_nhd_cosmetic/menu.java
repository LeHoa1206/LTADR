package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;  // Nhập khẩu lớp Log
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.Chatactivity.SignupActivity;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.Chatactivity.hotro;

public class menu extends AppCompatActivity {
    Button buttonTrangChu,buttonLogout, buttonProfile, buttonOrders, buttonExplore, buttonSettings, buttonSupport, buttonAbout;

    private static final String TAG = "MenuActivity"; // Đặt tên cho tag để dễ dàng nhận diện

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);  // Đảm bảo rằng layout menu này tồn tại

        // Ghi log để kiểm tra xem Activity đã được khởi động chưa
        Log.d(TAG, "Menu Activity started");

        // Khởi tạo các nút
        buttonTrangChu = findViewById(R.id.buttontrangchu);
        buttonProfile = findViewById(R.id.buttonProfile);
        buttonOrders = findViewById(R.id.buttonOrders);
        buttonExplore = findViewById(R.id.buttonExplore);
        buttonSettings = findViewById(R.id.buttonSettings);
        buttonSupport = findViewById(R.id.buttonSupport);
        buttonAbout = findViewById(R.id.buttonAbout);
        buttonLogout = findViewById(R.id.buttonLogout);

        // Thiết lập sự kiện nhấn nút
        buttonTrangChu.setOnClickListener(view -> {
            Log.d(TAG, "Button Trang Chủ clicked!"); // Ghi log khi nhấn nút Trang Chủ
            openActivity(MainActivity.class);
        });

        buttonProfile.setOnClickListener(view -> {
            Log.d(TAG, "Button Hồ Sơ clicked!"); // Ghi log khi nhấn nút Hồ Sơ
            openActivity(hoso.class);
        });
        buttonLogout.setOnClickListener(view -> {
            Log.d(TAG, "Button Hồ Sơ clicked!"); // Ghi log khi nhấn nút Hồ Sơ
            openActivity(SignupActivity.class);
        });
        buttonOrders.setOnClickListener(view -> {
            Log.d(TAG, "Button Đơn Hàng clicked!"); // Ghi log khi nhấn nút Đơn Hàng
            openActivity(page16_giohangcuaban.class);
        });

        buttonExplore.setOnClickListener(view -> {
            Log.d(TAG, "Button Khám Phá clicked!"); // Ghi log khi nhấn nút Khám Phá
            openActivity(timkiem.class);
        });
//
        buttonSettings.setOnClickListener(view -> {
            Log.d(TAG, "Button Cài Đặt clicked!"); // Ghi log khi nhấn nút Cài Đặt
            openActivity(setting.class);
        });
//
        buttonSupport.setOnClickListener(view -> {
            Log.d(TAG, "Button Hỗ Trợ clicked!"); // Ghi log khi nhấn nút Hỗ Trợ
            openActivity(hotro.class);
        });
//
//        buttonAbout.setOnClickListener(view -> {
//            Log.d(TAG, "Button Giới Thiệu clicked!"); // Ghi log khi nhấn nút Giới Thiệu
//            openActivity(AboutActivity.class);
//        });
 }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(menu.this, activityClass);
        startActivity(intent);
    }
}
