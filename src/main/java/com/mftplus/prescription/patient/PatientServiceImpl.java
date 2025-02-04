package com.mftplus.prescription.patient;

import com.mftplus.prescription.prescription.Prescription;
import com.mftplus.prescription.prescription.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PrescriptionRepository prescriptionRepository;

    public PatientServiceImpl(PatientRepository patientRepository, PrescriptionRepository prescriptionRepository) {
        this.patientRepository = patientRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);

    }

    @Override
    public void update(Patient patient) {
        patientRepository.save(patient);

    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);

    }

    @Override
    public void delete(Patient patient) {
        patientRepository.delete(patient);

    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> findByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    @Override
    public Patient findByPrescription(Prescription prescription) {
//        Prescription prescription1=prescriptionRepository.findById(prescription.getId()).orElse(null);
//        return patientRepository.findByPrescriptionList(prescription);

        Prescription prescription1 = prescriptionRepository.findById(prescription.getId()).orElse(null);
        if (prescription1 != null) {
            return patientRepository.findByPrescriptionList(prescription);
        } else {
            return null;
        }
    }
}
