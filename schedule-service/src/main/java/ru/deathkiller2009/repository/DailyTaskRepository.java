package ru.deathkiller2009.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.deathkiller2009.entity.DailyTask;

@Repository
public interface DailyTaskRepository extends JpaRepository<DailyTask, Long> {
}