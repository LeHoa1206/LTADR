package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page20_donhangcuatoipk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.NguoiDung;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.R;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page22_chitietdonhang2;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.ApiService;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.RetrofitClient;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHang;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.DonHangAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DagiaoFragment extends Fragment {

    private RecyclerView recyclerView;
    private DonHangAdapter orderAdapter;

    public DagiaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choxuly, container, false);

        recyclerView = view.findViewById(R.id.donhangrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        orderAdapter = new DonHangAdapter(new ArrayList<DonHang>());

        recyclerView.setAdapter(orderAdapter);

        fetchOrders();

        return view;
    }

    private void fetchOrders() {
        // Lấy ID người dùng từ SharedPreferences
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("UserPrefs", requireContext().MODE_PRIVATE);
        int idNguoiDung = sharedPreferences.getInt("idNguoiDung", -1); // -1 là giá trị mặc định nếu không tìm thấy

        if (idNguoiDung == -1) {
            // Nếu không có ID người dùng, hiển thị thông báo lỗi và dừng lại
            Toast.makeText(getContext(), "Không tìm thấy ID người dùng", Toast.LENGTH_SHORT).show();
            return;
        }

        // Gọi API để lấy dữ liệu đơn hàng với idNguoiDung đã lấy từ SharedPreferences
        Call<List<DonHang>> call = RetrofitClient.getInstance("").create(ApiService.class).getOrders(idNguoiDung);

        // Xử lý phản hồi API
        call.enqueue(new Callback<List<DonHang>>() {

            @Override
            public void onResponse(Call<List<DonHang>> call, Response<List<DonHang>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Lấy danh sách đơn hàng từ phản hồi
                    List<DonHang> donHangList = response.body();

                    // Lọc danh sách để chỉ lấy đơn hàng có trạng thái "đang xử lý"
                    List<DonHang> filteredList = new ArrayList<>();
                    for (DonHang donHang : donHangList) {
                        if ("đã giao".equalsIgnoreCase(donHang.getTrangThai())) { // Kiểm tra trạng thái
                            filteredList.add(donHang);
                        }
                    }

                    if (filteredList.isEmpty()) {
                        // Hiển thị thông báo nếu không có dữ liệu phù hợp
                        Toast.makeText(requireContext(), "Không có đơn hàng", Toast.LENGTH_SHORT).show();
                    } else {
                        // Cập nhật adapter với danh sách đã lọc
                        orderAdapter = new DonHangAdapter(filteredList);
                        recyclerView.setAdapter(orderAdapter);
                    }
                } else {
                    Toast.makeText(getContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<DonHang>> call, Throwable t) {
                // In ra chi tiết lỗi vào Logcat
                Log.e("API Error", "Error: " + t.getMessage());

                // Hiển thị thông báo lỗi lên Toast
                Snackbar.make(recyclerView.findViewById(android.R.id.content), "Failed to load data. Error: " + t.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}

