package mrodriguezdev.me.apitodomate.domain.ports.in;

import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;

public interface UserInputPort {
    UserDTO create(UserDTO userDTO);
}
