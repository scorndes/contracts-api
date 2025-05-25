package ch.scorndes.contractsapi.mapper;

import ch.scorndes.contractsapi.model.User;

import java.util.UUID;

public interface UserIdMapperSupport {

    default User map(UUID userId) {
        User user = new User();
        user.setId(userId);
        return user;
    }

    default UUID map(User user) {
        return user.getId();
    }

}
