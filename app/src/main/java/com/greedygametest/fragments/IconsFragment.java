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

import com.greedygametest.R;
import com.greedygametest.Utility.Constants;
import com.greedygametest.ViewModles.GeAllIconViewModle;
import com.greedygametest.ViewModles.GetPublicIconViewModle;
import com.greedygametest.adapters.IconAdapter;
import com.greedygametest.databinding.IconsFragmentBinding;
import com.greedygametest.modles.getAllIconPkg.GetAllIcon;
import com.greedygametest.modles.getAllIconPkg.Icon;
import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;
import com.greedygametest.modles.getIPublicIconPkg.Iconset;

import java.util.List;


public class IconsFragment extends Fragment {

    private IconsFragmentBinding iconsFragmentBinding;
    private Context context;
    private IconAdapter iconAdapter;
    private List<Icon> getAllIconList;
    private GeAllIconViewModle geAllIconViewModle;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (iconsFragmentBinding == null) {
            iconsFragmentBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.icons_fragment, container, false);
        }
        return iconsFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        geAllIconViewModle = ViewModelProviders.of(this).get(GeAllIconViewModle.class);
        setupAdapter();
        if(Constants.isInternetConnected(getActivity()))
        {
            callAllIconApi(Constants.HEADER,"5");
        }
        else {
            Toast.makeText(getActivity(),getResources().getString(R.string.network),Toast.LENGTH_LONG).show();

        }


    }

    private void setupAdapter() {
        iconAdapter = new IconAdapter(context);
        iconsFragmentBinding.rvIconSetId.setItemAnimator(new DefaultItemAnimator());
        iconsFragmentBinding.rvIconSetId.setAdapter(iconAdapter);
    }


    public  void callAllIconApi(String header, String count) {
        iconsFragmentBinding.pbIconSetId.setVisibility(View.VISIBLE);
        geAllIconViewModle.setAllIconParam(header,count).observe(this, new Observer<GetAllIcon>() {
            @Override
            public void onChanged(@Nullable GetAllIcon loginResponse) {
                iconsFragmentBinding.pbIconSetId.setVisibility(View.GONE);
                if(loginResponse!=null){
                    getAllIconList=loginResponse.getIcons();
                    iconAdapter.allIconSetslist(getAllIconList);
                }else {
                }
            }
        });
    }

}
