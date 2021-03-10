package com.greedygametest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.greedygametest.R;
import com.greedygametest.Utility.Constants;
import com.greedygametest.ViewModles.GetPublicIconViewModle;
import com.greedygametest.adapters.IconSetsAdapter;
import com.greedygametest.adapters.PaginationScrollListener;
import com.greedygametest.databinding.IconSetsFragmentBinding;
import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;
import com.greedygametest.modles.getIPublicIconPkg.Iconset;

import java.util.List;


public class IconSetsFragment extends Fragment {
    private LinearLayoutManager linearLayoutManager;
    private IconSetsFragmentBinding iconSetsFragmentBinding;
    private Context context;
    private IconSetsAdapter iconSetsAdapter;
    private GetPublicIconViewModle getPublicIconViewModle;
    private List<Iconset> iconsetList;

    private static final int PAGE_START = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int TOTAL_PAGES = 5;
    private int currentPage = PAGE_START;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (iconSetsFragmentBinding == null) {
            iconSetsFragmentBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.icon_sets_fragment, container, false);
        }
        return iconSetsFragmentBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getPublicIconViewModle = ViewModelProviders.of(this).get(GetPublicIconViewModle.class);


        setupAdapter();
        if (Constants.isInternetConnected(getActivity())) {
            callPublicIconApi(Constants.HEADER, "20");
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();
        }


    }

    private void setupAdapter() {
        iconSetsAdapter = new IconSetsAdapter(context);
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        iconSetsFragmentBinding.rvIconSetId.setLayoutManager(linearLayoutManager);
        iconSetsFragmentBinding.rvIconSetId.setItemAnimator(new DefaultItemAnimator());
        iconSetsFragmentBinding.rvIconSetId.setAdapter(iconSetsAdapter);


        iconSetsFragmentBinding.rvIconSetId.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
               // //iconSetsAdapter.clear();
                if (currentPage < TOTAL_PAGES) {
                    isLoading = true;
                    currentPage += 1;
                    if (Constants.isInternetConnected(getActivity())) {
                        callPublicIconApiNext(Constants.HEADER, "20");
                    } else {
                        Toast.makeText(getActivity(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public int getTotalPageCount() {
                return TOTAL_PAGES;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });


    }

    public void callPublicIconApi(String header, String count) {
        iconSetsFragmentBinding.pbIconSetId.setVisibility(View.VISIBLE);
        getPublicIconViewModle.setPublicIconParam(header, count).observe(this, new Observer<GetPublicIcon>() {
            @Override
            public void onChanged(@Nullable GetPublicIcon loginResponse) {
                iconSetsFragmentBinding.pbIconSetId.setVisibility(View.GONE);
                if (loginResponse != null) {
                    iconsetList = loginResponse.getIconsets();
                    iconSetsAdapter.allIconSetslist(iconsetList);
                    if (currentPage == 0) {
                        // iconSetsAdapter.allIconSetslist(iconsetList);
                        if (TOTAL_PAGES > 0) {
                            if (currentPage <= TOTAL_PAGES)
                                iconSetsAdapter.addLoadingFooter();
                            else isLastPage = true;
                        }
                    }
                }
            }
        });
    }

    public void callPublicIconApiNext(String header, String count) {
        iconSetsFragmentBinding.pbIconSetId.setVisibility(View.VISIBLE);
        getPublicIconViewModle.setPublicIconParam(header, count).observe(this, new Observer<GetPublicIcon>() {
            @Override
            public void onChanged(@Nullable GetPublicIcon loginResponse) {
                iconSetsFragmentBinding.pbIconSetId.setVisibility(View.GONE);
                if (loginResponse != null) {
                    iconSetsAdapter.removeLoadingFooter();
                    isLoading = false;
                    iconsetList = loginResponse.getIconsets();
                    iconSetsAdapter.setmList(iconsetList);
                    if (currentPage <= TOTAL_PAGES)
                        iconSetsAdapter.addLoadingFooter();
                    else isLastPage = true;

                }
            }
        });
    }


}
