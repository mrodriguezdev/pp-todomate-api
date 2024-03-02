package mrodriguezdev.me.apitodomate.application;

import mrodriguezdev.me.apitodomate.infraestructure.common.UseCase;
import mrodriguezdev.me.apitodomate.domain.exceptions.BadRequestException;
import mrodriguezdev.me.apitodomate.domain.exceptions.InternalServerErrorException;
import mrodriguezdev.me.apitodomate.domain.exceptions.NotFoundException;
import mrodriguezdev.me.apitodomate.domain.model.auth.AuthRequestDTO;
import mrodriguezdev.me.apitodomate.domain.model.auth.AuthResponseDTO;
import mrodriguezdev.me.apitodomate.infraestructure.entities.User;
import mrodriguezdev.me.apitodomate.domain.ports.in.AuthInputPort;
import mrodriguezdev.me.apitodomate.infraestructure.utils.ValidationUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

@UseCase
public class AuthUseCase implements AuthInputPort {

    private final Logger logger = Logger.getLogger(AuthUseCase.class.getName());
    private final UserUseCase userUseCase;

    public AuthUseCase(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @Override
    public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {
        try {
            ValidationUtil.validar(authRequestDTO);

            User user = this.userUseCase.findByUsername(authRequestDTO.username)
                    .orElseThrow(() -> new NotFoundException("User not found."));

            if(!user.getPassword().equals(authRequestDTO.password)) throw new BadRequestException("The provided password does not match the user's stored password.");

            return this.createLoginResponse(user);
        } catch (BadRequestException bre) {
            throw new BadRequestException(bre.getMessage());
        } catch (NotFoundException nfe) {
            throw new NotFoundException(nfe.getMessage());
        } catch (Exception e) {
            this.logger.log(Level.SEVERE, "An internal server error occurred. Details: {0}", e.getMessage());
            throw new InternalServerErrorException("Our server encountered an issue. Please contact the administrator for assistance.");
        }
    }

    private AuthResponseDTO createLoginResponse(User user) {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.id = user.getId();
        authResponseDTO.username = user.getUsername();
        authResponseDTO.token = "token_test";
        return authResponseDTO;
    }
}
