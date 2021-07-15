package com.steve.timesheet.app.day;


import com.steve.timesheet.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class DayService extends BaseService<Day, DayRepository> {

    @Autowired
    public DayService(ApplicationContext context, DayRepository repository) {
        super(context, repository);
    }
}
