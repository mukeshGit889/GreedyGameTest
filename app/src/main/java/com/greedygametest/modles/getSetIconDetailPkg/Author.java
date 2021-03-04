
package com.greedygametest.modles.getSetIconDetailPkg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("iconsets_count")
    @Expose
    private Integer iconsetsCount;
    @SerializedName("is_designer")
    @Expose
    private Boolean isDesigner;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("user_id")
    @Expose
    private Integer userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIconsetsCount() {
        return iconsetsCount;
    }

    public void setIconsetsCount(Integer iconsetsCount) {
        this.iconsetsCount = iconsetsCount;
    }

    public Boolean getIsDesigner() {
        return isDesigner;
    }

    public void setIsDesigner(Boolean isDesigner) {
        this.isDesigner = isDesigner;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
