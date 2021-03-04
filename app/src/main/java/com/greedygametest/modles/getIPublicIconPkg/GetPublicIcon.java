
package com.greedygametest.modles.getIPublicIconPkg;

import java.util.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPublicIcon {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("iconsets")
    @Expose
    private List<Iconset> iconsets = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetPublicIcon() {
    }

    /**
     * 
     * @param iconsets
     * @param totalCount
     */
    public GetPublicIcon(Integer totalCount, List<Iconset> iconsets) {
        super();
        this.totalCount = totalCount;
        this.iconsets = iconsets;
    }

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
