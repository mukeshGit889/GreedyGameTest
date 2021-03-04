package com.greedygametest.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;
import com.greedygametest.remoteApi.RestMaterApi;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPublicIconRemoteRepository implements GetPublicIconRepository {

    private RestMaterApi restMaterApi;
    private static GetPublicIconRemoteRepository instance;
    public static final String TAG = "GetPublicIconRemoteRepository";

    public GetPublicIconRemoteRepository(RestMaterApi restMaterApi) {
        this.restMaterApi = restMaterApi;
    }

    public static synchronized GetPublicIconRemoteRepository getInstance(RestMaterApi getPublicIconList) {
        if (instance == null) {
            instance = new GetPublicIconRemoteRepository(getPublicIconList);
        }
        return instance;
    }

    @Override
    public LiveData<GetPublicIcon> setPublicIconParam(String header, String count) {
        MutableLiveData<GetPublicIcon> listMutableLiveData = new MutableLiveData<>();
        restMaterApi.getPublicIconList(header, String.valueOf(count)).enqueue(new Callback<GetPublicIcon>() {
            @Override
            public void onResponse(Call<GetPublicIcon> call, Response<GetPublicIcon> response) {
                //Log.e(TAG, "onResponse: " +1);
                if (response.isSuccessful() && response.body() != null) {
                    listMutableLiveData.setValue(response.body());
                } else {
                    listMutableLiveData.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<GetPublicIcon> call, Throwable t) {
                listMutableLiveData.setValue(null);

            }
        });
        return listMutableLiveData;

    }
}
