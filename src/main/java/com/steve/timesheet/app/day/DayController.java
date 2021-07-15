package com.steve.timesheet.app.day;

import com.steve.timesheet.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day")
public class DayController extends BaseController<Day, DayService> {

    @Autowired
    public DayController(DayService service) {
        super(service);
    }
}
