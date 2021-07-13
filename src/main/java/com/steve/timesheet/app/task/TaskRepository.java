package com.steve.timesheet.app.task;

import com.steve.timesheet.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends BaseRepository<Task> {
}
