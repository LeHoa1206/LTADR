package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.Loaispadapter;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.SanPhamAdapters;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.ApiResponse;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.SanPham;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.ApiService;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.RetrofitClient;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.Loaispadapter;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class timkiem extends AppCompatActivity {
    // Khai báo các biến ở cấp độ lớp
    private RecyclerView recyclerView;
    private Loaispadapter adapter;
    private Disposable disposable;
    private List<SanPham> sanPhamDeXuatList = new ArrayList<>();

    TextView xemtatca;
    LinearLayout timkiemsanpham;
    private RecyclerView recyclerViewSPBC,recyclerViewSPNB,recyclerViewSPDX; // danh cho san pham ban chay
    private SanPhamAdapters sanPhamBC_Adapters, sanPhamNB_Adapter,sanPhamDX_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timkiem);

        // Ánh xạ các thành phần giao diện
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));        EditText searchBar = findViewById(R.id.search_bar);
        ImageView backButton = findViewById(R.id.back_button);

// Thiết lập adapter cho RecyclerView (giả sử bạn đã có adapter)
        recyclerView.setAdapter(adapter);
        // Sự kiện khi nhấn nút quay lại
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kết thúc Activity khi nhấn nút quay lại
                finish();
            }
        });
        // Sự kiện khi nhấn nút tìm kiếm
        findViewById(R.id.search_button).setOnClickListener(v -> {
            String query = searchBar.getText().toString().trim();
            if (!TextUtils.isEmpty(query)) {
                fetchProducts(query);  // Gọi API tìm kiếm sản phẩm
            } else {
                Toast.makeText(this, "Vui lòng nhập từ khóa tìm kiếm", Toast.LENGTH_SHORT).show();
            }
        });
        getSanPhamDeXuat();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        sanPhamDX_Adapter = new SanPhamAdapters(this, sanPhamDeXuatList);
        recyclerView.setAdapter(sanPhamDX_Adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Sự kiện khi nhấn nút quay lại
        backButton.setOnClickListener(v -> finish());
        // Gọi API
    }
    private void getSanPhamDeXuat() {
        ApiService apiService = RetrofitClient.getInstance("").create(ApiService.class);
        Call<List<SanPham>> call = apiService.getAllSPDeXuat();  // Lấy dữ liệu ApiResponse
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<SanPham> sanPhams = response.body();
                    sanPhamDeXuatList.clear();
                    sanPhamDeXuatList.addAll(sanPhams); // Thêm dữ liệu mới
                    sanPhamDX_Adapter.notifyDataSetChanged(); // Cập nhật adapter
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

    private void fetchProducts(String query) {
        String baseUrl = "http://192.168.56.1/WebbanhangLH/";  // Thay URL này bằng URL API của bạn
        ApiService apiService = RetrofitClient.getInstance(baseUrl).create(ApiService.class);

        Observable<ApiResponse> sanPhamObservable = apiService.searchSanPham(query);  // Tìm sản phẩm theo từ khóa

        disposable = sanPhamObservable
                .subscribeOn(Schedulers.io())  // Thực thi trên thread nền
                .observeOn(AndroidSchedulers.mainThread())  // Nhận kết quả trên main thread
                .subscribe(
                        apiResponse -> {
                            if (apiResponse != null && apiResponse.isSuccess()) {
                                List<SanPham> sanPhamList = apiResponse.getResult();
                                if (sanPhamList != null && !sanPhamList.isEmpty()) {
                                    // Cập nhật adapter với dữ liệu tìm thấy
                                    adapter = new Loaispadapter(sanPhamList);
                                    recyclerView.setAdapter(adapter);
                                } else {
                                    Toast.makeText(this, "Không tìm thấy sản phẩm", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(this, "Không tìm thấy sản phẩm", Toast.LENGTH_SHORT).show();
                            }
                        },
                        throwable -> {
                            // Xử lý lỗi khi gọi API
                            Toast.makeText(this, "Không tìm thấy sản phẩm", Toast.LENGTH_SHORT).show();
                        }
                );
    }

//    private void fetchDataFromApi() {
//        String baseUrl = "http://192.168.56.1/WebbanhangLH/";  // Thay bằng URL API của bạn
//        ApiService apiService = RetrofitClient.getInstance(baseUrl).create(ApiService.class);
//
//        Observable<ApiResponse> sanPhamObservable = apiService.getSanPhamList();  // Lấy dữ liệu ApiResponse
//
//        disposable = sanPhamObservable
//                .subscribeOn(Schedulers.io())  // Thực thi API trên thread nền
//                .observeOn(AndroidSchedulers.mainThread())  // Nhận kết quả trên main thread
//                .subscribe(
//                        apiResponse -> {
//                            if (apiResponse != null && apiResponse.isSuccess()) {
//                                List<SanPham> sanPhamList = apiResponse.getResult();  // Lấy danh sách sản phẩm
//                                if (sanPhamList != null && !sanPhamList.isEmpty()) {
//                                    // Nếu danh sách sản phẩm có dữ liệu, set adapter
//                                    adapter = new Loaispadapter(sanPhamList);
//                                    recyclerView.setAdapter(adapter);
//                                } else {
//                                    // Nếu không có sản phẩm, thông báo cho người dùng
//                                    Toast.makeText(this, "Không có sản phẩm", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                // Nếu API trả về thất bại, thông báo lỗi
//                                Toast.makeText(this, "Lỗi tải dữ liệu", Toast.LENGTH_SHORT).show();
//                            }
//                        },
//                        throwable -> {
//                            // Xử lý khi có lỗi kết nối API
//                            Log.e("TIMKIEM", "Lỗi kết nối API: " + throwable.getMessage(), throwable);
//                            Toast.makeText(this, "Lỗi kết nối API", Toast.LENGTH_SHORT).show();
//                        }
//                );
//    }

    // Hàm giả lập tìm kiếm sản phẩm theo từ khóa
    private void searchForProducts(String query) {
        // Hiển thị thông báo tìm kiếm (có thể thay bằng logic tìm kiếm thật)
        Toast.makeText(this, "Tìm kiếm: " + query, Toast.LENGTH_SHORT).show();

        // Thực hiện các bước xử lý kết quả tìm kiếm ở đây, như gọi API hoặc lọc danh sách sản phẩm
    }
}
