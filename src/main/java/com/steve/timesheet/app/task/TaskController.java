package com.steve.timesheet.app.task;

import com.steve.timesheet.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController extends BaseController<Task,TaskService> {

    @Autowired
    public TaskController(TaskService service) {
        super(service);
    }
}
