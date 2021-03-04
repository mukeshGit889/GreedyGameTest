package com.greedygametest.repositories;

import androidx.lifecycle.LiveData;

import com.greedygametest.modles.getSetIconDetailPkg.GetIconSetDetail;
import com.greedygametest.modles.getIconDetailPkg.GetIconDetail;

public interface GetSetIconDetailRepository {
    LiveData<GetIconSetDetail> setIconDetailParam(String iconset_id,String header);
    LiveData<GetIconDetail> setIconParam(String iconset_id, String header);

}
