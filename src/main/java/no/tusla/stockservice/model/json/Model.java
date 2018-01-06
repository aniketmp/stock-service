package no.tusla.stockservice.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Model X",
        "Model Y",
        "Model Z"
})
public class Model {

    @JsonProperty("Model X")
    private List<ModelX> modelX;
    @JsonProperty("Model Y")
    private List<ModelY> modelY;
    @JsonProperty("Model Z")
    private List<ModelZ> modelZ;

    /**
     * No args constructor for use in serialization
     */
    public Model() {
    }

    /**
     * @param modelX
     * @param modelZ
     * @param modelY
     */
    public Model(List<ModelX> modelX, List<ModelY> modelY, List<ModelZ> modelZ) {
        super();
        this.modelX = modelX;
        this.modelY = modelY;
        this.modelZ = modelZ;
    }

    @JsonProperty("Model X")
    public List<ModelX> getModelX() {
        return modelX;
    }

    @JsonProperty("Model X")
    public void setModelX(List<ModelX> modelX) {
        this.modelX = modelX;
    }

    @JsonProperty("Model Y")
    public List<ModelY> getModelY() {
        return modelY;
    }

    @JsonProperty("Model Y")
    public void setModelY(List<ModelY> modelY) {
        this.modelY = modelY;
    }

    @JsonProperty("Model Z")
    public List<ModelZ> getModelZ() {
        return modelZ;
    }

    @JsonProperty("Model Z")
    public void setModelZ(List<ModelZ> modelZ) {
        this.modelZ = modelZ;
    }

}