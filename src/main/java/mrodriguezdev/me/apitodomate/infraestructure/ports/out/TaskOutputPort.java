package mrodriguezdev.me.apitodomate.infraestructure.ports.out;

import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;

public interface TaskOutputPort {
    TaskDTO persist(TaskRequestDTO taskRequestDTO);
}
