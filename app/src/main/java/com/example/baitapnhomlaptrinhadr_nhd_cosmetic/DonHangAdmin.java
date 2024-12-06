package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.ApiReponseDH;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.ApiService;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter.DonHangAdapterAdmin;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonHangAdmin extends AppCompatActivity implements DonHangAdapterAdmin.OnDonHangClickListener {

    private static final String TAG = "DonHangAdmin";
    private RecyclerView recyclerView;
    private DonHangAdapterAdmin donHangAdapterAdmin;
    private Button btnRefresh;
    private List<com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin> donHangAdminList;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminxemdonhang);

        recyclerView = findViewById(R.id.recyclerView);
        btnRefresh = findViewById(R.id.btnRefresh);

        donHangAdminList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        donHangAdapterAdmin = new DonHangAdapterAdmin(donHangAdminList, this);
        recyclerView.setAdapter(donHangAdapterAdmin);

        fetchDataFromApi();

        btnRefresh.setOnClickListener(v -> fetchDataFromApi());
    }

    private void showAddEditDialog(com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin donHangAdmin) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(donHangAdmin == null ? "Thêm Đơn Hàng" : "Sửa Đơn Hàng");

        // Tạo view của dialog
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_order, null);
        builder.setView(dialogView);

        // Khởi tạo EditText và Spinner
        EditText editTextId = dialogView.findViewById(R.id.editTextId);
        Spinner spinnerTrangThai = dialogView.findViewById(R.id.spinnerTrangThai);

        // Khởi tạo adapter cho Spinner (Trạng thái đơn hàng)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.trangThai_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTrangThai.setAdapter(adapter);

        // Nếu là sửa đơn hàng, điền thông tin vào các trường
        if (donHangAdmin != null) {
            editTextId.setText(String.valueOf(donHangAdmin.getDonHangID()));
            int position = adapter.getPosition(donHangAdmin.getTrangThai());
            spinnerTrangThai.setSelection(position);
        }

        builder.setPositiveButton(donHangAdmin == null ? "Thêm" : "Sửa", (dialog, which) -> {
            String idString = editTextId.getText().toString();
            String trangThai = spinnerTrangThai.getSelectedItem().toString();

            if (idString.isEmpty() || trangThai.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin.", Toast.LENGTH_SHORT).show();
                return;
            }

            int donHangID;
            try {
                donHangID = Integer.parseInt(idString);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "ID không hợp lệ. Vui lòng nhập lại.", Toast.LENGTH_SHORT).show();
                return;
            }

            Integer nguoiDungID = donHangAdmin != null ? donHangAdmin.getNguoiDungID() : null;

            if (donHangAdmin == null) {
                // Thêm đơn hàng mới
                com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin newDonHangAdmin = new com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin();
                newDonHangAdmin.setDonHangID(donHangID);
                newDonHangAdmin.setTrangThai(trangThai);
                newDonHangAdmin.setNguoiDungID(nguoiDungID);
                addDonHangToServer(newDonHangAdmin);
            } else {
                // Sửa đơn hàng hiện tại
                donHangAdmin.setDonHangID(donHangID);
                donHangAdmin.setTrangThai(trangThai);
                donHangAdmin.setNguoiDungID(nguoiDungID);
                updateDonHangOnServer(donHangAdmin);
            }
        });

        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());
        builder.show();
    }


    private void fetchDataFromApi() {
        String baseUrl = "http://192.168.56.1/WebbanhangLH/";
        ApiService apiService = RetrofitClient.getInstance(baseUrl).create(ApiService.class);

        Observable<ApiReponseDH> donHangObservable = apiService.getdanhsachdonhangadmin();

        disposable = donHangObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        apiResponse -> {
                            if (apiResponse != null && apiResponse.isSuccess()) {
                                List<com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin> donHangAdminListFromApi = apiResponse.getResult();
                                if (donHangAdminListFromApi != null && !donHangAdminListFromApi.isEmpty()) {
                                    donHangAdminList.clear();
                                    donHangAdminList.addAll(donHangAdminListFromApi);
                                    donHangAdapterAdmin.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(this, "Không có đơn hàng nào.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(this, "Lỗi: " + (apiResponse != null ? apiResponse.getMessage() : "Không xác định"), Toast.LENGTH_SHORT).show();
                            }
                        },
                        throwable -> {
                            Log.e(TAG, "Lỗi kết nối API: " + throwable.getMessage(), throwable);
                            Toast.makeText(this, "Không thể kết nối tới máy chủ.", Toast.LENGTH_SHORT).show();
                        }
                );
    }

    private void addDonHangToServer(com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin donHangAdmin) {
        String baseUrl = "http://192.168.56.1/WebbanhangLH/";
        ApiService apiService = RetrofitClient.getInstance(baseUrl).create(ApiService.class);

        Observable<ApiReponseDH> addObservable = apiService.addDonHang(donHangAdmin);
        disposable = addObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        apiResponse -> {
                            if (apiResponse != null && apiResponse.isSuccess()) {
                                donHangAdminList.add(donHangAdmin);
                                donHangAdapterAdmin.notifyDataSetChanged();
                                Toast.makeText(this, "Thêm đơn hàng thành công!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "Lỗi: " + (apiResponse != null ? apiResponse.getMessage() : "Không xác định"), Toast.LENGTH_SHORT).show();
                            }
                        },
                        throwable -> {
                            Log.e(TAG, "Lỗi khi thêm đơn hàng: " + throwable.getMessage(), throwable);
                            Toast.makeText(this, "Không thể kết nối tới máy chủ.", Toast.LENGTH_SHORT).show();
                        }
                );
    }

    private void updateDonHangOnServer(com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin donHangAdmin) {
        String baseUrl = "http://192.168.56.1/WebbanhangLH/";
        ApiService apiService = RetrofitClient.getInstance(baseUrl).create(ApiService.class);

        Call<ApiReponseDH> call = apiService.updateDonHang(donHangAdmin);

        call.enqueue(new Callback<ApiReponseDH>() {
            @Override
            public void onResponse(Call<ApiReponseDH> call, Response<ApiReponseDH> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    fetchDataFromApi();  // Refresh data
                    Toast.makeText(DonHangAdmin.this, "Cập nhật đơn hàng thành công!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DonHangAdmin.this, "Cập nhật thất bại!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiReponseDH> call, Throwable t) {
                Toast.makeText(DonHangAdmin.this, "Lỗi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void onDonHangClick(com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin donHangAdmin) {
        showAddEditDialog(donHangAdmin);
    }
}
