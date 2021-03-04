package com.greedygametest.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.greedygametest.modles.autherIconPkg.AutherDetailIcon;
import com.greedygametest.modles.autherPkg.AutherDetail;
import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;
import com.greedygametest.remoteApi.RestMaterApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAutherRemoteRepository implements GetAutherDetailRepository {
    private RestMaterApi restMaterApi;
    private static GetAutherRemoteRepository instance;
    public static final String TAG = "GetPublicIconRemoteRepository";

    public GetAutherRemoteRepository(RestMaterApi restMaterApi) {
        this.restMaterApi = restMaterApi;
    }

    public static synchronized GetAutherRemoteRepository getInstance(RestMaterApi getPublicIconList) {
        if (instance == null) {
            instance = new GetAutherRemoteRepository(getPublicIconList);
        }
        return instance;
    }



    @Override
    public LiveData<AutherDetail> setAutherParam(String header, String autherId) {
        MutableLiveData<AutherDetail> listMutableLiveData = new MutableLiveData<>();
        restMaterApi.getAutherDetail(header, autherId).enqueue(new Callback<AutherDetail>() {
            @Override
            public void onResponse(Call<AutherDetail> call, Response<AutherDetail> response) {
                //Log.e(TAG, "onResponse: " +1);
                if (response.isSuccessful() && response.body() != null) {
                    listMutableLiveData.setValue(response.body());
                } else {
                    listMutableLiveData.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<AutherDetail> call, Throwable t) {
                listMutableLiveData.setValue(null);

            }
        });
        return listMutableLiveData;
    }

    @Override
    public LiveData<AutherDetailIcon> getAutherIcon(String header, String autherId) {
        MutableLiveData<AutherDetailIcon> listMutableLiveData = new MutableLiveData<>();
        restMaterApi.getAutherIcon(header, autherId).enqueue(new Callback<AutherDetailIcon>() {
            @Override
            public void onResponse(Call<AutherDetailIcon> call, Response<AutherDetailIcon> response) {
                //Log.e(TAG, "onResponse: " +1);
                if (response.isSuccessful() && response.body() != null) {
                    listMutableLiveData.setValue(response.body());
                } else {
                    listMutableLiveData.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<AutherDetailIcon> call, Throwable t) {
                listMutableLiveData.setValue(null);

            }
        });
        return listMutableLiveData;

    }
}
