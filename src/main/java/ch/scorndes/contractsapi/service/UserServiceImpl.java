package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.dto.UserDto;
import ch.scorndes.contractsapi.mapper.UserMapper;
import ch.scorndes.contractsapi.model.User;
import ch.scorndes.contractsapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<UserDto> getUserWithMainAddress(UUID userId) {
        return this.userRepository.findByIdWithMainAdresses(userId).map(userMapper::toDto);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return this.userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

}
