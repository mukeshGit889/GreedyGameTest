
package com.greedygametest.modles.getSetIconDetailPkg;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetIconSetDetail {

    @SerializedName("are_all_icons_glyph")
    @Expose
    private Boolean areAllIconsGlyph;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("styles")
    @Expose
    private List<Style> styles = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("iconset_id")
    @Expose
    private Integer iconsetId;
    @SerializedName("readme")
    @Expose
    private String readme;
    @SerializedName("icons_count")
    @Expose
    private Integer iconsCount;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("license")
    @Expose
    private License license;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("website_url")
    @Expose
    private String websiteUrl;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("is_premium")
    @Expose
    private Boolean isPremium;

    public Boolean getAreAllIconsGlyph() {
        return areAllIconsGlyph;
    }

    public void setAreAllIconsGlyph(Boolean areAllIconsGlyph) {
        this.areAllIconsGlyph = areAllIconsGlyph;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIconsetId() {
        return iconsetId;
    }

    public void setIconsetId(Integer iconsetId) {
        this.iconsetId = iconsetId;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public Integer getIconsCount() {
        return iconsCount;
    }

    public void setIconsCount(Integer iconsCount) {
        this.iconsCount = iconsCount;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }

}
