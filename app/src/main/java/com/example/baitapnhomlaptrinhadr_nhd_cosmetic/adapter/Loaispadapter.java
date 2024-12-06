    package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.adapter;

    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.TextView;
    import androidx.recyclerview.widget.RecyclerView;
    import com.bumptech.glide.Glide;
    import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.R;
    import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.model.SanPham;
    import java.util.List;

    public class Loaispadapter extends RecyclerView.Adapter<Loaispadapter.SanPhamViewHolder> {

        private List<SanPham> sanPhamList;

        public Loaispadapter(List<SanPham> sanPhamList) {
            this.sanPhamList = sanPhamList;
        }

        @Override
        public SanPhamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham, parent, false);
            return new SanPhamViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SanPhamViewHolder holder, int position) {
            SanPham sanPham = sanPhamList.get(position);
            holder.tenSanPham.setText(sanPham.getTenSanPham());
            holder.giaSanPham.setText(String.valueOf(sanPham.getGia()));
            Glide.with(holder.itemView.getContext())
                    .load(sanPham.getHinhAnh())
                    .into(holder.hinhAnh);
        }

        @Override
        public int getItemCount() {
            return sanPhamList.size();
        }

        public static class SanPhamViewHolder extends RecyclerView.ViewHolder {

            TextView tenSanPham, giaSanPham;
            ImageView hinhAnh;

            public SanPhamViewHolder(View itemView) {
                super(itemView);
                tenSanPham = itemView.findViewById(R.id.tenSanPham);
                giaSanPham = itemView.findViewById(R.id.giaSanPham);
                hinhAnh = itemView.findViewById(R.id.hinhAnhSanPham);
            }
        }
    }
