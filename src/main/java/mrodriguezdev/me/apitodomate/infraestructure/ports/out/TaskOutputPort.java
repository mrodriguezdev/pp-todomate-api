package mrodriguezdev.me.apitodomate.infraestructure.ports.out;

import mrodriguezdev.me.apitodomate.domain.model.orm.User;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;

public interface TaskOutputPort {
    TaskDTO persist(User user, TaskRequestDTO taskRequestDTO);
    Paginator<TaskDTO> getTasks(Long user_id, Integer page, Integer size);
}
