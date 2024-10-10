package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class hotro extends AppCompatActivity {

    private LinearLayout messageContainer;
    private EditText edtMessage;
    private ImageButton btnSend, btnback;
    private ScrollView scrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotro); // Đảm bảo rằng tệp XML tên là hotro.xml

        messageContainer = findViewById(R.id.message_container);
        edtMessage = findViewById(R.id.edt_message);
        btnSend = findViewById(R.id.btn_send);
        scrollView = findViewById(R.id.scrollview);
        btnback=findViewById(R.id.btn_back);
        // Thêm tin nhắn mẫu
        addMessage("Chào bạn! Tôi là admin. Bạn cần giúp gì?", true);
        addMessage("Tôi cần biết thông tin về sản phẩm.", false);
        addMessage("Bạn muốn biết thông tin về sản phẩm nào?", true);
        addMessage("Tôi muốn biết về các loại son môi.", false);
        addMessage("Chúng tôi có nhiều loại son môi. Bạn muốn loại nào?", true);
        addMessage("Son môi lâu trôi có không?", false);
        addMessage("Có, chúng tôi có dòng son môi lâu trôi rất được ưa chuộng.", true);
        addMessage("Giá cả thế nào?", false);
        addMessage("Giá của dòng son lâu trôi là 350,000 VND.", true);
        addMessage("Cảm ơn bạn đã cung cấp thông tin.", false);

        // Thiết lập sự kiện cho nút Gửi
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = edtMessage.getText().toString().trim();
                if (!message.isEmpty()) {
                    addMessage(message, false); // Gửi tin nhắn từ người mua hàng
                    edtMessage.setText(""); // Xóa ô nhập sau khi gửi
                }
            }
        });
        btnback.setOnClickListener(view -> {
            Intent intent = new Intent(hotro.this, menu.class);
            startActivity(intent);
        });
    }

    private void addMessage(String message, boolean isAdmin) {
        TextView textView = new TextView(this);
        textView.setText(message);
        // Thay đổi kích thước chữ cho tin nhắn
        textView.setTextSize(20); // Kích thước chữ (đơn vị: sp)

        // Đặt padding lớn hơn để tin nhắn rõ ràng
        textView.setPadding(24, 24, 24, 24);

        // Đặt background cho tin nhắn (admin hoặc người dùng)
        textView.setBackgroundResource(isAdmin ? R.drawable.bg_message_admin : R.drawable.bg_message_user);

        // Đặt các thuộc tính để căn chỉnh tin nhắn
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.gravity = isAdmin ? Gravity.START : Gravity.END; // Căn trái cho admin, căn phải cho người dùng
        textView.setLayoutParams(params);
        params.setMargins(0, 0, 0, 30);
        // Thêm tin nhắn vào khung chứa
        messageContainer.addView(textView);

        // Cuộn xuống để hiển thị tin nhắn mới nhất
        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
    }

}
