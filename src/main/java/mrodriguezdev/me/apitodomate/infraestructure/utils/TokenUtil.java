package mrodriguezdev.me.apitodomate.infraestructure.utils;

import io.smallrye.jwt.build.Jwt;
import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;
import org.eclipse.microprofile.jwt.Claims;
import java.time.Duration;
import java.time.Instant;

public class TokenUtil {

    public static String generateToken(UserDTO user, String issuer) {
        Long currentTimeInSecs = currentTimeInSecs();
        Long duration = durationTimeInSecs();

        return Jwt.issuer(issuer)
                .subject(user.username)
                .claim(Claims.preferred_username.name(), user.username)
                .issuedAt(currentTimeInSecs)
                .expiresAt(currentTimeInSecs + duration)
                .sign();
    }

    private static Long currentTimeInSecs() {
        return Instant.now().getEpochSecond();
    }

    private static Long durationTimeInSecs() {
        return Duration.ofHours(2).toSeconds();
    }
}
