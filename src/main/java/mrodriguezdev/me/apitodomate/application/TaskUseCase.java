package mrodriguezdev.me.apitodomate.application;

import mrodriguezdev.me.apitodomate.infraestructure.common.UseCase;
import mrodriguezdev.me.apitodomate.domain.exceptions.BadRequestException;
import mrodriguezdev.me.apitodomate.domain.exceptions.InternalServerErrorException;
import mrodriguezdev.me.apitodomate.domain.exceptions.NotFoundException;
import mrodriguezdev.me.apitodomate.infraestructure.entities.User;
import mrodriguezdev.me.apitodomate.domain.model.paginator.Paginator;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskDTO;
import mrodriguezdev.me.apitodomate.domain.model.task.TaskRequestDTO;
import mrodriguezdev.me.apitodomate.domain.ports.in.TaskInputPort;
import mrodriguezdev.me.apitodomate.domain.ports.out.TaskOutputPort;
import mrodriguezdev.me.apitodomate.infraestructure.utils.ValidationUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

@UseCase
public class TaskUseCase implements TaskInputPort {
    private final Logger logger = Logger.getLogger(TaskUseCase.class.getName());
    private final TaskOutputPort taskOutputPort;
    private final UserUseCase userUseCase;

    public TaskUseCase(TaskOutputPort taskOutputPort, UserUseCase userUseCase) {
        this.taskOutputPort = taskOutputPort;
        this.userUseCase = userUseCase;
    }

    @Override
    public TaskDTO create(TaskRequestDTO taskRequestDTO) {
        try {
            ValidationUtil.validar(taskRequestDTO);
            User user = this.validateUser(taskRequestDTO.user_id);
            return this.taskOutputPort.persist(user, taskRequestDTO);
        } catch (NotFoundException nfe) {
          throw new NotFoundException(nfe.getMessage());
        } catch (BadRequestException bre) {
          throw new BadRequestException(bre.getMessage());
        } catch (Exception e) {
            this.logger.log(Level.SEVERE, "An internal server error occurred. Details: {0}", e.getMessage());
            throw new InternalServerErrorException("Our server encountered an issue. Please contact the administrator for assistance.");
        }
    }

    private User validateUser(Long id) {
        return this.userUseCase.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User with ID %s not found", id)));
    }

    @Override
    public Paginator<TaskDTO> getTasks(Long user_id, Integer page, Integer size) {
        try {
            this.validateUser(user_id);
            Paginator<TaskDTO> taskPaginator = this.taskOutputPort.getTasks(user_id, page, size);
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
