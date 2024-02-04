package mrodriguezdev.me.apitodomate.domain.model.task;

import jakarta.json.bind.annotation.JsonbDateFormat;
import java.util.Date;

public class TaskDTO {
    public Long id;
    public String title;
    public String description;
    @JsonbDateFormat(value = "yyyy-MM-dd")
    public Date creationDate;
    @JsonbDateFormat(value = "yyyy-MM-dd")
    public Date dueDate;
    public Boolean completed;
}
