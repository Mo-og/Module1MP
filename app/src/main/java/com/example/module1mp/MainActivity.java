package com.example.module1mp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.module1mp.BelakorFragment;
import com.example.module1mp.InsomniumFragment;
import com.example.module1mp.WintersunFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        viewPager = findViewById(R.id.container);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        Adapter adapter = new Adapter(this);
        adapter.addFragment(new WintersunFragment());
        adapter.addFragment(new InsomniumFragment());
        adapter.addFragment(new BelakorFragment());
        viewPager.setAdapter(adapter);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    viewPager.setCurrentItem(0, true);
                    break;
                case R.id.account:
                    viewPager.setCurrentItem(1, true);
                    break;
                case R.id.category:
                    viewPager.setCurrentItem(2, true);
                    break;
            }
            return true;
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.account);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.category);
                        break;
                }
            }
        });
    }

    private class Adapter extends FragmentStateAdapter {
        private List<Fragment> list = new ArrayList<>();

        public void addFragment(Fragment fragment) {
            list.add(fragment);
        }

        public Adapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            return list.get(position);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}