package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mrodriguezdev.me.apitodomate.domain.exceptions.NotFoundException;
import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;
import mrodriguezdev.me.apitodomate.infraestructure.entities.User;
import mrodriguezdev.me.apitodomate.infraestructure.mapper.UserMapper;
import mrodriguezdev.me.apitodomate.infraestructure.repositories.UserRepository;
import mrodriguezdev.me.apitodomate.domain.ports.out.UserOutputPort;

import java.util.Optional;

@ApplicationScoped
public class UserOutputAdapter implements UserOutputPort {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Override
    @Transactional
    public void create(User newUser) {
        this.userRepository.persist(newUser);
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findByIdOptional(id);
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return this.userMapper.toDTO(user);
    }
}
