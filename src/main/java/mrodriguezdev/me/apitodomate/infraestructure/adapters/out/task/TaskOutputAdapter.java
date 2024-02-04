package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.task;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mrodriguezdev.me.apitodomate.domain.exceptions.NotFoundException;
import mrodriguezdev.me.apitodomate.domain.mapper.TaskMapper;
import mrodriguezdev.me.apitodomate.domain.model.orm.Task;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;
import mrodriguezdev.me.apitodomate.infraestructure.adapters.out.repository.TaskRepository;
import mrodriguezdev.me.apitodomate.infraestructure.ports.out.TaskOutputPort;

import java.time.LocalDate;

@ApplicationScoped
public class TaskOutputAdapter implements TaskOutputPort {

    @Inject
    TaskRepository taskRepository;

    @Inject
    TaskMapper taskMapper;

    @Override
    @Transactional
    public TaskDTO persist(TaskRequestDTO taskRequestDTO) {
        Task newTask = this.createNewTask(taskRequestDTO);
        this.taskRepository.persist(newTask);
        return this.taskMapper.toDTO(newTask);
    }

    private Task createNewTask(TaskRequestDTO taskRequestDTO) {
        LocalDate date = LocalDate.now();
        Task newTask = new Task();
        newTask.setTitle(taskRequestDTO.title);
        newTask.setDescription(taskRequestDTO.description);
        newTask.setCreationDate(date);
        newTask.setDueDate(taskRequestDTO.dueDate);
        newTask.setCompleted(false);
        return newTask;
    }

    @Override
    public Paginator<TaskDTO> getTasks(Integer page, Integer size) {
        Paginator<TaskDTO> taskPaginator = this.taskRepository.getTasks(page, size);
        if(taskPaginator.items.isEmpty()) throw new NotFoundException("No tasks found");
        return taskPaginator;
    }
}
