package server.domain;

import javax.validation.constraints.NotNull;

public class Beer {

    private int id;
    @NotNull
    private String brand;
    private String name;
    private double alcoholPercentage;

    public Beer() {
    }

    public Beer(int id, String brand, String name, double alcoholPercentage) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.alcoholPercentage = alcoholPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", alcoholPercentage=" + alcoholPercentage +
                '}';
    }
}
