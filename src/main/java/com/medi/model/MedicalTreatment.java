package com.medi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_treatment")
public class MedicalTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicalTreatment() {}

}
