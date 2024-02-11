package mrodriguezdev.me.apitodomate.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apitodomate.domain.exceptions.BadRequestException;
import mrodriguezdev.me.apitodomate.domain.exceptions.InternalServerErrorException;
import mrodriguezdev.me.apitodomate.domain.exceptions.NotFoundException;
import mrodriguezdev.me.apitodomate.domain.model.auth.AuthRequestDTO;
import mrodriguezdev.me.apitodomate.domain.model.auth.AuthResponseDTO;
import mrodriguezdev.me.apitodomate.domain.model.orm.User;
import mrodriguezdev.me.apitodomate.infraestructure.ports.in.AuthInputPort;
import mrodriguezdev.me.apitodomate.infraestructure.ports.out.UserOutputPort;
import mrodriguezdev.me.apitodomate.infraestructure.utils.ValidationUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class AuthUseCase implements AuthInputPort {

    private final Logger logger = Logger.getLogger(AuthUseCase.class.getName());

    @Inject
    UserOutputPort userOutputPort;

    @Override
    public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {
        try {
            ValidationUtil.validar(authRequestDTO);
            User user = this.userOutputPort.findByUsername(authRequestDTO.username)
                    .orElseThrow(() -> new NotFoundException("User not found."));

            if(!user.getPassword().equals(authRequestDTO.password)) throw new BadRequestException("The provided password does not match the user's stored password.");

            return new AuthResponseDTO();
        } catch (BadRequestException bre) {
            throw new BadRequestException(bre.getMessage());
        } catch (NotFoundException nfe) {
            throw new NotFoundException(nfe.getMessage());
        } catch (Exception e) {
            this.logger.log(Level.SEVERE, "An internal server error occurred. Details: {0}", e.getMessage());
            throw new InternalServerErrorException("Our server encountered an issue. Please contact the administrator for assistance.");
        }
    }
}
