
package com.greedygametest.modles.autherIconPkg;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Iconset {

    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("are_all_icons_glyph")
    @Expose
    private Boolean areAllIconsGlyph;
    @SerializedName("styles")
    @Expose
    private List<Style> styles = null;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("iconset_id")
    @Expose
    private Integer iconsetId;
    @SerializedName("icons_count")
    @Expose
    private Integer iconsCount;
    @SerializedName("is_premium")
    @Expose
    private Boolean isPremium;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("website_url")
    @Expose
    private String websiteUrl;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("license")
    @Expose
    private License license;

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Boolean getAreAllIconsGlyph() {
        return areAllIconsGlyph;
    }

    public void setAreAllIconsGlyph(Boolean areAllIconsGlyph) {
        this.areAllIconsGlyph = areAllIconsGlyph;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIconsetId() {
        return iconsetId;
    }

    public void setIconsetId(Integer iconsetId) {
        this.iconsetId = iconsetId;
    }

    public Integer getIconsCount() {
        return iconsCount;
    }

    public void setIconsCount(Integer iconsCount) {
        this.iconsCount = iconsCount;
    }

    public Boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

}
