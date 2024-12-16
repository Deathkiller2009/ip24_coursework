package ru.deathkiller2009.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record TaskDto(Integer id, String date, String time, String description) {
}
