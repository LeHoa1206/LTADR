package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.R;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.CartItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.R;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.CartItem;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<CartItem> cartItems;
    private Context context;
    private OnItemCheckListener onItemCheckListener;

    public CartAdapter(Context context, List<CartItem> cartItems, OnItemCheckListener onItemCheckListener) {
        this.context = context;
        this.cartItems = cartItems;
        this.onItemCheckListener = onItemCheckListener;
    }

    // Setter để cập nhật danh sách sản phẩm
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
        notifyDataSetChanged(); // Cập nhật giao diện
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giohang, parent, false);
        return new CartViewHolder(view);
    }
    public List<CartItem> getSelectedItems() {
        List<CartItem> selectedItems = new ArrayList<>();
        for (CartItem item : cartItems) {
            if (item.isSelected()) {
                selectedItems.add(item);
            }
        }
        return selectedItems;
    }
    public List<Integer> getSelectedProductIds() {
        List<Integer> selectedIds = new ArrayList<>();
        for (CartItem item : cartItems) {
            if (item.isSelected()) {
                selectedIds.add(item.getSanPhamID());
            }
        }
        return selectedIds;
    }
    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        // Bind dữ liệu vào các view trong item_cart
        holder.name.setText(cartItem.getTenSanPham());
        holder.price.setText(String.valueOf(cartItem.getGia()));
        holder.quantity.setText("Số lượng: " + cartItem.getSoLuong());
        Glide.with(holder.itemView.getContext())
                .load(cartItem.getHinhAnh())  // Đường dẫn URL của ảnh
                .into(holder.imageView);
        holder.checkBox.setChecked(cartItem.isSelected());

        // Gắn sự kiện thay đổi trạng thái checkbox
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            cartItem.setSelected(isChecked);
            // Gọi callback để tính tổng giá tiền khi checkbox thay đổi
            onItemCheckListener.onItemChecked();
            onItemCheckListener.onProductChecked(cartItem.getSanPhamID(), isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return cartItems != null ? cartItems.size() : 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, quantity;
        ImageView imageView;
        CheckBox checkBox;
        public CartViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvTenSanPham);
            price = itemView.findViewById(R.id.tvGia);
            quantity = itemView.findViewById(R.id.tvSoLuong);
            imageView = itemView.findViewById(R.id.imgHinhAnh);
            checkBox = itemView.findViewById(R.id.cart_item_checkbox);
        }
    }
    public interface OnItemCheckListener {
        void onItemChecked();
        void onProductChecked(int productId, boolean isChecked);
    }

}
