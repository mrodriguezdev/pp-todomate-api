package mrodriguezdev.me.apitodomate.domain.model.user;

import jakarta.validation.constraints.NotNull;

public class UserDTO {
    public Long id;
    @NotNull(message = "Username cannot be null")
    public String username;
    @NotNull(message = "Password cannot be null")
    public String password;
}
