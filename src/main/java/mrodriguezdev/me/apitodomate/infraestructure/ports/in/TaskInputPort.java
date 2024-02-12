package mrodriguezdev.me.apitodomate.infraestructure.ports.in;

import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;

public interface TaskInputPort {
    TaskDTO create(TaskRequestDTO taskRequestDTO);
    Paginator<TaskDTO> getTasks(Integer page, Integer size);
}
