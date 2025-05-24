package ch.scorndes.contractsapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    @PostMapping
    public String createPortfolio() {
        // TODO: Créer un portefeuille
        return "Portfolio created";
    }

    @GetMapping("/{id}")
    public String getPortfolio(@PathVariable String id) {
        // TODO: Récupérer un portefeuille
        return "Portfolio " + id;
    }

    @PutMapping("/{id}")
    public String updatePortfolio(@PathVariable String id) {
        // TODO: Mettre à jour un portefeuille
        return "Portfolio updated";
    }

    @DeleteMapping("/{id}")
    public String deletePortfolio(@PathVariable String id) {
        // TODO: Supprimer un portefeuille
        return "Portfolio deleted";
    }

    @GetMapping("/{id}/simulation")
    public String simulatePortfolio(@PathVariable String id) {
        // TODO: Simuler la performance
        return "Simulation for portfolio " + id;
    }
}