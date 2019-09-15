package br.com.buildit.model;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "TB_VEHICLE")
@SequenceGenerator(name = "vehicle", allocationSize = 1, sequenceName = "SQ_VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(generator = "vehicle",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nr_plate", unique = true, nullable = false)
    private String plateNumber;

    @Column(name = "ds_model", nullable = false)
    private String model;

    @Column(name = "dt_release", nullable = false)
    private Integer releaseYear;

    @Column(name = "ds_color", nullable = false)
    private Color color;

    @OneToOne(mappedBy = "vehicle")
    private Driver driver;

}
