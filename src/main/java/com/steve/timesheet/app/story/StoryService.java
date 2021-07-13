package com.steve.timesheet.app.story;


import com.steve.timesheet.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class StoryService extends BaseService<Story,StoryRepository> {

    @Autowired
    public StoryService(ApplicationContext context, StoryRepository repository) {
        super(context, repository);
    }
}
