package mrodriguezdev.me.apitodomate.domain.ports.out;

import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;

public interface UserOutputPort {
    void create(UserDTO newUser);
    UserDTO findById(Long id);
    UserDTO findByUsername(String username);
}
