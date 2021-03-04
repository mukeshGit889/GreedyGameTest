package com.greedygametest.ViewModles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.greedygametest.modles.getSetIconDetailPkg.GetIconSetDetail;
import com.greedygametest.remoteApi.ApiConfig;
import com.greedygametest.remoteApi.RestMaterApi;
import com.greedygametest.repositories.GetSetIconDetailRemoteRepository;


public class GeSetIconDetailViewModle extends ViewModel {
    private GetSetIconDetailRemoteRepository getSetIconDetailRemoteRepository;

    public GeSetIconDetailViewModle() {
        this.getSetIconDetailRemoteRepository = GetSetIconDetailRemoteRepository.getInstance(ApiConfig.getRetrofitGson().create(RestMaterApi.class));
    }

    public LiveData<GetIconSetDetail> setIconDetailParam( String iconSet_Id,String header) {
        return getSetIconDetailRemoteRepository.setIconDetailParam(iconSet_Id,header);
    }

}
