package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mrodriguezdev.me.apitodomate.domain.exceptions.NotFoundException;
import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;
import mrodriguezdev.me.apitodomate.domain.ports.out.UserOutputPort;

@ApplicationScoped
public class UserOutputAdapter implements UserOutputPort {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Override
    @Transactional
    public void create(UserDTO newUser) {
        this.userRepository.persist(this.userMapper.toEntity(newUser));
    }

    @Override
    public UserDTO findById(Long id) {
        return this.userRepository
                .findByIdOptional(id)
                .map(user -> this.userMapper.toDTO(user))
                .orElseThrow(() -> new NotFoundException(String.format("User with ID %s not found", id)));
    }

    @Override
    public UserDTO findByUsername(String username) {
        return this.userRepository
                .findByUsername(username)
                .map(user -> this.userMapper.toDTO(user))
                .orElse(null);
    }
}
