package mrodriguezdev.me.apitodomate.domain.model.task;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TaskRequestDTO {
    @NotNull(message = "Title cannot be null")
    public String title;
    @NotNull(message = "Description cannot be null")
    public String description;
    @NotNull(message = "DueDate cannot be null")
    @JsonbDateFormat
    public LocalDate dueDate;
}
