package com.steve.timesheet.app.task;


import com.steve.timesheet.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends BaseService<Task,TaskRepository> {

    @Autowired
    public TaskService(ApplicationContext context, TaskRepository repository) {
        super(context, repository);
    }
}
