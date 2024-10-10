package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class setting extends AppCompatActivity {

    private Spinner spinnerLanguage;
    private Switch switchNotifications;
    private TextView tvTermsOfService, tvPrivacyPolicy, tvChatSupport, tvNotificationTitle;
    private LinearLayout notificationLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting); // Liên kết với file settings.xml

        // Ánh xạ các thành phần giao diện
//        spinnerLanguage = findViewById(R.id.spinner_language);
        switchNotifications = findViewById(R.id.switch_notifications);
        tvTermsOfService = findViewById(R.id.tv_terms_of_service);
        tvPrivacyPolicy = findViewById(R.id.tv_privacy_policy);
        tvChatSupport = findViewById(R.id.tv_chat_support);
        tvNotificationTitle = findViewById(R.id.tv_notifications_label); // Thêm TextView tiêu đề thông báo


        // Ẩn Switch khi khởi động
        switchNotifications.setVisibility(View.GONE);

        // Xử lý sự kiện chọn ngôn ngữ
//        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String selectedLanguage = parent.getItemAtPosition(position).toString();
//                // Thay đổi ngôn ngữ dựa trên lựa chọn (Cần thêm chức năng thay đổi ngôn ngữ)
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // Không làm gì nếu không có lựa chọn
//            }
//        });

        // Hiện/ẩn Switch khi click vào tiêu đề thông báo
        tvNotificationTitle.setOnClickListener(v -> {
            if (switchNotifications.getVisibility() == View.GONE) {
                switchNotifications.setVisibility(View.VISIBLE); // Hiện Switch
            } else {
                switchNotifications.setVisibility(View.GONE); // Ẩn Switch
            }
        });

        // Xử lý bật/tắt thông báo
        switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Lưu trạng thái bật/tắt thông báo
            // (Bạn có thể thêm logic lưu thông báo trong SharedPreferences)
        });

//        // Điều khoản sử dụng
//        tvTermsOfService.setOnClickListener(v -> {
//            // Mở trang Điều khoản sử dụng
//            Intent intent = new Intent(setting.this, TermsOfServiceActivity.class);
//            startActivity(intent);
//        });
//
//        // Chính sách bảo mật
//        tvPrivacyPolicy.setOnClickListener(v -> {
//            // Mở trang Chính sách bảo mật
//            Intent intent = new Intent(setting.this, PrivacyPolicyActivity.class);
//            startActivity(intent);
//        });

        // Chat hỗ trợ khách hàng
        tvChatSupport.setOnClickListener(v -> {
            // Mở trang Chat hỗ trợ
            Intent intent = new Intent(setting.this, hotro.class);
            startActivity(intent);
        });
    }
}
