package mrodriguezdev.me.apitodomate.domain.ports.in;

import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;

public interface TaskInputPort {
    TaskDTO create(TaskRequestDTO taskRequestDTO);
    Paginator<TaskDTO> getTasks(Long user_id, Integer page, Integer size);
}
