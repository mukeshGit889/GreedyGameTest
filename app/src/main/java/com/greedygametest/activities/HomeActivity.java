package com.greedygametest.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.greedygametest.R;
import com.greedygametest.adapters.HomePagerAdapter;
import com.greedygametest.databinding.ActivityHomeBinding;
import com.greedygametest.fragments.IconSetsFragment;
import com.greedygametest.fragments.IconsFragment;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding homeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        initializeViews();

    }

    public void initializeViews() {

        homeBinding.includeId.tvTitleId.setVisibility(View.VISIBLE);
        homeBinding.includeId.tvBackId.setVisibility(View.GONE);
        homeBinding.includeId.tvTitleId.setText(getResources().getString(R.string.home));


        // setting up the adapter
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
        // add the fragments
        homePagerAdapter.add(new IconSetsFragment(), "Icon Sets");
        homePagerAdapter.add(new IconsFragment(), "Icons");
        // Set the adapter
        homeBinding.vpHomeId.setAdapter(homePagerAdapter);
        // we use the setupWithViewPager().
        homeBinding.tlHomeId.setupWithViewPager(homeBinding.vpHomeId);
    }
}