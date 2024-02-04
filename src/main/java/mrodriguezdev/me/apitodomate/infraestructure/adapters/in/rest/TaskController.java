package mrodriguezdev.me.apitodomate.infraestructure.adapters.in.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;
import mrodriguezdev.me.apitodomate.infraestructure.ports.in.TaskInputPort;

@Path("task")
public class TaskController {

    @Inject
    TaskInputPort taskInputPort;

    @POST
    public TaskDTO create(TaskRequestDTO taskRequestDTO) {
        return this.taskInputPort.create(taskRequestDTO);
    }
}
