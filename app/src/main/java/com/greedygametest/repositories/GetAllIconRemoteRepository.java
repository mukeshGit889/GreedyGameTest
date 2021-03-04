package com.greedygametest.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.greedygametest.modles.getAllIconPkg.GetAllIcon;
import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;
import com.greedygametest.remoteApi.RestMaterApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllIconRemoteRepository implements GetAllIconRepository {

    private RestMaterApi restMaterApi;
    private static GetAllIconRemoteRepository instance;
    public static final String TAG = "GetPublicIconRemoteRepository";

    public GetAllIconRemoteRepository(RestMaterApi restMaterApi) {
        this.restMaterApi = restMaterApi;
    }

    public static synchronized GetAllIconRemoteRepository getInstance(RestMaterApi getPublicIconList) {
        if (instance == null) {
            instance = new GetAllIconRemoteRepository(getPublicIconList);
        }
        return instance;
    }

    @Override
    public LiveData<GetAllIcon> setAllIconParam(String header, String count) {
        MutableLiveData<GetAllIcon> listMutableLiveData = new MutableLiveData<>();
        restMaterApi.getAllIconList(header, String.valueOf(count)).enqueue(new Callback<GetAllIcon>() {
            @Override
            public void onResponse(Call<GetAllIcon> call, Response<GetAllIcon> response) {
                //Log.e(TAG, "onResponse: " +1);
                if (response.isSuccessful() && response.body() != null) {
                    listMutableLiveData.setValue(response.body());
                } else {
                    listMutableLiveData.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<GetAllIcon> call, Throwable t) {
                listMutableLiveData.setValue(null);

            }
        });
        return listMutableLiveData;

    }
}
