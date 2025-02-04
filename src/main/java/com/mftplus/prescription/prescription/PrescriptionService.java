package com.mftplus.prescription.prescription;


import java.util.List;

public interface PrescriptionService {
    void save(Prescription prescription);

    void update(Prescription prescription);

    void deleteById(Long id);

    void delete(Prescription prescription);

    Prescription findById(Long id);

    List<Prescription> findAll();

}
