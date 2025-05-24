package ch.scorndes.contractsapi.controller;

import ch.scorndes.contractsapi.dto.PortfolioDto;
import ch.scorndes.contractsapi.dto.UserDto;
import ch.scorndes.contractsapi.service.PortfolioService;
import ch.scorndes.contractsapi.service.SecurityService;
import ch.scorndes.contractsapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PortfolioService portfolioService;
    private final SecurityService securityService;

    public UserController(UserService userService, PortfolioService portfolioService, SecurityService securityService) {
        this.userService = userService;
        this.portfolioService = portfolioService;
        this.securityService = securityService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser() {
        return userService.getUser(securityService.getCurrentUserId())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/portfolios")
    public List<PortfolioDto> getUserPortfolios(@PathVariable UUID id) {
        return portfolioService.getPortfolioForUser(id);
    }
}