package com.hippot.bilibili.function.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.hippot.bilibili.R;
import com.hippot.bilibili.base.SimpleActivity;
import com.hippot.bilibili.function.fragment.main.HomeFragment;
import com.hippot.bilibili.utils.BottomNavigationViewHelper;

import butterknife.BindView;

public class MainActivity extends SimpleActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigationView;
    private HomeFragment mHomeFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mHomeFragment = new HomeFragment();
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container , mHomeFragment)
                .commit();

    }

    @Override
    protected void initData(Bundle savedInstanceState) {



    }


    @Override
    protected void setEvent() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:

                        break;
                    case R.id.partition:

                        break;

                    case R.id.dynamic:

                        break;
                    case R.id.message:

                        break;
                }

                return false;
            }
        });
    }

}
