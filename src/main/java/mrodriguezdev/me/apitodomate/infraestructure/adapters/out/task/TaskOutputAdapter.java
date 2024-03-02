package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.task;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;
import mrodriguezdev.me.apitodomate.domain.ports.out.TaskOutputPort;
import mrodriguezdev.me.apitodomate.infraestructure.adapters.out.user.UserMapper;

@ApplicationScoped
public class TaskOutputAdapter implements TaskOutputPort {

    @Inject
    TaskRepository taskRepository;

    @Inject
    TaskMapper taskMapper;

    @Inject
    UserMapper userMapper;

    @Override
    @Transactional
    public TaskDTO persist(UserDTO user, TaskRequestDTO taskRequestDTO) {
        return this.taskMapper.toDTO(this.taskRepository.save(this.userMapper.toEntity(user), taskRequestDTO));
    }

    @Override
    public Paginator<TaskDTO> getTasks(Long user_id, Integer page, Integer size) {
        Paginator<Task> taskPaginatorEntity = this.taskRepository.getTasks(user_id, page, size);
        Paginator<TaskDTO> taskDTOPaginator = new Paginator<>();
        taskDTOPaginator.items = this.taskMapper.toLstDTO(taskPaginatorEntity.items);
        taskDTOPaginator.pageSize = taskPaginatorEntity.pageSize;
        taskDTOPaginator.currentPage = taskPaginatorEntity.currentPage;
        return taskDTOPaginator;
    }
}
