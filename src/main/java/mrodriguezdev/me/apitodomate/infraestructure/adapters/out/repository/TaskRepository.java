package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import mrodriguezdev.me.apitodomate.domain.model.orm.Task;

@ApplicationScoped
public class TaskRepository implements PanacheRepositoryBase<Task, Long> {
}
