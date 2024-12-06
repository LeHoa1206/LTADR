package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.CartAdapter;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.CartItem;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.respone.ResponseCart;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.ApiService;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.RetrofitClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class page16_giohangcuaban extends AppCompatActivity implements CartAdapter.OnItemCheckListener {
    private List<Integer> selectedProductIds = new ArrayList<>(); // Danh sách ID sản phẩm được chọn

    private RecyclerView rvCart;
    private CartAdapter cartAdapter;
    private TextView totalPriceTextView;
    private List<CartItem> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_16_giohangcuaban);

        rvCart = findViewById(R.id.recyclerViewgh);
        rvCart.setLayoutManager(new LinearLayoutManager(this));

        totalPriceTextView = findViewById(R.id.totalPrice_page16); // TextView để hiển thị tổng giá

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        int nguoiDungID = sharedPreferences.getInt("idNguoiDung", -1);  // Lấy nguoiDungID, nếu không có sẽ trả về -1

        // Gọi API để lấy dữ liệu giỏ hàng
        getCartItems(nguoiDungID);
        findViewById(R.id.btn_remove).setOnClickListener(v -> {
            List<CartItem> selectedItems = cartAdapter.getSelectedItems();
            if (selectedItems.isEmpty()) {
                Toast.makeText(this, "Chưa chọn sản phẩm nào", Toast.LENGTH_SHORT).show();
            } else {
                deleteSelectedItems(nguoiDungID, selectedItems);
            }
        });
    }
    private void deleteSelectedItems(int nguoiDungID, List<CartItem> selectedItems) {
        List<Integer> sanphamIds = new ArrayList<>();
        for (CartItem item : selectedItems) {
            sanphamIds.add(item.getSanPhamID());
        }
        // Chuyển danh sách items thành JSON
        String jsonItems = new Gson().toJson(selectedItems);
        Log.d("SelectedItemsJson", jsonItems); // In ra JSON gửi đi
        ApiService apiService = RetrofitClient.getInstance("").create(ApiService.class);
        Call<Void> call = apiService.deleteSelectedItems(nguoiDungID, jsonItems);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Hiển thị Toast khi xóa thành công
                    Toast.makeText(page16_giohangcuaban.this, "Xóa sản phẩm thành công", Toast.LENGTH_SHORT).show();
                    // Cập nhật lại dữ liệu giỏ hàng
                    // Cập nhật lại dữ liệu giỏ hàng
                    getCartItems(nguoiDungID);
                } else {
                    // Log chi tiết lỗi và hiển thị lên Toast khi không thành công
                    String errorMessage = "Xóa sản phẩm thất bại. Mã lỗi: " + response.code() + ", Thông báo: " + response.message();
                    Toast.makeText(page16_giohangcuaban.this, errorMessage, Toast.LENGTH_LONG).show();
                    Log.e("API_ERROR", errorMessage);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Hiển thị lỗi kết nối lên Toast
                String errorMessage = "Lỗi kết nối: " + t.getMessage();
                Toast.makeText(page16_giohangcuaban.this, errorMessage, Toast.LENGTH_LONG).show();
                Log.e("API_ERROR", errorMessage, t);
            }
        });
    }
    private void getCartItems(int nguoiDungID) {
        ApiService apiService = RetrofitClient.getInstance("").create(ApiService.class);
        Call<ResponseCart> call = apiService.getCartItems(nguoiDungID);
        call.enqueue(new Callback<ResponseCart>() {
            @Override
            public void onResponse(Call<ResponseCart> call, Response<ResponseCart> response) {
                if (response.isSuccessful() && response.body() != null) {
                    cartItems = response.body().getProducts(); // Lấy danh sách sản phẩm

                    if (cartAdapter == null) {
                        // Nếu chưa khởi tạo adapter, khởi tạo và gán cho RecyclerView
                        cartAdapter = new CartAdapter(page16_giohangcuaban.this, cartItems, page16_giohangcuaban.this);
                        rvCart.setAdapter(cartAdapter);
                    } else {
                        // Nếu adapter đã khởi tạo, chỉ cần cập nhật lại dữ liệu
                        cartAdapter.setCartItems(cartItems);
                        cartAdapter.notifyDataSetChanged(); // Cập nhật RecyclerView
                    }

                    // Tính toán tổng giá sau khi dữ liệu giỏ hàng được load
                    updateTotalPrice();
                } else {
                    Log.e("API_ERROR", "Dữ liệu trả về không hợp lệ");
                }
            }

            @Override
            public void onFailure(Call<ResponseCart> call, Throwable t) {
                Toast.makeText(page16_giohangcuaban.this, "Kết nối lỗi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("API_ERROR", "Kết nối lỗi: ", t);
            }
        });
    }

    // Phương thức này sẽ được gọi khi checkbox thay đổi
    @Override
    public void onItemChecked() {
        // Cập nhật tổng giá tiền mỗi khi checkbox thay đổi
        updateTotalPrice();
    }

    @Override
    public void onProductChecked(int productId, boolean isChecked) {
        if (isChecked) {
            // Thêm ID sản phẩm vào danh sách nếu được chọn
            selectedProductIds.add(productId);
        } else {
            // Xóa ID sản phẩm khỏi danh sách nếu bỏ chọn
            selectedProductIds.remove(Integer.valueOf(productId));
        }

        // In danh sách sản phẩm đã chọn ra logcat để kiểm tra
        Log.d("SelectedProducts", "Danh sách sản phẩm được chọn: " + selectedProductIds);
    }
    private void updateTotalPrice() {
        double totalPrice = 0.0;

        // Duyệt qua tất cả các sản phẩm trong giỏ hàng và tính tổng giá của những sản phẩm đã được chọn
        for (CartItem item : cartItems) {
            if (item.isSelected()) {
                totalPrice += item.getGia() * item.getSoLuong();
            }
        }

        // Cập nhật tổng giá tiền vào TextView
        totalPriceTextView.setText(String.format("%,d VND", (int) totalPrice));
    }
}
