package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.R;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.chitietsanpham;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamAdapters extends RecyclerView.Adapter<SanPhamAdapters.itemSanPham>{
    private Context context;
    private List<SanPham> sanPhamList = new ArrayList<>();
    public static AdapterView.OnItemClickListener onItemClickListener;
    public SanPhamAdapters(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    @NonNull
    @Override
    public itemSanPham onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_sanpham, parent, false);
        return new itemSanPham(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull itemSanPham holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        holder.tenSanPham.setText(sanPham.getTenSanPham());
        holder.giaCa.setText(String.valueOf(sanPham.getGia() + "VND"));
        // Trong onBindViewHolder
//        holder.;
        holder.id = Integer.parseInt(sanPham.getSanPhamID());
        Glide.with(holder.itemView.getContext())
                .load(sanPham.getHinhAnh()) // URL hoặc đường dẫn ảnh
//                .placeholder(R.drawable.placeholder_image) // Ảnh chờ
//                .error(R.drawable.error_image) // Ảnh lỗi
                .into(holder.hinhanh);
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

    public  class itemSanPham extends RecyclerView.ViewHolder {
        TextView tenSanPham, giaCa;
        ImageView hinhanh;
        int id;
        public itemSanPham(@NonNull View itemView) {
            super(itemView);
            tenSanPham =itemView.findViewById(R.id.tenSanPham);
            giaCa = itemView.findViewById(R.id.giaSanPham);
            hinhanh = itemView.findViewById(R.id.hinhAnhSanPham);
            itemView.setOnClickListener(view -> {
                int ids = id;
//                    onItemClickListener.onItemClick(id); // Truyền id khi click
                    Intent intent = new Intent(context, chitietsanpham.class); // Chuyển qua class Sanphamchitiet
                    intent.putExtra("id", ids); // Gửi id qua Intent
                    context.startActivity(intent);
            });
        }
    }
}
