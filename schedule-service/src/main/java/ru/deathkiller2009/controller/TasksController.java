package ru.deathkiller2009.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.deathkiller2009.controller.payload.NewTaskPayload;
import ru.deathkiller2009.dto.TaskDto;
import ru.deathkiller2009.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task-api/tasks")
public class TasksController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<TaskDto> createNewTask(@RequestBody @Valid NewTaskPayload payload,
                                                 BindingResult bindingResult) {

    }

}
