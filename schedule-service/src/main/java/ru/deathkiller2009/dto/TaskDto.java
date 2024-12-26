package ru.deathkiller2009.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record TaskDto(Integer id, LocalDate date, LocalTime time, String description) {
}
