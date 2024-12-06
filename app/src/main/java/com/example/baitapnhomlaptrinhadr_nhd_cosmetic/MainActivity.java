package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.Loaispadapter;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.SanPhamAdapters;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.SanPham;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.ApiService;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.RetrofitClient;
import com.google.android.material.navigation.NavigationView;

import io.reactivex.rxjava3.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView btnhomeButton,btnhoso,img_menu,tichdiem;
    LinearLayout sanphambieutuong;

    DrawerLayout drawerLayout; // Khai báo DrawerLayout
    NavigationView navigationView; // Khai báo NavigationView
    ImageView nam,nu,phukien,lamdep,timkiem,giohang,canhan;
    private RecyclerView recyclerView;
    private Loaispadapter adapter;
    private Disposable disposable;


    //=======================Phan xuan lam===============================
    private RecyclerView recyclerViewSPBC,recyclerViewSPNB,recyclerViewSPDX; // danh cho san pham ban chay
    private SanPhamAdapters sanPhamBC_Adapters, sanPhamNB_Adapter,sanPhamDX_Adapter;
    private List<SanPham> sanPhamBanChayList = new ArrayList<>(); // san pham ban chay
    private List<SanPham> sanPhamNoiBacList = new ArrayList<>(); // san pham ban chay
    private List<SanPham> sanPhamDeXuatList = new ArrayList<>();
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_10_trangchu);
        btnhomeButton=findViewById(R.id.imgmenu);
        timkiem=findViewById(R.id.btntimkiem);
//        sanphambieutuong=findViewById(R.id.sanphambieutuong);
        nam=findViewById(R.id.pagenam);
        nu=findViewById(R.id.pagenu);
        phukien=findViewById(R.id.pagephukien);
        lamdep=findViewById(R.id.pagelamdep);
        giohang=findViewById(R.id.btngiohang);
        canhan=findViewById(R.id.btncanhan);
        tichdiem=findViewById(R.id.tichdiem);
        nam.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, page9_Trangchu_Nam.class);
            startActivity(intent);
        });
        nu.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, page8_Trangchu_Nu.class);
            startActivity(intent);
        });
        phukien.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, page11_Trangchu.class);
            startActivity(intent);
        });
        lamdep.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, page12_Trangchu.class);
            startActivity(intent);
        });
        giohang.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, page16_giohangcuaban.class);
            startActivity(intent);
        });
        canhan.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, page20_donhangcuatoi.class);
            startActivity(intent);
        });

        tichdiem.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, tichdiem.class);
            startActivity(intent);
        });
        //================= day la phan hien thi cho san pham ban chay========================//
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
        //============================================================//

        //====================== day la san pham noi bat============================//
        getSanPhamDeXuat();
        recyclerViewSPDX = findViewById(R.id.recyclerViewSPDX);
        recyclerViewSPDX.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        sanPhamDX_Adapter = new SanPhamAdapters(this, sanPhamDeXuatList);
        recyclerViewSPDX.setAdapter(sanPhamDX_Adapter);
        //============================================================//



        btnhomeButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, menu.class);
            startActivity(intent);
        });
        // Gọi API và xử lý kết quả
    }

    //call API lay danh sach noi bac
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


    //call API lay danh sach noi bac
    private void getSanPhamNoiBac() {
        ApiService apiService = RetrofitClient.getInstance("").create(ApiService.class);
        Call<List<SanPham>> call = apiService.getAllSPNoiBac();  // Lấy dữ liệu ApiResponse
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
        Call<List<SanPham>> call = apiService.getAllSPBanChay();  // Lấy dữ liệu ApiResponse
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




    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
