
package com.greedygametest.modles.autherPkg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AutherDetail {

    @SerializedName("iconsets_count")
    @Expose
    private Integer iconsetsCount;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("author_id")
    @Expose
    private Integer authorId;
    @SerializedName("website_url")
    @Expose
    private String websiteUrl;

    public Integer getIconsetsCount() {
        return iconsetsCount;
    }

    public void setIconsetsCount(Integer iconsetsCount) {
        this.iconsetsCount = iconsetsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

}
