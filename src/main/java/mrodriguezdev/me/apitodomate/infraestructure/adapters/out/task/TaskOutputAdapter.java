package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.task;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apitodomate.domain.mapper.TaskMapper;
import mrodriguezdev.me.apitodomate.domain.model.orm.Task;
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
    public TaskDTO persist(TaskRequestDTO taskRequestDTO) {
        Task newTask = this.createNewTask(taskRequestDTO);
        this.taskRepository.isPersistent(newTask);
        return this.taskMapper.toDTO(newTask);
    }

    public Task createNewTask(TaskRequestDTO taskRequestDTO) {
        LocalDate date = LocalDate.now();
        Task newTask = new Task();
        newTask.setTitle(taskRequestDTO.title);
        newTask.setDescription(taskRequestDTO.description);
        newTask.setCreationDate(date);
        newTask.setDueDate(taskRequestDTO.dueDate);
        newTask.setCompleted(false);
        return newTask;
    }

}
