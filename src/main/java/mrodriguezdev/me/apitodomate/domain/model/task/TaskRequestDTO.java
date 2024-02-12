package mrodriguezdev.me.apitodomate.domain.model.task;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TaskRequestDTO {
    @NotNull(message = "Title cannot be null")
    public String title;
    @NotNull(message = "Description cannot be null")
    public String description;
    @NotNull(message = "CreationDate cannot be null")
    @JsonbDateFormat
    public LocalDate creationDate;
    @NotNull(message = "DueDate cannot be null")
    @JsonbDateFormat
    public LocalDate dueDate;
    @NotNull(message = "Priority cannot be null")
    public String priority;
    @NotNull(message = "User_id cannot be null")
    public Long user_id;
}
