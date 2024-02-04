package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apitodomate.domain.mapper.TaskMapper;
import mrodriguezdev.me.apitodomate.domain.model.orm.Task;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;

@ApplicationScoped
public class TaskRepository implements PanacheRepositoryBase<Task, Long> {

    @Inject
    TaskMapper taskMapper;

    public Paginator<TaskDTO> getTasks(Integer page, Integer size) {
        page = (page != null) ? page : 0;
        size = (size != null) ? size : 10;

        PanacheQuery<Task> pqTask = find("ORDER BY id ASC")
                .page(Page.of(page, size));

        Paginator<TaskDTO> taskPaginator = new Paginator<>();
        taskPaginator.items = this.taskMapper.toLstDTO(pqTask.list());
        taskPaginator.currentPage = page;
        taskPaginator.pageSize = pqTask.pageCount();
        return taskPaginator;
    }
}
