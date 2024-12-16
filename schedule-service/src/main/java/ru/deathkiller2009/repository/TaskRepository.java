package ru.deathkiller2009.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.deathkiller2009.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
