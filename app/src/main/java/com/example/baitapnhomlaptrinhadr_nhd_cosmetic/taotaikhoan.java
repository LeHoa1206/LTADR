package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.Chatactivity.SignupActivity;

public class taotaikhoan extends AppCompatActivity {

    // Khai báo các view
    private EditText edtName, edtEmail, edtPassword;
    private Button btnDangKy;
    private TextView tvDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tao_tai_khoan);  // Đảm bảo file XML layout tương ứng

        // Ánh xạ các view từ XML
//        edtName = findViewById(R.id.edtName);
//        edtEmail = findViewById(R.id.edtEmail);
//        edtPassword = findViewById(R.id.edtPassword);
        btnDangKy = findViewById(R.id.btnDangKy);
        tvDangNhap = findViewById(R.id.DangNhap);

        // Sự kiện khi nhấn nút "Đăng Ký"
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                // Kiểm tra các trường hợp nhập thiếu
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(taotaikhoan.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Thực hiện logic đăng ký (ví dụ: lưu thông tin vào cơ sở dữ liệu hoặc gọi API)
                    Toast.makeText(taotaikhoan.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

                    // Chuyển đến màn hình đăng nhập sau khi đăng ký thành công
                    Intent intent = new Intent(taotaikhoan.this, SignupActivity.class);  // Màn hình LoginActivity
                    startActivity(intent);
                    finish(); // Đóng activity hiện tại để không quay lại được trang đăng ký
                }
            }
        });

        // Sự kiện khi nhấn vào "Đăng Nhập"
        tvDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến màn hình đăng nhập
                Intent intent = new Intent(taotaikhoan.this, SignupActivity.class);  // Màn hình LoginActivity
                startActivity(intent);
                finish(); // Đóng activity hiện tại
            }
        });
    }
}
