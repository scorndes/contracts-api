package ch.scorndes.contractsapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk-profiles")
public class RiskProfileController {

    @GetMapping
    public String getAllRiskProfiles() {
        // TODO: Renvoyer la liste des profils de risque
        return "List of risk profiles";
    }
}