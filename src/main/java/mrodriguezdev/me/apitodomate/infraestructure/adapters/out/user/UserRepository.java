package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.user;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Long> {

    public Optional<User> findByUsername(String username) {
        return find("username = ?1", username)
                .firstResultOptional();
    }
}
