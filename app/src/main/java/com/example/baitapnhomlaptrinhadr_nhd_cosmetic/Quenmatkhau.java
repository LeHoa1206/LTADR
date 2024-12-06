package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.Chatactivity.SignupActivity;

public class Quenmatkhau extends AppCompatActivity {
    private EditText editEmail; // Trường nhập email
    private Button btnConfirm; // Nút xác nhận
    private ImageView imgBack; // Nút quay lại

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quen_mat_khau); // Thay R.layout.quen_mat_khau bằng layout của bạn

        // Ánh xạ các thành phần giao diện
        editEmail = findViewById(R.id.edit_email); // Thêm dòng này để ánh xạ EditText cho email
        btnConfirm = findViewById(R.id.btn_confirm); // Thay 'btn_confirm' bằng ID thực tế trong XML
        imgBack = findViewById(R.id.btn_back); // Ánh xạ nút quay lại

        // Thiết lập sự kiện cho nút xác nhận
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim(); // Lấy email từ EditText
                sendResetPasswordEmail(email); // Gọi phương thức gửi email
            }
        });

        // Thiết lập sự kiện cho nút quay lại
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quenmatkhau.this, SignupActivity.class);
                startActivity(intent);
                finish(); // Kết thúc activity hiện tại
            }
        });
    }

    // Phương thức để kiểm tra tính hợp lệ của email
    public boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Phương thức để gửi email đặt lại mật khẩu
    public void sendResetPasswordEmail(String email) {
        if (isEmailValid(email)) {
            // Logic gửi email sẽ được thực hiện ở đây
            // Có thể sử dụng API gửi email hoặc dịch vụ bên thứ ba

            // Hiển thị thông báo gửi thành công
            Toast.makeText(this, "Email đặt lại mật khẩu đã được gửi đến: " + email, Toast.LENGTH_SHORT).show();

            // Chuyển sang Activity nhập mã code
            Intent intent = new Intent(Quenmatkhau.this, Macode.class);
            startActivity(intent);
            finish(); // Kết thúc activity hiện tại
        } else {
            // Hiển thị thông báo nếu email không hợp lệ
            Toast.makeText(this, "Vui lòng nhập email hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
