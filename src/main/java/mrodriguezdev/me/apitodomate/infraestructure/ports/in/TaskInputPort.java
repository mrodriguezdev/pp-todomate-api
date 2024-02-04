package mrodriguezdev.me.apitodomate.infraestructure.ports.in;

import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;

public interface TaskInputPort {
    TaskDTO create(TaskRequestDTO taskRequestDTO);
}
