package mrodriguezdev.me.apitodomate.infraestructure.adapters.in.http;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mrodriguezdev.me.apitodomate.domain.model.auth.AuthRequestDTO;
import mrodriguezdev.me.apitodomate.domain.model.auth.AuthResponseDTO;
import mrodriguezdev.me.apitodomate.domain.ports.in.AuthInputPort;

@Path("auth")
public class AuthController {

    @Inject
    AuthInputPort authInputPort;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {
        return this.authInputPort.login(authRequestDTO);
    }
}
