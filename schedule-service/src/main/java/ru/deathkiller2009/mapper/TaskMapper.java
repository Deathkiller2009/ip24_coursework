package ru.deathkiller2009.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.deathkiller2009.dto.TaskDto;
import ru.deathkiller2009.entity.Task;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    TaskDto toTaskDto(Task task);

    Task toTask(TaskDto taskDto);
}
