package ru.deathkiller2009.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.deathkiller2009.dto.TaskDto;
import ru.deathkiller2009.entity.Task;
import ru.deathkiller2009.mapper.TaskMapper;
import ru.deathkiller2009.repository.TaskRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultTaskService implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAllTasks() {
        return this.taskRepository.findAll()
                .stream().map(taskMapper::toTaskDto)
                .toList();
    }

    @Override
    public Optional<TaskDto> getTaskById(Integer id) {
        return this.taskRepository.findById(id)
                .map(taskMapper::toTaskDto);
    }

    @Override
    @Transactional
    public TaskDto createTask(String date, String time, String description) {
        return Stream.of(this.taskRepository.save(new Task(null, date, time, description)))
                .map(taskMapper::toTaskDto)
                .toList().getFirst();
    }

    @Override
    @Transactional
    public void updateTask(Integer id, String date, String time, String description) {
        this.taskRepository.findById(id)
                .ifPresentOrElse(task -> {
                    task.setDate(date);
                    task.setTime(time);
                    task.setDescription(description);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    @Transactional
    public void deleteTask(Integer id) {
        this.taskRepository.deleteById(id);
    }
}
