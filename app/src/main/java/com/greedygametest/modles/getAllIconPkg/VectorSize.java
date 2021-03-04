
package com.greedygametest.modles.getAllIconPkg;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VectorSize {

    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("size_height")
    @Expose
    private Integer sizeHeight;
    @SerializedName("formats")
    @Expose
    private List<Format> formats = null;
    @SerializedName("size_width")
    @Expose
    private Integer sizeWidth;
    @SerializedName("target_sizes")
    @Expose
    private List<List<Integer>> targetSizes = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VectorSize() {
    }

    /**
     * 
     * @param formats
     * @param sizeWidth
     * @param targetSizes
     * @param size
     * @param sizeHeight
     */
    public VectorSize(Integer size, Integer sizeHeight, List<Format> formats, Integer sizeWidth, List<List<Integer>> targetSizes) {
        super();
        this.size = size;
        this.sizeHeight = sizeHeight;
        this.formats = formats;
        this.sizeWidth = sizeWidth;
        this.targetSizes = targetSizes;
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

    public List<Format> getFormats() {
        return formats;
    }

    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }

    public Integer getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(Integer sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public List<List<Integer>> getTargetSizes() {
        return targetSizes;
    }

    public void setTargetSizes(List<List<Integer>> targetSizes) {
        this.targetSizes = targetSizes;
    }

}
