package br.com.buildit.model;


import javax.persistence.*;

@Entity
@Table(name = "TB_DRIVER")
public class Driver extends Customer{

    @Column(name = "nr_driver_license")
    private Integer driverLicenseNumber;

    @OneToOne
    @JoinColumn(name = "nr_plate")
    private Vehicle vehicle;

    @OneToOne(mappedBy = "driver")
    private Order order;

    public Integer getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(Integer driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
