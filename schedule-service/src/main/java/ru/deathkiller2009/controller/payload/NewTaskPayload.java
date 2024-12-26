package ru.deathkiller2009.controller.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record NewTaskPayload(

        @NotNull(message = "{errors.task.create.payload.validation.field.date_is_missing}")
        LocalDate date,

        LocalTime time,

        @Size(min = 1, max = 1000, message = "{errors.task.create.payload.validation.field.details_is_too_small_or_too_big}")
        String description) {
}
