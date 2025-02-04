package com.mftplus.prescription.patient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/newPatients")
public class NewPatientController {
    private final PatientService patientService;

    public NewPatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String getPatients(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", patientService.findAll());

        return "newPatients";
    }
    @PostMapping
    public String patientAdd(Patient patient) {
        patientService.save(patient);
        System.out.println("patient Saved"+patient);
        return "redirect:/newPatients";

    }

//    @PostMapping
//    @ResponseBody
//    public Patient addPatient(@RequestBody Patient patient) {
//        try {
//            patientService.save(patient);
//            System.out.println(("Patient added: " + patient));
//            return patient;

            //-------------------------------------
//            return ResponseEntity.ok(
//                    Map.of(
//                                    "info", "Customer added",
//                                    "data", customer.toString())
//                            .toString());
// ----------------------------------------------
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;

            //-------------------------------------
//            return ResponseEntity.badRequest().body(
//                    Map.of(
//                                    "error", "Customer not added",
//                                    "message", e.getMessage())
//                            .toString()
//            );
            //-------------------------------------

//        }
//    }
}
