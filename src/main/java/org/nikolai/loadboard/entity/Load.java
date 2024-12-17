package org.nikolai.loadboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String origin;
    private String destination;
    private String cargoType;
    private Double weight;

    @Enumerated(EnumType.STRING)
    private LoadStatus status;
    @JsonIgnoreProperties("assignedLoads")
//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "carrier_id")
    private Carrier assignedCarrier;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LoadStatus getStatus() {
        return status;
    }

    public void setStatus(LoadStatus status) {
        this.status = status;
    }

    public Carrier getAssignedCarrier() {
        return assignedCarrier;
    }

    public void setAssignedCarrier(Carrier assignedCarrier) {
        this.assignedCarrier = assignedCarrier;
    }
}
