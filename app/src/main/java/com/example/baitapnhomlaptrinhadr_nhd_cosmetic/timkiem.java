package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class timkiem extends AppCompatActivity {
    TextView xemtatca;
    LinearLayout timkiemsanpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timkiem);

        // Ánh xạ các thành phần giao diện
        EditText searchBar = findViewById(R.id.search_bar);
        ImageView backButton = findViewById(R.id.back_button);
        timkiemsanpham=findViewById(R.id.timkiemsp);
        xemtatca=findViewById(R.id.xemtatca);

        timkiemsanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(timkiem.this , timkiemsanpham.class);
                startActivity(intent);
            }
        });
        // Sự kiện khi nhấn nút quay lại
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kết thúc Activity khi nhấn nút quay lại
                finish();
            }
        });
    }

    // Hàm giả lập tìm kiếm sản phẩm theo từ khóa
    private void searchForProducts(String query) {
        // Hiển thị thông báo tìm kiếm (có thể thay bằng logic tìm kiếm thật)
        Toast.makeText(this, "Tìm kiếm: " + query, Toast.LENGTH_SHORT).show();

        // Thực hiện các bước xử lý kết quả tìm kiếm ở đây, như gọi API hoặc lọc danh sách sản phẩm
    }
}
