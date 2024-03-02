package mrodriguezdev.me.apitodomate.domain.ports.out;

import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;

public interface TaskOutputPort {
    TaskDTO persist(UserDTO user, TaskRequestDTO taskRequestDTO);
    Paginator<TaskDTO> getTasks(Long user_id, Integer page, Integer size);
}
