package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page20_donhangcuatoipk.ChoxulyFragment;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page20_donhangcuatoipk.DagiaoFragment;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page20_donhangcuatoipk.DahuyFragment;
import com.example.baitapnhomlaptrinhadr_nhd_cosmetic.page20_donhangcuatoipk.page20_adapter;
import com.google.android.material.tabs.TabLayout;

public class page20_donhangcuatoi extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentStatePagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_20_donhangcuatoi);

        tabLayout = findViewById(R.id.statustablayout);
        viewPager = findViewById(R.id.viewpager);

        // Kết nối TabLayout với ViewPager
        tabLayout.setupWithViewPager(viewPager);

        page20_adapter page20Adapter = new page20_adapter(
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );

        // Thêm các Fragment và tiêu đề tương ứng
        page20Adapter.addFragment(new ChoxulyFragment(), "Chờ xử lý");
        page20Adapter.addFragment(new DagiaoFragment(), "Đã giao");
        page20Adapter.addFragment(new DahuyFragment(), "Đã hủy");

        viewPager.setAdapter(page20Adapter);
    }

}
