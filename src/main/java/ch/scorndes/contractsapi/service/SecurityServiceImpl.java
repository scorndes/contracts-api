package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.model.User;
import ch.scorndes.contractsapi.repository.UserRepository;
import ch.scorndes.contractsapi.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("securityService")
public class SecurityServiceImpl implements SecurityService {

    private final UserRepository userRepository;

    SecurityServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UUID getCurrentUserId() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication != null ? authentication.getName() : null;
        return this.userRepository.findByUsername(username)
                .map(User::getId)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable : " + username));
    }

    public boolean canAccessUser(UUID requestedId, Authentication authentication) {
        if (authentication == null || !(authentication.getPrincipal() instanceof UserDetailsImpl userDetails)) {
            return false;
        }
        return userDetails.hasRole("ROLE_ADMIN") || userDetails.getId().equals(requestedId);
    }

}
