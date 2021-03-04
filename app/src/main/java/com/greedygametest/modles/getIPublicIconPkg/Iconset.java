
package com.greedygametest.modles.getIPublicIconPkg;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Iconset {

    @SerializedName("are_all_icons_glyph")
    @Expose
    private Boolean areAllIconsGlyph;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("styles")
    @Expose
    private List<Object> styles = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("prices")
    @Expose
    private List<Price> prices = null;
    @SerializedName("iconset_id")
    @Expose
    private Integer iconsetId;
    @SerializedName("icons_count")
    @Expose
    private Integer iconsCount;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("is_premium")
    @Expose
    private Boolean isPremium;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Iconset() {
    }

    /**
     * 
     * @param identifier
     * @param areAllIconsGlyph
     * @param iconsCount
     * @param publishedAt
     * @param author
     * @param iconsetId
     * @param name
     * @param styles
     * @param isPremium
     * @param categories
     * @param prices
     * @param type
     */
    public Iconset(Boolean areAllIconsGlyph, Author author, List<Object> styles, String name, List<Price> prices, Integer iconsetId, Integer iconsCount, String identifier, String publishedAt, Boolean isPremium, List<Object> categories, String type) {
        super();
        this.areAllIconsGlyph = areAllIconsGlyph;
        this.author = author;
        this.styles = styles;
        this.name = name;
        this.prices = prices;
        this.iconsetId = iconsetId;
        this.iconsCount = iconsCount;
        this.identifier = identifier;
        this.publishedAt = publishedAt;
        this.isPremium = isPremium;
        this.categories = categories;
        this.type = type;
    }

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

    public List<Object> getStyles() {
        return styles;
    }

    public void setStyles(List<Object> styles) {
        this.styles = styles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
