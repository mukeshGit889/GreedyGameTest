package com.greedygametest.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.greedygametest.R;
import com.greedygametest.Utility.Constants;
import com.greedygametest.ViewModles.GetIconDetailViewModle;
import com.greedygametest.databinding.ActivityIconsDetailBinding;
import com.greedygametest.modles.autherPkg.AutherDetail;
import com.greedygametest.modles.getIconDetailPkg.GetIconDetail;

public class IconsDetail extends AppCompatActivity {
    private ActivityIconsDetailBinding iconsDetailBinding;
    private String iconId, iconUrl, iconDownloadingUrl, autherId;

    private GetIconDetailViewModle getIconDetailViewModle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iconsDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_icons_detail);
        if (getIntent().getExtras() != null) {
            iconId = getIntent().getExtras().getString("iconId");
            iconUrl = getIntent().getExtras().getString("iconImg");
            iconDownloadingUrl = getIntent().getExtras().getString("iconDownloadUrl");
        }
        initializeViews();
    }

    private void initializeViews() {
        //toolbar setup
        iconsDetailBinding.includeId.tvTitleId.setVisibility(View.GONE);
        iconsDetailBinding.includeId.tvBackId.setVisibility(View.VISIBLE);
        iconsDetailBinding.setListener(new ClickListener());
        ///clicking setup
        iconsDetailBinding.includeId.tvBackId.setOnClickListener(nev -> finish());
        Glide.with(getApplicationContext())
                .load(iconUrl)
                .placeholder(R.drawable.logo)
                .into(iconsDetailBinding.ivIconId);

        getIconDetailViewModle = ViewModelProviders.of(this).get(GetIconDetailViewModle.class);
        if (Constants.isInternetConnected(getApplicationContext())) {
            callIconDetailApi(iconId, Constants.HEADER);
        } else {
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.network),Toast.LENGTH_LONG).show();

        }
    }

    public void callIconDetailApi(String iconSet_Id, String header) {
        iconsDetailBinding.pbIconSetId.setVisibility(View.VISIBLE);
        getIconDetailViewModle.setIconParam(iconSet_Id, header).observe(this, new Observer<GetIconDetail>() {
            @Override
            public void onChanged(@Nullable GetIconDetail getResponse) {
                iconsDetailBinding.pbIconSetId.setVisibility(View.GONE);
                if (getResponse != null) {
                    iconsDetailBinding.tvAutherNameId.setText(getResponse.getIconset().getAuthor().getName());
                    iconsDetailBinding.tvIsNameId.setText(getResponse.getIconset().getName());
                    iconsDetailBinding.tvIsTypeId.setText(getResponse.getType());
                    iconsDetailBinding.tvLicenceId.setText(getResponse.getIconset().getLicense().getName());
                    iconsDetailBinding.tvPriceId.setText(getResources().getString(R.string.unAvailable));
                    iconsDetailBinding.tvReadMeDetailId.setText(getResources().getString(R.string.unAvailable));
                    iconsDetailBinding.tvWebSiteId.setText(getResponse.getIconset().getWebsiteUrl());
                    autherId = "" + getResponse.getIconset().getAuthor().getUserId();
                    //underline
                    iconsDetailBinding.tvWebSiteId.setPaintFlags(iconsDetailBinding.tvWebSiteId.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                    if (getResponse.getIsPremium()) {
                        iconsDetailBinding.tvFreeId.setText(getResources().getString(R.string.true_));
                    } else {
                        iconsDetailBinding.tvFreeId.setText(getResources().getString(R.string.false_));
                    }

                } else {
                }
            }
        });
    }

    public class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tvWebSiteId) {//
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(iconsDetailBinding.tvWebSiteId.getText().toString()));
                startActivity(i);
            } else if (v.getId() == R.id.tvDownloadId) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.dnavailable), Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.tvAutherNameId) {
                Intent send = new Intent(getApplicationContext(), AutherDetailActivity.class);
                send.putExtra("autherId", "" + autherId);
                startActivity(send);
            }


        }
    }
}