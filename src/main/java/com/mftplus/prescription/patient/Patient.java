package com.mftplus.prescription.patient;

import com.mftplus.prescription.prescription.Prescription;
import jakarta.persistence.*;

import java.util.List;


//@NoArgsConstructor
//@Getter
//@Setter
//@SuperBuilder
//@ToString

@Entity(name = "patientEntity")
@Table(name = "patient_table")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String sickness;//نام بیماری

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
            foreignKey = @ForeignKey(name = "prescription_fk"),
            name = "patient_prescriptions")
    private List<Prescription> prescriptionList;
//    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
//    private List<Prescription> prescriptions;


    public Patient(Long id, String firstName, String lastName, String sickness, List<Prescription> prescriptionList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sickness = sickness;
        this.prescriptionList = prescriptionList;
    }

    public Patient(String firstName, String lastName, String sickness, List<Prescription> prescriptionList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sickness = sickness;
        this.prescriptionList = prescriptionList;
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public Patient setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Patient setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Patient setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getSickness() {
        return sickness;
    }

    public Patient setSickness(String sickness) {
        this.sickness = sickness;
        return this;
    }

    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public Patient setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
        return this;
    }
}

