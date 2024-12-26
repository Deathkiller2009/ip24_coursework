package ru.deathkiller2009.service;

import ru.deathkiller2009.dto.TaskDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<TaskDto> getAllTasks(LocalDate date);

    Optional<TaskDto> getTaskById(Integer id);

    TaskDto createTask(LocalDate date, LocalTime time, String description);

    void updateTask(Integer id, LocalDate date, LocalTime time, String description);

    void deleteTask(Integer id);

}
