package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DangNhap extends AppCompatActivity {
    private EditText editTextPassword;
    private ImageView imageViewVisibility;
    private boolean isPasswordVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_nhap);

        editTextPassword = findViewById(R.id.edit_text_password);
        imageViewVisibility = findViewById(R.id.login_password);

        imageViewVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle password visibility
                if (isPasswordVisible) {
                    // Nếu mật khẩu đang hiển thị, ẩn nó
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imageViewVisibility.setImageResource(R.drawable.eyes); // Biểu tượng mắt mở
                } else {
                    // Nếu mật khẩu đang ẩn, hiện nó
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imageViewVisibility.setImageResource(R.drawable.eye_close); // Biểu tượng mắt đóng
                }
                isPasswordVisible = !isPasswordVisible; // Đảo ngược trạng thái
                // Đặt lại con trỏ về cuối EditText
                editTextPassword.setSelection(editTextPassword.getText().length());
            }
        });
    }
}
