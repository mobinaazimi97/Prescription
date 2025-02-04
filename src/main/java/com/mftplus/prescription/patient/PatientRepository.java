package com.mftplus.prescription.patient;

import com.mftplus.prescription.prescription.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient>findByLastName(String lastName);
    Patient findByPrescriptionList(Prescription prescription);

}
