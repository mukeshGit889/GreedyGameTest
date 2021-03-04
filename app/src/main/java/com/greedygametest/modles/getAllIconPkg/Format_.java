
package com.greedygametest.modles.getAllIconPkg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Format_ {

    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("preview_url")
    @Expose
    private String previewUrl;
    @SerializedName("download_url")
    @Expose
    private String downloadUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Format_() {
    }

    /**
     * 
     * @param previewUrl
     * @param format
     * @param downloadUrl
     */
    public Format_(String format, String previewUrl, String downloadUrl) {
        super();
        this.format = format;
        this.previewUrl = previewUrl;
        this.downloadUrl = downloadUrl;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

}
