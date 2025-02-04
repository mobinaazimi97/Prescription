package com.mftplus.prescription.prescription;

import com.mftplus.prescription.patient.Patient;
import jakarta.persistence.*;

//@NoArgsConstructor
//@Getter
//@Setter
//@SuperBuilder
//@ToString

@Entity(name = "prescriptionEntity")
@Table(name = "prescription_table")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public Prescription(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Prescription(String description) {
        this.description = description;
    }

    public Prescription() {
    }

    public Long getId() {
        return id;
    }

    public Prescription setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Prescription setDescription(String description) {
        this.description = description;
        return this;
    }
}
