package com.greedygametest.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

import com.greedygametest.R;
import com.greedygametest.Utility.Constants;
import com.greedygametest.ViewModles.GeSetIconDetailViewModle;
import com.greedygametest.adapters.IconSetsDetailAdapter;
import com.greedygametest.databinding.ActivityIconSetsDetailBinding;
import com.greedygametest.modles.getSetIconDetailPkg.GetIconSetDetail;

public class IconSetsDetail extends AppCompatActivity {
    private ActivityIconSetsDetailBinding iconSetsDetailBinding;
    private IconSetsDetailAdapter iconSetsDetailAdapter;
    private String iconId;
    private String autherId;

    private GeSetIconDetailViewModle geSetIconDetailViewModle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iconSetsDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_icon_sets_detail);
        if (getIntent().getExtras() != null) {
            iconId = getIntent().getExtras().getString("iconId");
        }
        initializeViews();
    }

    private void initializeViews() {
        iconSetsDetailBinding.includeId.tvTitleId.setVisibility(View.GONE);
        iconSetsDetailBinding.includeId.tvBackId.setVisibility(View.VISIBLE);

        iconSetsDetailAdapter = new IconSetsDetailAdapter(getApplicationContext());
        iconSetsDetailBinding.rvIconSetDetailId.setItemAnimator(new DefaultItemAnimator());
        iconSetsDetailBinding.rvIconSetDetailId.setAdapter(iconSetsDetailAdapter);

        iconSetsDetailBinding.setListener(new ClickListener());
        iconSetsDetailBinding.includeId.tvBackId.setOnClickListener(nev -> finish());
        iconSetsDetailBinding.tvWebSiteId.setOnClickListener(nev ->
        {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(iconSetsDetailBinding.tvWebSiteId.getText().toString()));
            startActivity(i);
        });

        geSetIconDetailViewModle = ViewModelProviders.of(this).get(GeSetIconDetailViewModle.class);
        if (Constants.isInternetConnected(getApplicationContext())) {
            callSetIconDetailApi(iconId, Constants.HEADER);
        } else {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();
        }

    }


    public void callSetIconDetailApi(String iconSet_Id, String header) {
        iconSetsDetailBinding.pbIconSetId.setVisibility(View.VISIBLE);
        geSetIconDetailViewModle.setIconDetailParam(iconSet_Id, header).observe(this, new Observer<GetIconSetDetail>() {
            @Override
            public void onChanged(@Nullable GetIconSetDetail getResponse) {
                iconSetsDetailBinding.pbIconSetId.setVisibility(View.GONE);
                if (getResponse != null) {
                    iconSetsDetailBinding.tvAutherNameId.setText(getResponse.getAuthor().getName());
                    iconSetsDetailBinding.tvIsNameId.setText(getResponse.getName());
                    iconSetsDetailBinding.tvIsTypeId.setText(getResponse.getType());
                    // iconSetsDetailBinding.tvLicenceId.setText(getResponse.getLicense().getName());
                    iconSetsDetailBinding.tvPriceId.setText(getResources().getString(R.string.unAvailable));
                    iconSetsDetailBinding.tvReadMeDetailId.setText(Html.fromHtml(getResponse.getReadme()));
                    // iconSetsDetailBinding.tvWebSiteId.setText(getResponse.getWebsiteUrl());
                    //underline

                    try {
                        autherId = getResponse.getAuthor().getUserId().toString();
                    } catch (Exception e) {
                        autherId = "0";
                        e.printStackTrace();
                    }
                    iconSetsDetailBinding.tvWebSiteId.setPaintFlags(iconSetsDetailBinding.tvWebSiteId.getPaintFlags() |
                            Paint.UNDERLINE_TEXT_FLAG);

                    if (getResponse.getIsPremium()) {
                        iconSetsDetailBinding.tvFreeId.setText(getResources().getString(R.string.true_));
                    } else {
                        iconSetsDetailBinding.tvFreeId.setText(getResources().getString(R.string.false_));
                    }
                    // Log.d(TAG, "onResponse: "+new Gson().toJson(loginResponse));

                } else {
                    // AlertDialogManager.showAlertDialog(LoginActivity.this, getString(R.string.alert),  getString(R.string.msg_something_went_wrong));
                }
            }
        });
    }

    public class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tvWebSiteId) {//
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(iconSetsDetailBinding.tvWebSiteId.getText().toString()));
                startActivity(i);
            } else if (v.getId() == R.id.tvDownloadId) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.dnavailable), Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.tvAutherNameId) {
                if (autherId.equals("0")) {
                } else {
                    Intent send = new Intent(getApplicationContext(), AutherDetailActivity.class);
                    send.putExtra("autherId", "" + autherId);
                    startActivity(send);
                }
            }


        }
    }
}