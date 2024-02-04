package mrodriguezdev.me.apitodomate.domain.mapper;

import mrodriguezdev.me.apitodomate.domain.model.orm.Task;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface TaskMapper {
    TaskDTO toDTO(Task task);
    List<TaskDTO> toLstDTO(List<Task> lstTasks);
}
