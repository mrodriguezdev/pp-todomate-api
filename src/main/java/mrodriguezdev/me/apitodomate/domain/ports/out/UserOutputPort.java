package mrodriguezdev.me.apitodomate.domain.ports.out;

import mrodriguezdev.me.apitodomate.infraestructure.entities.User;

import java.util.Optional;

public interface UserOutputPort {
    void create(User newUser);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
}
