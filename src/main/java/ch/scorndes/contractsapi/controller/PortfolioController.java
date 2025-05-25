package ch.scorndes.contractsapi.controller;

import ch.scorndes.contractsapi.dto.PortfolioDto;
import ch.scorndes.contractsapi.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    private final PortfolioService portfolioService;

    private PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

//    @PostMapping
//    public ResponseEntity<PortfolioDto> createPortfolio() {
//        return "Portfolio created";
//    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioDto> getPortfolios(@PathVariable UUID id) {
        return this.portfolioService.getSpecificPortfolio(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioDto> updatePortfolio(@RequestBody PortfolioDto portfolio) {
        return this.portfolioService.updatePortefolio(portfolio).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PortfolioDto> deletePortfolio(@PathVariable UUID id) {
        if (portfolioService.deletePortefolio(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

//    @GetMapping("/{id}/simulation")
//    public String simulatePortfolio(@PathVariable String id) {
//        // TODO: Simuler la performance
//        return "Simulation for portfolio " + id;
//    }
}