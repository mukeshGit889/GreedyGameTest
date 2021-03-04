package com.greedygametest.repositories;

import androidx.lifecycle.LiveData;

import com.greedygametest.modles.autherIconPkg.AutherDetailIcon;
import com.greedygametest.modles.autherPkg.AutherDetail;
import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;

public interface GetAutherDetailRepository {
    LiveData<AutherDetail> setAutherParam(String header, String autherId);
    LiveData<AutherDetailIcon> getAutherIcon(String header, String autherId);

}
