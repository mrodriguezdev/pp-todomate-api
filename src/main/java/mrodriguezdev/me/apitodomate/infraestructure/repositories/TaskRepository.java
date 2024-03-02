package mrodriguezdev.me.apitodomate.infraestructure.repositories;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import mrodriguezdev.me.apitodomate.infraestructure.entities.Task;
import mrodriguezdev.me.apitodomate.infraestructure.entities.User;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;

@ApplicationScoped
public class TaskRepository implements PanacheRepositoryBase<Task, Long> {

    public Task save(User user, TaskRequestDTO taskRequestDTO) {
        Task newTask = new Task();
        newTask.setTitle(taskRequestDTO.title);
        newTask.setDescription(taskRequestDTO.description);
        newTask.setCreationDate(taskRequestDTO.creationDate);
        newTask.setDueDate(taskRequestDTO.dueDate);
        newTask.setPriority(taskRequestDTO.priority);
        newTask.setCompleted(false);
        newTask.setUser(user);
        persist(newTask);
        return newTask;
    }

    public Paginator<Task> getTasks(Long user_id, Integer page, Integer size) {
        page = (page != null) ? page : 0;
        size = (size != null) ? size : 10;

        PanacheQuery<Task> pqTask = find("user.id = ?1 ORDER BY id ASC", user_id)
                .page(Page.of(page, size));

        Paginator<Task> taskPaginator = new Paginator<>();
        taskPaginator.items = pqTask.list();
        taskPaginator.currentPage = page;
        taskPaginator.pageSize = pqTask.pageCount();
        return taskPaginator;
    }
}
