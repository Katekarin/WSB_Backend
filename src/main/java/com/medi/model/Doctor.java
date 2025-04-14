package com.medi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String doctorNumber;
    private String specialization;

    public String getSpecialization() {
        return specialization;
    }

    public Address getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Jednostronna relacja od strony właściciela (Doctor posiada Address)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;

    // Gettery, settery, konstruktor
    public Doctor() {}

    // Gettery/settery pomińmy tutaj dla czytelności, ale oczywiście je dodaj
}
