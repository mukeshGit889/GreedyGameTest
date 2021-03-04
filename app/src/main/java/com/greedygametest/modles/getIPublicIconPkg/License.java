
package com.greedygametest.modles.getIPublicIconPkg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class License {

    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("license_id")
    @Expose
    private Integer licenseId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public License() {
    }

    /**
     * 
     * @param scope
     * @param name
     * @param licenseId
     * @param url
     */
    public License(String scope, Integer licenseId, String name, String url) {
        super();
        this.scope = scope;
        this.licenseId = licenseId;
        this.name = name;
        this.url = url;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Integer licenseId) {
        this.licenseId = licenseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
