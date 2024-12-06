package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.R;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.respone.BinhLuanRespone;

import java.util.ArrayList;
import java.util.List;

public class DanhGiaAdapter extends RecyclerView.Adapter<DanhGiaAdapter.itemDanhGia> {
    private Context context;
    private List<BinhLuanRespone> binhLuan = new ArrayList<>();

    public DanhGiaAdapter(Context context, List<BinhLuanRespone> danhGiaList) {
        this.context = context;
        this.binhLuan = danhGiaList;
    }

    @NonNull
    @Override
    public itemDanhGia onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_danhgia, parent, false);
        return new itemDanhGia(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull itemDanhGia holder, int position) {
        BinhLuanRespone binhLuanRespone = binhLuan.get(position);

        // Gán dữ liệu vào các TextView
        holder.tenNguoiDung.setText(binhLuanRespone.getTenNguoiDung()); // Tên người dùng
        holder.noiDung.setText(binhLuanRespone.getNoiDung()); // Nội dung đánh giá
        holder.ngayDanhGia.setText(String.valueOf(binhLuanRespone.getNgayDanhGia()));
    }

    @Override
    public int getItemCount() {
        return binhLuan.size(); // Trả về số lượng phần tử trong danh sách
    }

    public static class itemDanhGia extends RecyclerView.ViewHolder {
        TextView tenNguoiDung, noiDung,ngayDanhGia;

        public itemDanhGia(@NonNull View itemView) {
            super(itemView);
            // Khởi tạo các TextView từ layout
            tenNguoiDung = itemView.findViewById(R.id.tenNguoiDung);
            noiDung = itemView.findViewById(R.id.noiDung);
            ngayDanhGia = itemView.findViewById(R.id.ngayDanhGia);
        }
    }
}
