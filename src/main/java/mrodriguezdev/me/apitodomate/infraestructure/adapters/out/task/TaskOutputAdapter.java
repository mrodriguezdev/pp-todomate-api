package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.task;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mrodriguezdev.me.apitodomate.domain.mapper.TaskMapper;
import mrodriguezdev.me.apitodomate.domain.model.orm.Task;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;
import mrodriguezdev.me.apitodomate.infraestructure.adapters.out.repository.TaskRepository;
import mrodriguezdev.me.apitodomate.infraestructure.ports.out.TaskOutputPort;

@ApplicationScoped
public class TaskOutputAdapter implements TaskOutputPort {

    @Inject
    TaskRepository taskRepository;

    @Inject
    TaskMapper taskMapper;

    @Override
    @Transactional
    public TaskDTO persist(TaskRequestDTO taskRequestDTO) {
        return this.taskMapper.toDTO(this.taskRepository.save(taskRequestDTO));
    }


    @Override
    public Paginator<TaskDTO> getTasks(Integer page, Integer size) {
        Paginator<Task> taskPaginatorEntity = this.taskRepository.getTasks(page, size);
        Paginator<TaskDTO> taskDTOPaginator = new Paginator<>();
        taskDTOPaginator.items = this.taskMapper.toLstDTO(taskPaginatorEntity.items);
        taskDTOPaginator.pageSize = taskPaginatorEntity.pageSize;
        taskDTOPaginator.currentPage = taskPaginatorEntity.currentPage;
        return taskDTOPaginator;
    }
}
