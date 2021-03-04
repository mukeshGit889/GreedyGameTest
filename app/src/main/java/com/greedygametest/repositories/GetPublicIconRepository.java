package com.greedygametest.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;
import com.greedygametest.modles.getIPublicIconPkg.Iconset;

import java.util.List;

public interface GetPublicIconRepository {
    LiveData<GetPublicIcon> setPublicIconParam(String header, String count);

}
