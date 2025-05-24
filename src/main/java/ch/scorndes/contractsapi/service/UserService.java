package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.dto.AddressDto;
import ch.scorndes.contractsapi.dto.UserDto;
import ch.scorndes.contractsapi.model.Address;
import ch.scorndes.contractsapi.model.User;
import ch.scorndes.contractsapi.repository.AddressRepository;
import ch.scorndes.contractsapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public Optional<UserDto> getUser(UUID userId) {
        return this.userRepository.findById(userId).map(user -> {
            List<AddressDto> addresses = this.addressRepository.findByUserId(userId).stream()
                    .map(address -> new AddressDto(address.getId(),
                            address.isPrincipale(),
                            userId,
                            address.getNumero(),
                            address.getLigne1(),
                            address.getLigne2(),
                            address.getCodePostal(),
                            address.getVille(),
                            address.getPays()))
                    .collect(Collectors.toList());
            return new UserDto(userId, user.getUsername(), user.getEmail(), addresses);
        });
    }

}
