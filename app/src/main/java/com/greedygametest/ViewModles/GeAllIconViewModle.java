package com.greedygametest.ViewModles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.greedygametest.modles.getAllIconPkg.GetAllIcon;
import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;
import com.greedygametest.remoteApi.ApiConfig;
import com.greedygametest.remoteApi.RestMaterApi;
import com.greedygametest.repositories.GetAllIconRemoteRepository;
import com.greedygametest.repositories.GetPublicIconRemoteRepository;


public class GeAllIconViewModle extends ViewModel {
    private GetAllIconRemoteRepository getAllIconRemoteRepository;

    public GeAllIconViewModle() {
        this.getAllIconRemoteRepository = GetAllIconRemoteRepository.getInstance(ApiConfig.getRetrofitGson().create(RestMaterApi.class));
    }

    public LiveData<GetAllIcon> setAllIconParam(String header, String count) {
        return getAllIconRemoteRepository.setAllIconParam(header, count);
    }

}
