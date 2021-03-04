
package com.greedygametest.modles.autherIconPkg;

import java.util.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AutherDetailIcon {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("iconsets")
    @Expose
    private List<Iconset> iconsets = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<Iconset> getIconsets() {
        return iconsets;
    }

    public void setIconsets(List<Iconset> iconsets) {
        this.iconsets = iconsets;
    }

}
