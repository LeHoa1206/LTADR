package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent; // Import Intent
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.CountDownTimer;

public class Macode extends AppCompatActivity {

    private EditText codeDigit1, codeDigit2, codeDigit3, codeDigit4;
    private Button btnConfirm;
    private TextView timerTextView, resendCodeTextView; // Thêm TextView cho Gửi lại mã
    private CountDownTimer countDownTimer;
    private static final long START_TIME_IN_MILLIS = 30000; // Thay đổi thời gian đếm ngược nếu cần

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ma_code); // Đảm bảo tên XML đúng

        // Khởi tạo các thành phần
        ImageButton btnBack = findViewById(R.id.btn_back);
        codeDigit1 = findViewById(R.id.code_digit_1);
        codeDigit2 = findViewById(R.id.code_digit_2);
        codeDigit3 = findViewById(R.id.code_digit_3);
        codeDigit4 = findViewById(R.id.code_digit_4);
        btnConfirm = findViewById(R.id.btn_confirm);
        timerTextView = findViewById(R.id.timerTextView);
        resendCodeTextView = findViewById(R.id.resendCodeTextView); // Thêm TextView Gửi lại mã

        // Bắt đầu đồng hồ đếm ngược
        startTimer();

        // Xử lý sự kiện nhấn nút quay lại
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Xử lý sự kiện nhấn nút xác nhận
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy mã xác minh đã nhập
                String enteredCode = codeDigit1.getText().toString() +
                        codeDigit2.getText().toString() +
                        codeDigit3.getText().toString() +
                        codeDigit4.getText().toString();

                // Kiểm tra mã (thay thế bằng logic kiểm tra thực tế của bạn)
                if (isCodeValid(enteredCode)) {
                    Toast.makeText(Macode.this, "Mã xác minh hợp lệ!", Toast.LENGTH_SHORT).show();

                    // Chuyển đến Taotaikhoanmoi Activity
                    Intent intent = new Intent(Macode.this, Taomatkhaumoi.class);
                    startActivity(intent);
                    finish(); // Kết thúc activity hiện tại nếu không cần trở lại
                } else {
                    Toast.makeText(Macode.this, "Mã xác minh không hợp lệ. Vui lòng thử lại!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý sự kiện nhấn "Gửi lại mã"
        resendCodeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gửi mã mới (thêm logic gửi mã ở đây nếu cần)
                Toast.makeText(Macode.this, "Mã đã được gửi lại!", Toast.LENGTH_SHORT).show();
                startTimer(); // Khởi động lại đồng hồ đếm ngược
            }
        });
    }

    // Bắt đầu đồng hồ đếm ngược
    private void startTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel(); // Hủy đồng hồ đếm ngược hiện tại nếu có
        }
        countDownTimer = new CountDownTimer(START_TIME_IN_MILLIS, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Cập nhật TextView với thời gian còn lại
                int secondsRemaining = (int) (millisUntilFinished / 1000);
                timerTextView.setText("Gửi lại sau " + secondsRemaining + " giây");
            }

            @Override
            public void onFinish() {
                // Đồng hồ đếm ngược kết thúc, cho phép gửi lại mã
                timerTextView.setText("Mã đã hết hạn, bạn có thể gửi lại mã.");
            }
        }.start();
    }

    // Phương thức kiểm tra mã xác minh
    private boolean isCodeValid(String code) {
        // Ví dụ: kiểm tra xem mã có khớp với mã hợp lệ đã định nghĩa không
        return code.equals("1234"); // Thay thế "1234" bằng mã thực tế của bạn
    }
}
