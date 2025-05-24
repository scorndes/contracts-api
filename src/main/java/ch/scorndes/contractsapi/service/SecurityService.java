package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.model.User;
import ch.scorndes.contractsapi.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SecurityService {

    private final UserRepository userRepository;

    SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID getCurrentUserId() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication != null ? authentication.getName() : null;
        return this.userRepository.findByUsername(username)
                .map(User::getId)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable : " + username));
    }

}
