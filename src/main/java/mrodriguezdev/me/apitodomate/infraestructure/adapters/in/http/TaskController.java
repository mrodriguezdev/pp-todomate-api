package mrodriguezdev.me.apitodomate.infraestructure.adapters.in.http;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;
import mrodriguezdev.me.apitodomate.domain.ports.in.TaskInputPort;

@Path("task")
public class TaskController {

    @Inject
    TaskInputPort taskInputPort;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TaskDTO create(TaskRequestDTO taskRequestDTO) {
        return this.taskInputPort.create(taskRequestDTO);
    }

    @GET
    @Path("user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paginator<TaskDTO> getTasks(@PathParam("id") Long user_id,
                                       @QueryParam("page") Integer page,
                                       @QueryParam("size") Integer size) {
        return this.taskInputPort.getTasks(user_id, page, size);
    }
}
