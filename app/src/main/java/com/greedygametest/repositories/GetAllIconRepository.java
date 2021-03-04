package com.greedygametest.repositories;

import androidx.lifecycle.LiveData;

import com.greedygametest.modles.getAllIconPkg.GetAllIcon;
import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;

public interface GetAllIconRepository {
    LiveData<GetAllIcon> setAllIconParam(String header, String count);

}
