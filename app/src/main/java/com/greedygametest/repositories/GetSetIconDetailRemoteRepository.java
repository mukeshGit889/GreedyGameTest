package com.greedygametest.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.greedygametest.modles.getSetIconDetailPkg.GetIconSetDetail;
import com.greedygametest.modles.getIconDetailPkg.GetIconDetail;
import com.greedygametest.remoteApi.RestMaterApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetSetIconDetailRemoteRepository implements GetSetIconDetailRepository {

    private RestMaterApi restMaterApi;
    private static GetSetIconDetailRemoteRepository instance;
    public static final String TAG = "GetPublicIconRemoteRepository";

    public GetSetIconDetailRemoteRepository(RestMaterApi restMaterApi) {
        this.restMaterApi = restMaterApi;
    }

    public static synchronized GetSetIconDetailRemoteRepository getInstance(RestMaterApi getPublicIconList) {
        if (instance == null) {
            instance = new GetSetIconDetailRemoteRepository(getPublicIconList);
        }
        return instance;
    }

    @Override
    public LiveData<GetIconSetDetail> setIconDetailParam(String iconset_id,String header) {
        MutableLiveData<GetIconSetDetail> listMutableLiveData = new MutableLiveData<>();
        restMaterApi.getSetIconDetail(iconset_id,header).enqueue(new Callback<GetIconSetDetail>() {
            @Override
            public void onResponse(Call<GetIconSetDetail> call, Response<GetIconSetDetail> response) {
                //Log.e(TAG, "onResponse: " +1);
                if (response.isSuccessful() && response.body() != null) {
                    listMutableLiveData.setValue(response.body());
                } else {
                    listMutableLiveData.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<GetIconSetDetail> call, Throwable t) {
                listMutableLiveData.setValue(null);

            }
        });
        return listMutableLiveData;

    }

    @Override
    public LiveData<GetIconDetail> setIconParam(String iconset_id, String header) {
        MutableLiveData<GetIconDetail> listMutableLiveData = new MutableLiveData<>();
        restMaterApi.getIconDetail(iconset_id,header).enqueue(new Callback<GetIconDetail>() {
            @Override
            public void onResponse(Call<GetIconDetail> call, Response<GetIconDetail> response) {
                //Log.e(TAG, "onResponse: " +1);
                if (response.isSuccessful() && response.body() != null) {
                    listMutableLiveData.setValue(response.body());
                } else {
                    listMutableLiveData.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<GetIconDetail> call, Throwable t) {
                listMutableLiveData.setValue(null);

            }
        });
        return listMutableLiveData;
    }

}
