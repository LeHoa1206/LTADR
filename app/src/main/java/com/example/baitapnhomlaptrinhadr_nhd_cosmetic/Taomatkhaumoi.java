package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Taomatkhaumoi extends AppCompatActivity {

    private EditText passwordEditText, confirmPasswordEditText;
    private Button buttonCheck;
    private LinearLayout notificationLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tao_mat_khau_moi); // Đảm bảo tên tệp XML khớp

        // Khởi tạo các thành phần giao diện
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        buttonCheck = findViewById(R.id.buttonCheck);

        // Xử lý sự kiện khi nhấn nút xác nhận
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                // Kiểm tra mật khẩu
                if (password.isEmpty()) {
                    Toast.makeText(Taomatkhaumoi.this, "Vui lòng nhập mật khẩu.", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(Taomatkhaumoi.this, "Mật khẩu không khớp.", Toast.LENGTH_SHORT).show();
                } else {
                    // Chuyển đến trang Reset Password
                    Intent intent = new Intent(Taomatkhaumoi.this, resestpasswordsuccess.class);
                    startActivity(intent);
                    finish(); // Kết thúc Activity hiện tại
                }
            }
        });
    }
}
