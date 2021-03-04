package com.greedygametest.remoteApi;

import com.greedygametest.modles.autherIconPkg.AutherDetailIcon;
import com.greedygametest.modles.autherPkg.AutherDetail;
import com.greedygametest.modles.getSetIconDetailPkg.GetIconSetDetail;
import com.greedygametest.modles.getAllIconPkg.GetAllIcon;
import com.greedygametest.modles.getIPublicIconPkg.GetPublicIcon;
import com.greedygametest.modles.getIconDetailPkg.GetIconDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestMaterApi {

    @GET("iconsets?")
    Call<GetPublicIcon> getPublicIconList(@Header("Authorization") String authorization,
                                          @Query("count") String count);

    @GET("iconsets/1761/icons?")
    Call<GetAllIcon> getAllIconList(@Header("Authorization") String authorization,
                                    @Query("count") String count);


    @GET("iconsets/{iconset_id}")
    Call<GetIconSetDetail> getSetIconDetail(@Path("iconset_id") String iconset_id, @Header("Authorization") String authorization);


    @GET("icons/{icon_id}")
    Call<GetIconDetail> getIconDetail(@Path("icon_id") String icon_id, @Header("Authorization") String authorization);

    @GET("authors/{author_id}")
    Call<AutherDetail> getAutherDetail(@Header("Authorization") String authorization,@Path("author_id") String author_id);


    @GET("authors/{author_id}/iconsets")
    Call<AutherDetailIcon> getAutherIcon(@Header("Authorization") String authorization, @Path("author_id") String author_id);


}
