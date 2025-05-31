package ch.scorndes.contractsapi.controller;

import ch.scorndes.contractsapi.dto.AddressDto;
import ch.scorndes.contractsapi.dto.PortfolioDto;
import ch.scorndes.contractsapi.dto.UserDto;
import ch.scorndes.contractsapi.security.UserDetailsImpl;
import ch.scorndes.contractsapi.service.AddressService;
import ch.scorndes.contractsapi.service.PortfolioService;
import ch.scorndes.contractsapi.service.SecurityService;
import ch.scorndes.contractsapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PortfolioService portfolioService;
    private final AddressService addressService;

    public UserController(UserService userService, PortfolioService portfolioService, AddressService addressService) {
        this.userService = userService;
        this.portfolioService = portfolioService;
        this.addressService = addressService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userService.getUserWithMainAddress(userDetails.getId())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PreAuthorize("@securityService.canAccessUser(#id, authentication)")
    @GetMapping("/{id}/portfolios")
    public List<PortfolioDto> getUserPortfolios(@PathVariable UUID id) {
        return portfolioService.getPortfolioForUser(id);
    }

    @PreAuthorize("@securityService.canAccessUser(#id, authentication)")
    @GetMapping("/{id}/adresses")
    public List<AddressDto> getUserAddresses(@PathVariable UUID id) {
        return addressService.getAddressesByUserId(id);
    }

}