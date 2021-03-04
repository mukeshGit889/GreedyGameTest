package com.greedygametest.ViewModles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;
import com.greedygametest.modles.getIPublicIconPkg.Iconset;
import com.greedygametest.remoteApi.ApiConfig;
import com.greedygametest.remoteApi.RestMaterApi;
import com.greedygametest.repositories.GetPublicIconRemoteRepository;


public class GetPublicIconViewModle extends ViewModel {
    private GetPublicIconRemoteRepository getPublicIconRemoteRepository;

    public GetPublicIconViewModle() {
        this.getPublicIconRemoteRepository = GetPublicIconRemoteRepository.getInstance(ApiConfig.getRetrofitGson().create(RestMaterApi.class));
    }

    public LiveData<GetPublicIcon> setPublicIconParam(String header, String count) {
        return getPublicIconRemoteRepository.setPublicIconParam(header, count);
    }

}
