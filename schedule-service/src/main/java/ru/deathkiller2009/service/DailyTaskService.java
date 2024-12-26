package ru.deathkiller2009.service;



import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.deathkiller2009.entity.DailyTask;
import ru.deathkiller2009.repository.DailyTaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyTaskService {

    private final DailyTaskRepository dailyTaskRepository;

    public List<DailyTask> getAllDailyTasks() {
        return dailyTaskRepository.findAll();
    }

    public DailyTask createDailyTask(DailyTask dailyTask) {
        return dailyTaskRepository.save(dailyTask);
    }

    public void deleteDailyTask(Long id) {
        dailyTaskRepository.deleteById(id);
    }

    public DailyTask updateDailyTask(Long id, DailyTask dailyTaskDetails) {
        DailyTask dailyTask = dailyTaskRepository.findById(id).orElseThrow(() -> new RuntimeException("DailyTask not found"));
        dailyTask.setText(dailyTaskDetails.getText());
        return dailyTaskRepository.save(dailyTask);
    }
}