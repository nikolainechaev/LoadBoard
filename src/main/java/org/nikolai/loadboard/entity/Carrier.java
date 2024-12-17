package org.nikolai.loadboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mcNumber;
    private String phoneNumber;
    @JsonIgnoreProperties("assignedCarrier")
//    @JsonManagedReference
    @OneToMany(mappedBy = "assignedCarrier", cascade = CascadeType.ALL)
    private List<Load> assignedLoads = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMcNumber() {
        return mcNumber;
    }

    public void setMcNumber(String mcNumber) {
        this.mcNumber = mcNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Load> getAssignedLoads() {
        return assignedLoads;
    }

    public void setAssignedLoads(List<Load> assignedLoads) {
        this.assignedLoads = assignedLoads;
    }
}
