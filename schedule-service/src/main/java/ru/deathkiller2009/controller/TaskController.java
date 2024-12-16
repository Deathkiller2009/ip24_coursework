package ru.deathkiller2009.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.deathkiller2009.controller.payload.EditTaskPayload;
import ru.deathkiller2009.dto.TaskDto;
import ru.deathkiller2009.service.TaskService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task-api/tasks/{taskId:\\d+}")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @ModelAttribute("task")
    public TaskDto getTaskById(@PathVariable("taskId") Integer id) {
        return this.taskService
                .getTaskById(id)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    @GetMapping
    public TaskDto getTask(@ModelAttribute("task") TaskDto taskDto) {
        return taskDto;
    }

    @PatchMapping
    public ResponseEntity<Void> updateTask(@PathVariable("taskId") Integer id,
                                           @RequestBody @Valid EditTaskPayload payload,
                                           BindingResult bindingResult) {
        this.taskService.updateTask(id, payload.date(), payload.time(), payload.details());
        return ResponseEntity.noContent()
                .build();
    }

    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") Integer id) {
        this.taskService.deleteTask(id);
        return ResponseEntity.noContent()
                .build();
    }
}
