package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.R;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.DonHangAdmin;

import java.util.List;

public class DonHangAdapterAdmin extends RecyclerView.Adapter<DonHangAdapterAdmin.ViewHolder> {

    private List<DonHangAdmin> donHangList;
    private OnDonHangClickListener onDonHangClickListener;

    public interface OnDonHangClickListener {
        void onDonHangClick(DonHangAdmin donHangAdmin);
    }

    public DonHangAdapterAdmin(List<DonHangAdmin> donHangList, OnDonHangClickListener onDonHangClickListener) {
        this.donHangList = donHangList;
        this.onDonHangClickListener = onDonHangClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_donhang_admin, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DonHangAdmin donHang = donHangList.get(position);
        holder.textViewId.setText(String.valueOf(donHang.getDonHangID()));
        holder.textViewTrangThai.setText(donHang.getTrangThai());

        holder.itemView.setOnClickListener(v -> onDonHangClickListener.onDonHangClick(donHang));
    }

    @Override
    public int getItemCount() {
        return donHangList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId;
        TextView textViewTrangThai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewDonHangID);
            textViewTrangThai = itemView.findViewById(R.id.textViewTrangThai);
        }
    }
}
