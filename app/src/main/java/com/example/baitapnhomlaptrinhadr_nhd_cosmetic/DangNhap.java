package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.NguoiDung;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.ApiService;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.RetrofitClient;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangNhap extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button loginhome;
    private ImageView imageViewVisibility;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_nhap);

        // Ánh xạ các view
        editTextUsername = findViewById(R.id.edit_text_username);
        editTextPassword = findViewById(R.id.edit_text_password);
        imageViewVisibility = findViewById(R.id.login_password);
        loginhome = findViewById(R.id.Loginhome);

        // Chức năng mở/đóng mắt mật khẩu
        imageViewVisibility.setOnClickListener(v -> {
            if (isPasswordVisible) {
                editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                imageViewVisibility.setImageResource(R.drawable.eye_close);
            } else {
                editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                imageViewVisibility.setImageResource(R.drawable.eyes);
            }
            isPasswordVisible = !isPasswordVisible;
            editTextPassword.setSelection(editTextPassword.getText().length());
        });

        // Xử lý đăng nhập
        loginhome.setOnClickListener(view -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(DangNhap.this, "Vui lòng nhập tên đăng nhập và mật khẩu", Toast.LENGTH_SHORT).show();
            } else {
                loginUser(username, password);
            }
        });
    }

    // Gọi API để đăng nhập
    private void loginUser(String username, String password) {
        ApiService apiService = RetrofitClient.getInstance("http://192.168.0.102/WebbanhangLH/").create(ApiService.class);
        Call<NguoiDung> call = apiService.loginUser(username, password);

        call.enqueue(new Callback<NguoiDung>() {

            @Override
            public void onResponse(Call<NguoiDung> call, Response<NguoiDung> response) {
                // In ra nội dung phản hồi JSON để kiểm tra
                try {
                    String responseBody = response.body() != null ? new Gson().toJson(response.body()) : "No response body";
                    Log.d("Response Body", responseBody); // Kiểm tra thông tin JSON

                    if (response.isSuccessful()) {
                        NguoiDung userResponse = response.body();
                        if (userResponse != null) {
                            String tenDangNhap = userResponse.getTenDangNhap();
                            if (tenDangNhap != null) {
                                Toast.makeText(DangNhap.this, "Xin chào: " + tenDangNhap, Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(DangNhap.this, "Tên đăng nhập từ server trả về NULL!", Toast.LENGTH_SHORT).show();
                            }

                            if (tenDangNhap != null && tenDangNhap.equalsIgnoreCase(username)) {
                                String loaiNguoiDung = userResponse.getLoaiNguoiDung();
                                Log.d("LoaiNguoiDung", "Loại người dùng: " + loaiNguoiDung);
                                if ("Khách hàng".equalsIgnoreCase(loaiNguoiDung)) {
                                    SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putInt("idNguoiDung", userResponse.getNguoiDungID()); // Lưu ID người dùng
                                    editor.apply();

                                    // Nếu là khách hàng, đăng nhập thành công và chuyển đến trang chủ
                                    Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(DangNhap.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Nếu không phải khách hàng, thông báo lỗi hoặc chuyển hướng khác
                                    Toast.makeText(DangNhap.this, "Chỉ khách hàng mới có thể truy cập!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(DangNhap.this, "Tên đăng nhập hoặc mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(DangNhap.this, "Phản hồi không hợp lệ từ server", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(DangNhap.this, "Mã lỗi HTTP: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(DangNhap.this, "Lỗi đọc phản hồi: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NguoiDung> call, Throwable t) {
                Log.e("LoginError", "Error: " + t.getMessage());
                Toast.makeText(DangNhap.this, "Đăng nhập thất bại: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
    }
}
