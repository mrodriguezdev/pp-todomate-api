package mrodriguezdev.me.apitodomate.domain.ports.out;

import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;
import mrodriguezdev.me.apitodomate.infraestructure.entities.User;

import java.util.Optional;

public interface UserOutputPort {
    void create(User newUser);
    Optional<User> findById(Long id);
    UserDTO findByUsername(String username);
}
