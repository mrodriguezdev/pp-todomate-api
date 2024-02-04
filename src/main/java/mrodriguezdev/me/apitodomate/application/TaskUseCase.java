package mrodriguezdev.me.apitodomate.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mrodriguezdev.me.apitodomate.domain.exceptions.BadRequestException;
import mrodriguezdev.me.apitodomate.domain.exceptions.InternalServerErrorException;
import mrodriguezdev.me.apitodomate.domain.exceptions.NotFoundException;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;
import mrodriguezdev.me.apitodomate.infraestructure.ports.in.TaskInputPort;
import mrodriguezdev.me.apitodomate.infraestructure.ports.out.TaskOutputPort;
import mrodriguezdev.me.apitodomate.infraestructure.utils.ValidationUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class TaskUseCase implements TaskInputPort {

    private final Logger logger = Logger.getLogger(TaskUseCase.class.getName());

    @Inject
    TaskOutputPort taskOutputPort;

    @Override
    public TaskDTO create(TaskRequestDTO taskRequestDTO) {
        try {
            ValidationUtil.validar(taskRequestDTO);
            return this.taskOutputPort.persist(taskRequestDTO);
        } catch (BadRequestException bre) {
          throw new BadRequestException(bre.getMessage());
        } catch (Exception e) {
            this.logger.log(Level.SEVERE, "An internal server error occurred. Details: {0}", e.getMessage());
            throw new InternalServerErrorException("Our server encountered an issue. Please contact the administrator for assistance.");
        }
    }

    @Override
    public Paginator<TaskDTO> getTasks(Integer page, Integer size) {
        try {
            Paginator<TaskDTO> taskPaginator = this.taskOutputPort.getTasks(page, size);
            if(taskPaginator.items.isEmpty()) throw new NotFoundException("No tasks found");
            return taskPaginator;
        } catch (NotFoundException nfe) {
            throw new NotFoundException(nfe.getMessage());
        } catch (Exception e) {
            this.logger.log(Level.SEVERE, "An internal server error occurred. Details: {0}", e.getMessage());
            throw new InternalServerErrorException("Our server encountered an issue. Please contact the administrator for assistance.");
        }
    }
}
