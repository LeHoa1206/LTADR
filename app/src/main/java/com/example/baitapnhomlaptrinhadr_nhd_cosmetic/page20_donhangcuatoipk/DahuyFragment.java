package com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page20_donhangcuatoipk;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.R;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page22_chitietdonhang2;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page23_chitietdonhang3;

public class DahuyFragment extends Fragment {
    Button chitiet1, chitiet2, chitiet3;

    public DahuyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dahuy, container, false);

        // Ánh xạ các nút chitiet1, chitiet2, chitiet3 từ layout
        chitiet1 = view.findViewById(R.id.chitiet1);
        chitiet2 = view.findViewById(R.id.chitiet2);
        chitiet3 = view.findViewById(R.id.chitiet3);

        // Thiết lập sự kiện khi nhấn vào chitiet1
        chitiet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở page22_chitietdonhang2
                Intent intent = new Intent(getActivity(), page23_chitietdonhang3.class);
                startActivity(intent);
            }
        });

        // Thiết lập sự kiện khi nhấn vào chitiet2
        chitiet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở page22_chitietdonhang2
                Intent intent = new Intent(getActivity(), page23_chitietdonhang3.class);
                startActivity(intent);
            }
        });

        // Thiết lập sự kiện khi nhấn vào chitiet3
        chitiet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở page22_chitietdonhang2
                Intent intent = new Intent(getActivity(), page23_chitietdonhang3.class);
                startActivity(intent);
            }
        });

        // Trả về view
        return view;
    }
}
