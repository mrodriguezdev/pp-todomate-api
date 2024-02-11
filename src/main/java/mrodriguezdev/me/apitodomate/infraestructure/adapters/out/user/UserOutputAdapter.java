package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apitodomate.domain.model.orm.User;
import mrodriguezdev.me.apitodomate.infraestructure.adapters.out.repository.UserRepository;
import mrodriguezdev.me.apitodomate.infraestructure.ports.out.UserOutputPort;

import java.util.Optional;

@ApplicationScoped
public class UserOutputAdapter implements UserOutputPort {

    @Inject
    UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findByIdOptional(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
