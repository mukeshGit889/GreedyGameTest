
package com.greedygametest.modles.getIPublicIconPkg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("is_designer")
    @Expose
    private Boolean isDesigner;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("iconsets_count")
    @Expose
    private Integer iconsetsCount;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("user_id")
    @Expose
    private Integer userId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Author() {
    }

    /**
     * 
     * @param isDesigner
     * @param iconsetsCount
     * @param name
     * @param userId
     * @param username
     */
    public Author(Boolean isDesigner, String username, Integer iconsetsCount, String name, Integer userId) {
        super();
        this.isDesigner = isDesigner;
        this.username = username;
        this.iconsetsCount = iconsetsCount;
        this.name = name;
        this.userId = userId;
    }

    public Boolean getIsDesigner() {
        return isDesigner;
    }

    public void setIsDesigner(Boolean isDesigner) {
        this.isDesigner = isDesigner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
