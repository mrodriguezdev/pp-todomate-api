package mrodriguezdev.me.apitodomate.domain.ports.in;

import mrodriguezdev.me.apitodomate.domain.model.auth.AuthRequestDTO;
import mrodriguezdev.me.apitodomate.domain.model.auth.AuthResponseDTO;

public interface AuthInputPort {
    AuthResponseDTO login(AuthRequestDTO authRequestDTO);
}
