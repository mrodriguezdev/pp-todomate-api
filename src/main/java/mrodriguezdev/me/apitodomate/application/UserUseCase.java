package mrodriguezdev.me.apitodomate.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apitodomate.domain.exceptions.BadRequestException;
import mrodriguezdev.me.apitodomate.domain.exceptions.InternalServerErrorException;
import mrodriguezdev.me.apitodomate.domain.mapper.UserMapper;
import mrodriguezdev.me.apitodomate.domain.model.orm.User;
import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;
import mrodriguezdev.me.apitodomate.infraestructure.ports.in.UserInputPort;
import mrodriguezdev.me.apitodomate.infraestructure.ports.out.UserOutputPort;
import mrodriguezdev.me.apitodomate.infraestructure.utils.ValidationUtil;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class UserUseCase implements UserInputPort {

    private final Logger logger = Logger.getLogger(UserUseCase.class.getName());

    @Inject
    UserOutputPort userOutputPort;

    @Inject
    UserMapper userMapper;

    @Override
    public UserDTO create(UserDTO userDTO) {
        try {
            ValidationUtil.validar(userDTO);
            boolean isUserAlreadyExists = this.findByUsername(userDTO.username)
                    .isPresent();

            if(isUserAlreadyExists)
                throw new BadRequestException(String.format("The username '%s' is already taken. Please choose a different username.", userDTO.username));

            User newUser = this.userMapper.toEntity(userDTO);
            this.userOutputPort.create(newUser);
            return this.userMapper.toDTO(newUser);
        } catch (BadRequestException bre) {
            throw new BadRequestException(bre.getMessage());
        } catch (Exception e) {
            this.logger.log(Level.SEVERE, "An internal server error occurred. Details: {0}", e.getMessage());
            throw new InternalServerErrorException("Our server encountered an issue. Please contact the administrator for assistance.");
        }
    }

    public Optional<User> findById(Long id) {
        return this.userOutputPort.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return this.userOutputPort.findByUsername(username);
    }
}
