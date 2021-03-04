
package com.greedygametest.modles.getIconDetailPkg;

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
