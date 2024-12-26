package ru.deathkiller2009.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.deathkiller2009.entity.DailyTask;
import ru.deathkiller2009.service.DailyTaskService;

import java.util.List;

@RestController
@RequestMapping("/api/daily-tasks")
@CrossOrigin
@RequiredArgsConstructor
public class DailyTaskController {

    private final DailyTaskService dailyTaskService;

    @GetMapping
    public List<DailyTask> getAllDailyTasks() {
        return dailyTaskService.getAllDailyTasks();
    }

    @PostMapping
    public DailyTask createDailyTask(@RequestBody DailyTask dailyTask) {
        return dailyTaskService.createDailyTask(dailyTask);
    }

    @DeleteMapping("/{id}")
    public void deleteDailyTask(@PathVariable Long id) {
        dailyTaskService.deleteDailyTask(id);
    }

    @PutMapping("/{id}")
    public DailyTask updateDailyTask(@PathVariable Long id, @RequestBody DailyTask dailyTaskDetails) {
        return dailyTaskService.updateDailyTask(id, dailyTaskDetails);
    }
}