package mrodriguezdev.me.apitodomate.infraestructure.adapters.in.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;
import mrodriguezdev.me.apitodomate.infraestructure.ports.in.UserInputPort;

@Path("user")
public class UserController {

    @Inject
    UserInputPort userInputPort;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO create(UserDTO userDTO) {
        return this.userInputPort.create(userDTO);
    }
}
