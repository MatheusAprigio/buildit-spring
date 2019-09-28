package br.com.buildit.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_DRIVER")
@AttributeOverride(name = "id", column = @Column(name = "cd_customer"))
public class Driver extends AppUser{

    @Column(name = "nr_driver_license")
    private String driverLicenseNumber;

    @OneToOne
    @JoinColumn(name = "cd_vehicle")
    private Vehicle vehicle;

    @OneToOne(mappedBy = "driver")
    private Order order;

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver(String driverLicenseNumber, Vehicle vehicle, Order order) {
        this.driverLicenseNumber = driverLicenseNumber;
        this.vehicle = vehicle;
        this.order = order;
    }

    public Driver() {
    }
}
