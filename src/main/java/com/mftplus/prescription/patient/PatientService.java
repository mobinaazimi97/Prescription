package com.mftplus.prescription.patient;

import com.mftplus.prescription.prescription.Prescription;

import java.util.List;

public interface PatientService {

    void save(Patient patient);
    void update(Patient patient);
    void deleteById(Long id);
    void delete(Patient patient);
    Patient findById(Long id);
    List<Patient> findAll();
    List<Patient> findByLastName(String lastName);
    Patient findByPrescription(Prescription prescription);


}
