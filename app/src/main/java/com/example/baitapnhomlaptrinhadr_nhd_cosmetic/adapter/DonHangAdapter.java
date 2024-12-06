package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHang;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.R;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page21_chitietdonhang1;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page22_chitietdonhang2;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page23_chitietdonhang3;

import java.util.List;

public class DonHangAdapter extends RecyclerView.Adapter<DonHangAdapter.ViewHolder> {

    private List<DonHang> donHangList;

    public DonHangAdapter(List<DonHang> donHangList) {
        this.donHangList = donHangList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_donhang, parent, false); // Tạo file XML `item_donhang`
        return new ViewHolder(view);
    }
    public void updateData(List<DonHang> newDonHangList) {
        this.donHangList.clear();
        this.donHangList.addAll(newDonHangList);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DonHang donHang = donHangList.get(position);
        holder.txtSTT.setText("Đơn Hàng#" + (position + 1));
        holder.txtDonHangID.setText(donHang.getDonHangID() != null ?  donHang.getDonHangID() : "ID Đơn Hàng: N/A");
        holder.txtTrangThai.setText(donHang.getTrangThai() != null ?  donHang.getTrangThai() : "N/A");
        holder.txtSoLuong.setText(donHang.getSoLuong() != null ? "Số lượng: " + String.valueOf(donHang.getSoLuong()) : "0");
        holder.txtGia.setText(donHang.getGia() != null ? "Giá: " + String.valueOf(donHang.getGia()) : "0.0");

        holder.btnChiTiet.setOnClickListener(v -> {
            String trangThai = donHang.getTrangThai();
            Intent intent;
            if ("đang xử lý".equalsIgnoreCase(trangThai)) {
                intent = new Intent(holder.itemView.getContext(), page22_chitietdonhang2.class);
            } else if ("đã giao".equalsIgnoreCase(trangThai)) {
                intent = new Intent(holder.itemView.getContext(), page21_chitietdonhang1.class);
            } else if ("đã hủy".equalsIgnoreCase(trangThai)) {
                intent = new Intent(holder.itemView.getContext(), page23_chitietdonhang3.class);
            }
            else {
                // Điều kiện mặc định nếu trạng thái không khớp
                intent = new Intent(holder.itemView.getContext(), page21_chitietdonhang1.class);
            }
            intent.putExtra("MaDonHang", donHang.getDonHangID());
            intent.putExtra("SoLuong", donHang.getSoLuong());
            intent.putExtra("Gia", donHang.getGia());
            intent.putExtra("TrangThai", donHang.getTrangThai());
            holder.itemView.getContext().startActivity(intent);
        });
    }



    @Override
    public int getItemCount() {
        return donHangList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDonHangID, txtTrangThai, txtSoLuong, txtGia , txtSTT;
        Button btnChiTiet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSTT = itemView.findViewById(R.id.txtSTT);
            txtDonHangID = itemView.findViewById(R.id.txtIDDonHang);
            txtTrangThai = itemView.findViewById(R.id.txtTrangThaiDH);
            txtSoLuong = itemView.findViewById(R.id.txtSoLuongDH);
            txtGia = itemView.findViewById(R.id.txtGiaDH);
            btnChiTiet = itemView.findViewById(R.id.btnchitiet);
        }
    }
}

