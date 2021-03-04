
package com.greedygametest.modles.getAllIconPkg;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAllIcon {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("icons")
    @Expose
    private List<Icon> icons = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetAllIcon() {
    }

    /**
     * 
     * @param totalCount
     * @param icons
     */
    public GetAllIcon(Integer totalCount, List<Icon> icons) {
        super();
        this.totalCount = totalCount;
        this.icons = icons;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<Icon> getIcons() {
        return icons;
    }

    public void setIcons(List<Icon> icons) {
        this.icons = icons;
    }

}
