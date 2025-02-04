package com.mftplus.prescription.prescription;

import com.mftplus.prescription.patient.Patient;
import com.mftplus.prescription.patient.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;

    }

    @Override
    public void save(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    @Override
    public void update(Prescription prescription) {
        prescriptionRepository.save(prescription);

    }

    @Override
    public void deleteById(Long id) {
        prescriptionRepository.deleteById(id);

    }

    @Override
    public void delete(Prescription prescription) {
        prescriptionRepository.delete(prescription);

    }

    @Override
    public Prescription findById(Long id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }
}
