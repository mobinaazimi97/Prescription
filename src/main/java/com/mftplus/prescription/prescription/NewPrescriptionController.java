package com.mftplus.prescription.prescription;

import com.mftplus.prescription.patient.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/newPrescriptions")
public class NewPrescriptionController {
    private final PrescriptionService prescriptionService;

    public NewPrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }
    @GetMapping
    public String getPrescriptions(Model model) {
        model.addAttribute("prescription", new Prescription());
        model.addAttribute("prescriptions", prescriptionService.findAll());
        return "newPrescriptions";
    }

    @PostMapping
    public String prescriptionAdd(Prescription prescription) {
        prescriptionService.save(prescription);
        System.out.println("prescription Saved"+prescription);
        return "redirect:/newPrescriptions";

    }

//    @PostMapping
//    @ResponseBody
//    public Prescription addPrescription(@RequestBody Prescription prescription) {
//        try {
//            prescriptionService.save(prescription);
//            System.out.println(("Prescription added: " + prescription));
//            return prescription;

            //-------------------------------------
//            return ResponseEntity.ok(
//                    Map.of(
//                                    "info", "Customer added",
//                                    "data", customer.toString())
//                            .toString());
            //-------------------------------------
//        } catch (Exception e) {
//            System.out.println((e.getMessage()));
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
