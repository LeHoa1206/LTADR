package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.SanPhamAdapters;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.SanPham;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.ApiService;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.RetrofitClient;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class page12_Trangchu extends AppCompatActivity {
    private RecyclerView recyclerViewSPBC,recyclerViewSPNB,recyclerViewSPDX; // danh cho san pham ban chay
    private SanPhamAdapters sanPhamBC_Adapters, sanPhamNB_Adapter,sanPhamDX_Adapter;
    private List<SanPham> sanPhamBanChayList = new ArrayList<>(); // san pham ban chay
    private List<SanPham> sanPhamNoiBacList = new ArrayList<>(); // san pham ban chay
    private List<SanPham> sanPhamDeXuatList = new ArrayList<>();
    ImageView btnhomeButton,btnhoso,img_menu;
    DrawerLayout drawerLayout; // Khai báo DrawerLayout
    NavigationView navigationView; // Khai báo NavigationView
    ImageView nam,nu,phukien,lamdep,timkiem,giohang,canhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page12_cosmetic_lamdep); // Đảm bảo layout này tồn tại
        btnhomeButton=findViewById(R.id.imgmenu);
        nam=findViewById(R.id.pagenam);
        nu=findViewById(R.id.pagenu);
        phukien=findViewById(R.id.pagephukien);
        lamdep=findViewById(R.id.pagelamdep);
        // Khởi tạo các thành phần
        drawerLayout = findViewById(R.id.drawer_layout);
        btnhomeButton.setOnClickListener(view -> {
            Intent intent = new Intent(page12_Trangchu.this, menu.class);
            startActivity(intent);
        });
        nam.setOnClickListener(view -> {
            Intent intent = new Intent(page12_Trangchu.this, page9_Trangchu_Nam.class);
            startActivity(intent);
        });
        nu.setOnClickListener(view -> {
            Intent intent = new Intent(page12_Trangchu.this, page8_Trangchu_Nu.class);
            startActivity(intent);
        });
        phukien.setOnClickListener(view -> {
            Intent intent = new Intent(page12_Trangchu.this, page11_Trangchu.class);
            startActivity(intent);
        });
        lamdep.setOnClickListener(view -> {
            Intent intent = new Intent(page12_Trangchu.this, page12_Trangchu.class);
            startActivity(intent);
        });
        getSanPhamBanChay();
        recyclerViewSPBC = findViewById(R.id.recyclerViewSPBC);
        recyclerViewSPBC.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        sanPhamBC_Adapters = new SanPhamAdapters(this, sanPhamBanChayList);
        recyclerViewSPBC.setAdapter(sanPhamBC_Adapters);
        //===============================================================================//

        //====================== day la san pham noi bat============================//
        getSanPhamNoiBac();
        recyclerViewSPNB = findViewById(R.id.recyclerViewSPNB);
        recyclerViewSPNB.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        sanPhamNB_Adapter = new SanPhamAdapters(this, sanPhamNoiBacList);
        recyclerViewSPNB.setAdapter(sanPhamNB_Adapter);
//        btnhomeButton.setOnClickListener(view -> {
//            Intent intent = new Intent(page8_Trangchu.this, page10_Trangchu.class);
//            startActivity(intent);
//        });
//        img_menu.setOnClickListener(view -> {
//            Intent intent = new Intent(page8_Trangchu.this, menu.class);
//            startActivity(intent);
//        });
//         Thiết lập sự kiện cho nút quay lại

    }
    //call API lay danh sach noi bac
    private void getSanPhamNoiBac() {
        ApiService apiService = RetrofitClient.getInstance("").create(ApiService.class);
        Call<List<SanPham>> call = apiService.getAllSPDeXuatLamDep();  // Lấy dữ liệu ApiResponse
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<SanPham> sanPhams = response.body();
                    sanPhamNoiBacList.clear();
                    sanPhamNoiBacList.addAll(sanPhams); // Thêm dữ liệu mới
                    sanPhamNB_Adapter.notifyDataSetChanged(); // Cập nhật adapter
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

    // call API lay danh sach ban chay
    private void getSanPhamBanChay() {
        String baseUrl = "http://192.168.1.7/WebbanhangLH/";  // Thay bằng URL API của bạn
        ApiService apiService = RetrofitClient.getInstance(baseUrl).create(ApiService.class);

        // --------------------------------XOA PHAN NAY CUA TAO--------------------------------------------//
        Call<List<SanPham>> call = apiService.getAllSPDeXuatLamDep();  // Lấy dữ liệu ApiResponse
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<SanPham> sanPhams = response.body();
                    sanPhamBanChayList.clear();
                    sanPhamBanChayList.addAll(sanPhams); // Thêm dữ liệu mới
                    sanPhamBC_Adapters.notifyDataSetChanged(); // Cập nhật adapter
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



        // -----------------------------------------------------------------------------------------------------//
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
//                                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                // Nếu API trả về thất bại, thông báo lỗi
//                                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//                            }
//                        },
//                        throwable -> {
//                            // Xử lý khi có lỗi kết nối API
//                            Log.e(TAG, "Lỗi kết nối API: " + throwable.getMessage(), throwable);
//                            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//                        }
//                );
    }




}




