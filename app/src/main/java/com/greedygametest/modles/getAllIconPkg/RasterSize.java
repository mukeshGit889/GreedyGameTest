
package com.greedygametest.modles.getAllIconPkg;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RasterSize {

    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("size_height")
    @Expose
    private Integer sizeHeight;
    @SerializedName("formats")
    @Expose
    private List<Format_> formats = null;
    @SerializedName("size_width")
    @Expose
    private Integer sizeWidth;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RasterSize() {
    }

    /**
     * 
     * @param formats
     * @param sizeWidth
     * @param size
     * @param sizeHeight
     */
    public RasterSize(Integer size, Integer sizeHeight, List<Format_> formats, Integer sizeWidth) {
        super();
        this.size = size;
        this.sizeHeight = sizeHeight;
        this.formats = formats;
        this.sizeWidth = sizeWidth;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(Integer sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public List<Format_> getFormats() {
        return formats;
    }

    public void setFormats(List<Format_> formats) {
        this.formats = formats;
    }

    public Integer getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(Integer sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

}
