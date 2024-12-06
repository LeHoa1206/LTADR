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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    private EditText tendangnhap, matkhau, name;
    private Button register;
    private TextView dangnhap;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.tao_tai_khoan);

        // Initialize database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        // Link UI components
        name = findViewById(R.id.name);
        dangnhap = findViewById(R.id.DangNhap);
        tendangnhap = findViewById(R.id.tendangnhap);
        matkhau = findViewById(R.id.matkhau);
        register = findViewById(R.id.btnDangKy);

        // Register button click listener
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString().trim();
                String username = tendangnhap.getText().toString().trim();
                String password = matkhau.getText().toString().trim();

                if (validateInput(nameStr, username, password)) {
                    signup(username, password, nameStr);
                }
            }
        });

        // Login button click listener
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, SigninActivity.class));
            }
        });
    }

    private boolean validateInput(String nameStr, String username, String password) {
        if (TextUtils.isEmpty(nameStr)) {
            name.setError("Hãy nhập tên đầy đủ");
            name.requestFocus();
            return false;
        }
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

    private void signup(String username, String password, String nameStr) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(username, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                        if (firebaseUser != null) {
                            UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(nameStr).build();
                            firebaseUser.updateProfile(userProfileChangeRequest);
                        }

                        UserModel userModel = new UserModel(firebaseUser.getUid(), nameStr, username, password);
                        databaseReference.child(firebaseUser.getUid()).setValue(userModel);

                        Toast.makeText(SignupActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                        // Chuyển qua trang đăng nhập sau khi đăng ký thành công
                        startActivity(new Intent(SignupActivity.this, SigninActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignupActivity.this, "Đăng kí thất bại: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(SignupActivity.this, SigninActivity.class));
            finish();
        }
    }
}
