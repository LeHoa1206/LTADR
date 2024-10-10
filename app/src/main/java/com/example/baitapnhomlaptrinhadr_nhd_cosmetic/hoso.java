package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class hoso extends AppCompatActivity {

    private ImageButton btnBack;
    private ImageView imgProfile;
    private Button btnUpdatePicture;
    private Button btnUpdateInfo;
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtEmail;
    private Spinner spinnerGender;
    private EditText edtPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hoso); // Thay đổi theo tên XML của bạn

        // Ánh xạ các thành phần
        btnBack = findViewById(R.id.btnback);
        imgProfile = findViewById(R.id.img_profile);
        btnUpdatePicture = findViewById(R.id.btn_update_picture);
        btnUpdateInfo = findViewById(R.id.btn_update_info);
        edtFirstName = findViewById(R.id.edt_first_name);
        edtLastName = findViewById(R.id.edt_last_name);
        edtEmail = findViewById(R.id.edt_email);
        spinnerGender = findViewById(R.id.spinner_gender);
        edtPhone = findViewById(R.id.edt_phone);

        // Tạo một danh sách giới tính
        String[] genderOptions = {"Nam", "Nữ", "Khác"};

        // Tạo ArrayAdapter và thiết lập cho Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genderOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);

        // Thiết lập sự kiện cho nút "Trở về"
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Activity hiện tại
            }
        });

        // Thiết lập sự kiện cho nút "Cập Nhật Ảnh"
        btnUpdatePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở giao diện để cập nhật ảnh
                Toast.makeText(hoso.this, "Cập nhật ảnh đại diện", Toast.LENGTH_SHORT).show();
                // Thêm mã để mở gallery hoặc camera ở đây
            }
        });

        // Thiết lập sự kiện cho nút "Cập Nhật Thông Tin"
        btnUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các EditText và Spinner
                String firstName = edtFirstName.getText().toString().trim();
                String lastName = edtLastName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String gender = spinnerGender.getSelectedItem().toString();
                String phone = edtPhone.getText().toString().trim();

                // Kiểm tra dữ liệu trước khi cập nhật
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(hoso.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Thực hiện cập nhật thông tin người dùng
                // Thêm mã cập nhật vào cơ sở dữ liệu hoặc API ở đây

                Toast.makeText(hoso.this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
