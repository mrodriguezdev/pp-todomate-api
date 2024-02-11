package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import mrodriguezdev.me.apitodomate.domain.model.orm.User;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Long> {

    public Optional<User> findByUsername(String username) {
        return find("username = ?1", username)
                .firstResultOptional();
    }
}
