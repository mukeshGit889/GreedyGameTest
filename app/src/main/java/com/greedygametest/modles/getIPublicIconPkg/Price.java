
package com.greedygametest.modles.getIPublicIconPkg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("license")
    @Expose
    private License license;
    @SerializedName("price")
    @Expose
    private Integer price;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Price() {
    }

    /**
     * 
     * @param license
     * @param price
     * @param currency
     */
    public Price(String currency, License license, Integer price) {
        super();
        this.currency = currency;
        this.license = license;
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
