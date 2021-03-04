
package com.greedygametest.modles.getSetIconDetailPkg;

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

}
