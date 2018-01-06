package no.tusla.stockservice.model;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "season", nullable = false)
    private String season;

    @Column(name = "tire_model", nullable = false)
    private String tireModel;

    @Column(name = "price", nullable = false)
    private Double price;

    public Stock() {
    }

    public Stock(String model, String season, String tireModel, Double price) {
        this.model = model;
        this.season = season;
        this.tireModel = tireModel;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock [model=" + model + ", season=" + season + ", tireModel=" + tireModel + ", price=" + price + "]";
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTireModel() {
        return tireModel;
    }

    public void setTireModel(String tireModel) {
        this.tireModel = tireModel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}