package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.DanhGiaAdapter;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.SanPhamAdapters;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.AddToCartRequest;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DanhGia;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.SanPham;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.respone.BinhLuanRespone;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.respone.DanhGiaResponse;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.ApiService;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class chitietsanpham extends AppCompatActivity {
    private RecyclerView recyclerViewSP, recyclerViewBinhLuan;
    private Button addToCartButton;
    private List<BinhLuanRespone> binhLuanResponeList = new ArrayList<>();
    private SanPham sanPham;
    public TextView tenSanPham, moTa, danhGia, diemDanhGia, giaSanPham, phanTramDanhGia;
    private ImageView hinhAnh;
    public Integer id;
    public Double diem;
    private ProgressBar progressBar;
    private RecyclerView recyclerViewBL;
    private DanhGiaAdapter danhGiaAdapter;
    private SanPhamAdapters sanPhamAdapters;
    private List<SanPham> sanPhamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietsanpham);

        // Lấy id của sản phẩm
        int productId = getIntent().getIntExtra("id", -1);
        id = productId;

        // Khởi tạo các thành phần UI
        addToCartButton = findViewById(R.id.add_to_cart_button);
        tenSanPham = findViewById(R.id.tenSanPhamCT);
        moTa = findViewById(R.id.MoTaCT);
        danhGia = findViewById(R.id.diemDanhGiaCT);
        giaSanPham = findViewById(R.id.giaSanPhamCT);
        hinhAnh = findViewById(R.id.hinhAnhSanPhamCT);
        diemDanhGia = findViewById(R.id.diemDanhGiaCT);
        phanTramDanhGia = findViewById(R.id.phanTramDanhGia);

        // Lấy thông tin sản phẩm, đánh giá, và sản phẩm tương tự
        getSanPhamById();
        getDiemDanhGia();
        getAllDanhGiaById();
        getSanPhamTuongTu();

        // Khởi tạo RecyclerView
        recyclerViewBL = findViewById(R.id.recyclerViewBinhLuans);
        recyclerViewBL.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        danhGiaAdapter = new DanhGiaAdapter(this, binhLuanResponeList);
        recyclerViewBL.setAdapter(danhGiaAdapter);

        recyclerViewSP = findViewById(R.id.recyclerViewSPTT);
        recyclerViewSP.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        sanPhamAdapters = new SanPhamAdapters(this, sanPhamList);
        recyclerViewSP.setAdapter(sanPhamAdapters);

        // Lắng nghe sự kiện nhấn nút "Thêm vào giỏ hàng"
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy ID người dùng từ SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                int nguoiDungID = sharedPreferences.getInt("idNguoiDung", -1); // Lấy ID người dùng, mặc định là -1 nếu không tìm thấy

                if (nguoiDungID != -1) {
                    // Gửi yêu cầu đến API thêm sản phẩm vào giỏ hàng
                    ApiService apiService = RetrofitClient.getInstance("").create(ApiService.class);
                    AddToCartRequest request = new AddToCartRequest(nguoiDungID, id, 1);
                    Call<Void> call = apiService.addToCart(request);
                    // Số lượng mặc định là 1
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(chitietsanpham.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(chitietsanpham.this, "Thêm thất bại: " + response.message(), Toast.LENGTH_SHORT).show();
                                Log.e("AddToCart", "Lỗi: " + response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(chitietsanpham.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            Log.e("AddToCart", "Lỗi kết nối API: " + t.getMessage());
                        }
                    });

                } else {
                    Log.e("AddToCart", "Không tìm thấy ID người dùng trong SharedPreferences.");
                }
            }
        });
    }

    private void getAllDanhGiaById() {
        ApiService apiService = RetrofitClient.getInstance("").create(ApiService.class);
        Call<List<BinhLuanRespone>> call = apiService.getAllBinhLuanById(id);
        call.enqueue(new Callback<List<BinhLuanRespone>>() {
            @Override
            public void onResponse(Call<List<BinhLuanRespone>> call, Response<List<BinhLuanRespone>> response) {
                if (response.isSuccessful()) {
                    List<BinhLuanRespone> binhLuanRespones = response.body();
                    binhLuanResponeList.addAll(binhLuanRespones);
                    danhGiaAdapter.notifyDataSetChanged();
                } else {
                    System.out.println("Lỗi: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<BinhLuanRespone>> call, Throwable t) {
                System.out.println("Gọi API thất bại: " + t.getMessage());
            }
        });
    }

    private void getSanPhamTuongTu() {
        ApiService apiService = RetrofitClient.getInstance("").create(ApiService.class);
        Call<List<SanPham>> call = apiService.getAllSPDeXuat();  // Lấy dữ liệu ApiResponse
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<SanPham> sanPhams = response.body();
                    sanPhamList.clear();
                    sanPhamList.addAll(sanPhams); // Thêm dữ liệu mới
                    sanPhamAdapters.notifyDataSetChanged(); // Cập nhật adapter
                    Log.d("SanPhamDeXuat", "Dữ liệu đã nhận: " + sanPhams.size() + " sản phẩm");
                } else {
                    Log.e("API_RESPONSE_ERROR", "Response thất bại: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Log.e("API_CALL_FAILURE", "Không thể kết nối tới server: " + t.getMessage());
            }
        });
    }

    // Hàm làm tròn ví dụ 3.666667 => 3.67
    public static double roundToTwoDecimalPlaces(double number) {
        // Làm tròn tới 2 chữ số thập phân
        return Math.round(number * 100.0) / 100.0;
    }

    private void getDiemDanhGia() {
        ApiService apiService = RetrofitClient.getInstance("").create(ApiService.class);
        Call<DanhGiaResponse> call = apiService.getDanhGiaById(id);
        call.enqueue(new Callback<DanhGiaResponse>() {
            @Override
            public void onResponse(Call<DanhGiaResponse> call, Response<DanhGiaResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DanhGiaResponse danhGia = response.body();
                    diemDanhGia.setText(String.valueOf(roundToTwoDecimalPlaces(danhGia.getAverageRating()) + "/5"));
                    phanTramDanhGia.setText(danhGia.getAverageRating() * 100 / 5 + "%");
                } else {
                    System.out.println("Lỗi: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<DanhGiaResponse> call, Throwable t) {
                System.out.println("Gọi API thất bại: " + t.getMessage());
            }
        });
    }

    private void getSanPhamById() {
        ApiService apiService = RetrofitClient.getInstance("").create(ApiService.class);
        Call<SanPham> call = apiService.getSanPhamById(id);
        call.enqueue(new Callback<SanPham>() {
            @Override
            public void onResponse(Call<SanPham> call, Response<SanPham> response) {
                if (response.isSuccessful() && response.body() != null) {
                    sanPham = response.body();
                    tenSanPham.setText(sanPham.getTenSanPham());
                    moTa.setText(sanPham.getMoTa());
                    giaSanPham.setText(sanPham.getGia() + " VND");
                    Glide.with(chitietsanpham.this)
                            .load(sanPham.getHinhAnh())
                            .into(hinhAnh);
                } else {
                    System.out.println("Lỗi: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<SanPham> call, Throwable t) {
                System.out.println("Gọi API thất bại: " + t.getMessage());
            }
        });
    }
}
