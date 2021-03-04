package com.greedygametest.ViewModles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.greedygametest.modles.autherIconPkg.AutherDetailIcon;
import com.greedygametest.modles.autherPkg.AutherDetail;
import com.greedygametest.remoteApi.ApiConfig;
import com.greedygametest.remoteApi.RestMaterApi;
import com.greedygametest.repositories.GetAutherRemoteRepository;


public class GetAutherDetailViewModle extends ViewModel {
    private GetAutherRemoteRepository getAutherRemoteRepository;

    public GetAutherDetailViewModle() {
        this.getAutherRemoteRepository = GetAutherRemoteRepository.getInstance(ApiConfig.getRetrofitGson().create(RestMaterApi.class));
    }

    public LiveData<AutherDetail> setAutherParam(String header, String autherId) {
        return getAutherRemoteRepository.setAutherParam(header, autherId);
    }

    public LiveData<AutherDetailIcon> getAutherIcon(String header, String autherId) {
        return getAutherRemoteRepository.getAutherIcon(header, autherId);
    }

}
