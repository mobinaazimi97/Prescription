package com.mftplus.prescription.prescription;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping
    public String getPrescriptions(Model model) {
        model.addAttribute("prescription", new Prescription());
        System.out.println("found prescription"+prescriptionService.findAll());
        model.addAttribute("prescriptions", prescriptionService.findAll());
        return "prescriptions";
    }

    @GetMapping("/{id}")
    public String getPrescriptionById(Model model, @PathVariable Long id) {
        model.addAttribute("prescription", prescriptionService.findById(id));
        System.out.println("prescription found by id"+prescriptionService.findById(id));
        return "editPrescriptions";
    }

    @PostMapping
    public String addPrescription(Prescription prescription) {
        prescriptionService.save(prescription);
        System.out.println("saved prescription : "+prescription );
        return "redirect:/prescriptions";
    }

    @PutMapping
    public String updatePrescription(Prescription prescription) {
        prescriptionService.update(prescription);
        System.out.println("edited prescription : "+prescription );
        return "redirect:/prescriptions";
    }

    @DeleteMapping("/{id}")
    public String deletePrescriptionById(@PathVariable Long id) {
        prescriptionService.deleteById(id);
        return "redirect:/prescriptions";
    }


}
