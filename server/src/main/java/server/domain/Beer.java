package server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beers", schema="devdev")
public class Beer {

    @Id
    private Integer id;
    private String brand;
    private String name;

    @Column(name = "alchohol_percentage")
    private double alcohol_percentage;

    public Beer() {
    }

    public Beer(Integer id, String brand, String name, double alcohol_percentage) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.alcohol_percentage = alcohol_percentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public double getAlcohol_percentage() {
        return alcohol_percentage;
    }

    public void setAlcohol_percentage(double alcohol_percentage) {
        this.alcohol_percentage = alcohol_percentage;
    }
}
