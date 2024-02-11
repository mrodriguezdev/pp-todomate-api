package mrodriguezdev.me.apitodomate.infraestructure.ports.out;

import mrodriguezdev.me.apitodomate.domain.model.orm.User;

import java.util.Optional;

public interface UserOutputPort {
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
}
