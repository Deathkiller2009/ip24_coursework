package ru.deathkiller2009.controller.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewTaskPayload(

        @NotBlank(message = "{errors.task.edit.payload.validation.field.title_is_empty}")
        String title,

        @NotNull(message = "{errors.task.create.payload.validation.field.date_is_missing}")
        LocalDate date,

        @NotBlank(message = "{errors.task.create.payload.validation.field.time_is_missing}")
        @Pattern(regexp = "\\d\\d:\\d\\d", message = "{errors.task.create.payload.validation.field.time_is_in_wrong_format}")
        String time,

        @Size(min = 1, max = 1000, message = "{errors.task.create.payload.validation.field.details_is_too_small_or_too_big}")
        String details) {
}
