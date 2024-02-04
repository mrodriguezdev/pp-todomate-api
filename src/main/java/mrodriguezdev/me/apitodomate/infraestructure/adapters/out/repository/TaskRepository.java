package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import mrodriguezdev.me.apitodomate.domain.model.orm.Task;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;

import java.time.LocalDate;

@ApplicationScoped
public class TaskRepository implements PanacheRepositoryBase<Task, Long> {

    public Task save(TaskRequestDTO taskRequestDTO) {
        LocalDate date = LocalDate.now();
        Task newTask = new Task();
        newTask.setTitle(taskRequestDTO.title);
        newTask.setDescription(taskRequestDTO.description);
        newTask.setCreationDate(date);
        newTask.setDueDate(taskRequestDTO.dueDate);
        newTask.setCompleted(false);
        persist(newTask);
        return newTask;
    }

    public Paginator<Task> getTasks(Integer page, Integer size) {
        page = (page != null) ? page : 0;
        size = (size != null) ? size : 10;

        PanacheQuery<Task> pqTask = find("ORDER BY id ASC")
                .page(Page.of(page, size));

        Paginator<Task> taskPaginator = new Paginator<>();
        taskPaginator.items = pqTask.list();
        taskPaginator.currentPage = page;
        taskPaginator.pageSize = pqTask.pageCount();
        return taskPaginator;
    }
}
