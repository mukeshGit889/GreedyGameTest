
package com.greedygametest.modles.getAllIconPkg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Format {

    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("download_url")
    @Expose
    private String downloadUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Format() {
    }

    /**
     * 
     * @param format
     * @param downloadUrl
     */
    public Format(String format, String downloadUrl) {
        super();
        this.format = format;
        this.downloadUrl = downloadUrl;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

}
