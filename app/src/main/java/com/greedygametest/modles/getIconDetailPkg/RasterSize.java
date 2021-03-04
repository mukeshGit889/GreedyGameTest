
package com.greedygametest.modles.getIconDetailPkg;

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
