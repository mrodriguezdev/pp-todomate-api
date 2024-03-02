package mrodriguezdev.me.apitodomate.infraestructure.configuration;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "todomate")
public interface TodoMateApi {

    Jwt jwt();

    interface Jwt {
        String issuer();
        String publicKeyLocation();
        String privateKeyLocation();
    }
}
