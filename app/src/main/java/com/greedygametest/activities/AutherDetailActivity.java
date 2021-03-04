package com.greedygametest.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.greedygametest.R;
import com.greedygametest.Utility.Constants;
import com.greedygametest.ViewModles.GetAutherDetailViewModle;
import com.greedygametest.adapters.AutherSetAdapter;
import com.greedygametest.databinding.ActivityAutherDetailBinding;
import com.greedygametest.modles.autherIconPkg.AutherDetailIcon;
import com.greedygametest.modles.autherIconPkg.Iconset;
import com.greedygametest.modles.autherPkg.AutherDetail;

import java.util.List;

public class AutherDetailActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private ActivityAutherDetailBinding activityAutherDetailBinding;
    private AutherSetAdapter autherSetAdapter;
    private GetAutherDetailViewModle getAutherDetailViewModle;
    private String autherId;
    private List<Iconset> iconsetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAutherDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_auther_detail);
        getAutherDetailViewModle = ViewModelProviders.of(this).get(GetAutherDetailViewModle.class);
        if (getIntent().getExtras() != null) {
            autherId = getIntent().getExtras().getString("autherId");
        }
        initlize();
    }

    private void initlize() {
        activityAutherDetailBinding.includeId.tvTitleId.setVisibility(View.GONE);
        activityAutherDetailBinding.includeId.tvBackId.setVisibility(View.VISIBLE);
        ///clicking setup
        activityAutherDetailBinding.includeId.tvBackId.setOnClickListener(nev -> finish());

        autherSetAdapter = new AutherSetAdapter(this);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        activityAutherDetailBinding.rvIconSetId.setLayoutManager(linearLayoutManager);
        activityAutherDetailBinding.rvIconSetId.setItemAnimator(new DefaultItemAnimator());
        activityAutherDetailBinding.rvIconSetId.setAdapter(autherSetAdapter);


        if (Constants.isInternetConnected(getApplicationContext())) {
            callAuthorApi(Constants.HEADER, autherId);
        } else {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();
        }
    }

    public void callAuthorApi(String header, String autherId) {
        activityAutherDetailBinding.pbIconSetId.setVisibility(View.VISIBLE);
        getAutherDetailViewModle.setAutherParam(header, autherId).observe(this, new Observer<AutherDetail>() {
            @Override
            public void onChanged(@Nullable AutherDetail autherDetail) {
                activityAutherDetailBinding.pbIconSetId.setVisibility(View.GONE);
                if (autherDetail != null) {
                    activityAutherDetailBinding.tvAutherNameId.setText(autherDetail.getName());

                    getAutherDetailViewModle.getAutherIcon(header, autherId).observe(AutherDetailActivity.this,
                            new Observer<AutherDetailIcon>() {
                                @Override
                                public void onChanged(@Nullable AutherDetailIcon autherDetailIcon) {
                                    activityAutherDetailBinding.pbIconSetId.setVisibility(View.GONE);
                                    if (autherDetailIcon != null) {
                                        iconsetList = autherDetailIcon.getIconsets();
                                        autherSetAdapter.allIconSetslist(iconsetList, autherDetail.getName());
                                    } else {
                                    }
                                }
                            });
                }
            }
        });
    }
}