package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.Chatactivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.MainActivity;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.R;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page10_Trangchu;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page11_Trangchu;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class SigninActivity extends AppCompatActivity {
    private EditText tendangnhap, matkhau;
    private Button login;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.dang_nhap);

        // Link UI components
        tendangnhap = findViewById(R.id.tendangnhap);
        matkhau = findViewById(R.id.matkhau);
        login = findViewById(R.id.DangNhap);
        register = findViewById(R.id.DangKy);

        // Login button click listener
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = tendangnhap.getText().toString().trim();
                String password = matkhau.getText().toString().trim();

                if (validateInput(username, password)) {
                    signin(username, password);
                }
            }
        });

        // Register button click listener
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this, SignupActivity.class));
            }
        });
    }

    private boolean validateInput(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            tendangnhap.setError("Hãy nhập tên đăng nhập");
            tendangnhap.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            matkhau.setError("Hãy nhập mật khẩu");
            matkhau.requestFocus();
            return false;
        }
        return true;
    }

    private void signin(String username, String password) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        String displayName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
                        Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                        intent.putExtra("name", displayName);
                        startActivity(intent);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof FirebaseAuthInvalidUserException) {
                            Toast.makeText(SigninActivity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SigninActivity.this, "Lỗi: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
//            startActivity(new Intent(SigninActivity.this, MainActivity.class));
//            finish();
        }
    }
}
