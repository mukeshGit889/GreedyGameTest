
package com.greedygametest.modles.getIconDetailPkg;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetIconDetail {

    @SerializedName("vector_sizes")
    @Expose
    private List<VectorSize> vectorSizes = null;
    @SerializedName("iconset")
    @Expose
    private Iconset iconset;
    @SerializedName("containers")
    @Expose
    private List<Object> containers = null;
    @SerializedName("icon_id")
    @Expose
    private Integer iconId;
    @SerializedName("raster_sizes")
    @Expose
    private List<RasterSize> rasterSizes = null;
    @SerializedName("is_icon_glyph")
    @Expose
    private Boolean isIconGlyph;
    @SerializedName("styles")
    @Expose
    private List<Style_> styles = null;
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
    private List<Category_> categories = null;
    @SerializedName("type")
    @Expose
    private String type;

    public List<VectorSize> getVectorSizes() {
        return vectorSizes;
    }

    public void setVectorSizes(List<VectorSize> vectorSizes) {
        this.vectorSizes = vectorSizes;
    }

    public Iconset getIconset() {
        return iconset;
    }

    public void setIconset(Iconset iconset) {
        this.iconset = iconset;
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

    public List<RasterSize> getRasterSizes() {
        return rasterSizes;
    }

    public void setRasterSizes(List<RasterSize> rasterSizes) {
        this.rasterSizes = rasterSizes;
    }

    public Boolean getIsIconGlyph() {
        return isIconGlyph;
    }

    public void setIsIconGlyph(Boolean isIconGlyph) {
        this.isIconGlyph = isIconGlyph;
    }

    public List<Style_> getStyles() {
        return styles;
    }

    public void setStyles(List<Style_> styles) {
        this.styles = styles;
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

    public List<Category_> getCategories() {
        return categories;
    }

    public void setCategories(List<Category_> categories) {
        this.categories = categories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
