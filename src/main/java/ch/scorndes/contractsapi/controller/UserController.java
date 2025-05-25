package ch.scorndes.contractsapi.controller;

import ch.scorndes.contractsapi.dto.AddressDto;
import ch.scorndes.contractsapi.dto.PortfolioDto;
import ch.scorndes.contractsapi.dto.UserDto;
import ch.scorndes.contractsapi.service.AddressService;
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
    private final AddressService addressService;
    private final SecurityService securityService;

    public UserController(UserService userService, PortfolioService portfolioService, AddressService addressService, SecurityService securityService) {
        this.userService = userService;
        this.portfolioService = portfolioService;
        this.addressService = addressService;
        this.securityService = securityService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser() {
        return userService.getUserWithMainAddress(securityService.getCurrentUserId())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/portfolios")
    public List<PortfolioDto> getUserPortfolios(@PathVariable UUID id) {
        return portfolioService.getPortfolioForUser(id);
    }

    @GetMapping("/{id}/adresses")
    public List<AddressDto> getUserAddresses(@PathVariable UUID id) {
        return addressService.getAddressesByUserId(id);
    }

}