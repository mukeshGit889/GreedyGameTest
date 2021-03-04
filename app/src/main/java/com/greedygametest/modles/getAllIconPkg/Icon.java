
package com.greedygametest.modles.getAllIconPkg;

import java.util.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon {

    @SerializedName("vector_sizes")
    @Expose
    private List<VectorSize> vectorSizes = null;
    @SerializedName("styles")
    @Expose
    private List<Style> styles = null;
    @SerializedName("containers")
    @Expose
    private List<Object> containers = null;
    @SerializedName("icon_id")
    @Expose
    private Integer iconId;
    @SerializedName("is_icon_glyph")
    @Expose
    private Boolean isIconGlyph;
    @SerializedName("raster_sizes")
    @Expose
    private List<RasterSize> rasterSizes = null;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("is_premium")
    @Expose
    private Boolean isPremium;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Icon() {
    }

    /**
     * 
     * @param iconId
     * @param publishedAt
     * @param rasterSizes
     * @param styles
     * @param containers
     * @param isPremium
     * @param categories
     * @param type
     * @param vectorSizes
     * @param isIconGlyph
     * @param tags
     */
    public Icon(List<VectorSize> vectorSizes, List<Style> styles, List<Object> containers, Integer iconId, Boolean isIconGlyph, List<RasterSize> rasterSizes, List<String> tags, String publishedAt, Boolean isPremium, List<Category> categories, String type) {
        super();
        this.vectorSizes = vectorSizes;
        this.styles = styles;
        this.containers = containers;
        this.iconId = iconId;
        this.isIconGlyph = isIconGlyph;
        this.rasterSizes = rasterSizes;
        this.tags = tags;
        this.publishedAt = publishedAt;
        this.isPremium = isPremium;
        this.categories = categories;
        this.type = type;
    }

    public List<VectorSize> getVectorSizes() {
        return vectorSizes;
    }

    public void setVectorSizes(List<VectorSize> vectorSizes) {
        this.vectorSizes = vectorSizes;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public List<Object> getContainers() {
        return containers;
    }

    public void setContainers(List<Object> containers) {
        this.containers = containers;
    }

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    public Boolean getIsIconGlyph() {
        return isIconGlyph;
    }

    public void setIsIconGlyph(Boolean isIconGlyph) {
        this.isIconGlyph = isIconGlyph;
    }

    public List<RasterSize> getRasterSizes() {
        return rasterSizes;
    }

    public void setRasterSizes(List<RasterSize> rasterSizes) {
        this.rasterSizes = rasterSizes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
