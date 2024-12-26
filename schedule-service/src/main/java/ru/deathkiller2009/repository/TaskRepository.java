package ru.deathkiller2009.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.deathkiller2009.entity.Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<Task> findTaskByDateAndTime(LocalDate date, LocalTime time);

    List<Task> findAllByDate(LocalDate date);
}
