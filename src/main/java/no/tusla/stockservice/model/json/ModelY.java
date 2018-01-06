package no.tusla.stockservice.model.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "season",
        "tiremodel",
        "price"
})
public class ModelY {

    @JsonProperty("season")
    private String season;
    @JsonProperty("tiremodel")
    private String tiremodel;
    @JsonProperty("price")
    private String price;

    /**
     * No args constructor for use in serialization
     */
    public ModelY() {
    }

    /**
     * @param price
     * @param season
     * @param tiremodel
     */
    public ModelY(String season, String tiremodel, String price) {
        super();
        this.season = season;
        this.tiremodel = tiremodel;
        this.price = price;
    }

    @JsonProperty("season")
    public String getSeason() {
        return season;
    }

    @JsonProperty("season")
    public void setSeason(String season) {
        this.season = season;
    }

    @JsonProperty("tiremodel")
    public String getTiremodel() {
        return tiremodel;
    }

    @JsonProperty("tiremodel")
    public void setTiremodel(String tiremodel) {
        this.tiremodel = tiremodel;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

}