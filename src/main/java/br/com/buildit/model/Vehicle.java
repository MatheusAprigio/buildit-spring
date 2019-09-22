package br.com.buildit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TB_VEHICLE")
@SequenceGenerator(name = "vehicle", allocationSize = 1, sequenceName = "SQ_VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(generator = "vehicle",strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_vehicle")
    @JsonIgnore
    private Integer id;

    @Column(name = "nr_plate", unique = true, nullable = false, length = 15)
    private String plateNumber;

    @Column(name = "ds_model", nullable = false)
    private String model;

    @Column(name = "dt_release_year", nullable = false, length = 4)
    private Integer releaseYear;

    @Column(name = "ds_color", nullable = false)
    private String color;

    @OneToOne(mappedBy = "vehicle")
    @JsonIgnore
    private Driver driver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle(String plateNumber, String model, Integer releaseYear, String color, Driver driver) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.releaseYear = releaseYear;
        this.color = color;
        this.driver = driver;
    }

    public Vehicle(){

    }
}
