package mrodriguezdev.me.apitodomate.domain.model.auth;

import jakarta.validation.constraints.NotNull;

public class AuthRequestDTO {
    @NotNull(message = "Username cannot be null")
    public String username;
    @NotNull(message = "Password cannot be null")
    public String password;
}
