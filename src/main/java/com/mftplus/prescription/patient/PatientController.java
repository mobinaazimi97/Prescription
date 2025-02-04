package com.mftplus.prescription.patient;

import com.mftplus.prescription.prescription.Prescription;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String getPatients(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", patientService.findAll());
        return "patients";
    }

    @GetMapping("/{id}")
    public String getPatientById(@PathVariable Long id, Model model) {
        model.addAttribute("patient", patientService.findById(id));
        return "editPatients";
    }

    @GetMapping("/lastName/{lastName}")
    public String getPatientByLastName(@PathVariable String lastName, Model model) {
        model.addAttribute("patient", patientService.findByLastName(lastName));
        System.out.println("lastName found :" + lastName);
        return "editPatients";
    }

    @GetMapping("/presId/{presId}")
    public String getPatientByPresId(@PathVariable Long presId, Model model, Prescription prescription) {
        model.addAttribute("patientPrescription", patientService.findByPrescription(prescription));
        return "redirect:/patients";
    }


//    @GetMapping("/prescriptionId/{prescriptionId}")
//    public String getPrescriptionById(@PathVariable Long prescriptionId, Model model, Prescription prescription) {
//        model.addAttribute("patient", patientService.findByPrescriptionList(prescription));
//        return "redirect:/patients";
//    }


    @PostMapping
    public String savePatient(Patient patient) {
        patientService.save(patient);
        System.out.println("patient added" + patient.toString());
//        log.info("Saved Patient {}", patient);
        return "redirect:/patients";
    }

    @PutMapping
    public String updatePatient(Patient patient) {
        patientService.update(patient);
//        log.info("Updated Patient {}", patient);
        return "redirect:/patients";
    }

    @DeleteMapping("/{id}")
    public String deletePatientById(@PathVariable Long id) {
        patientService.deleteById(id);
        return "redirect:/patients";
    }

    @DeleteMapping("/lastName/{lastName}")
    public String deletePatientByLastName(@PathVariable String lastName) {
        patientService.delete(patientService.findByLastName(lastName).get(0));
        return "redirect:/patients";
    }
}

