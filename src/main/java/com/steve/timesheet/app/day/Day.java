package com.steve.timesheet.app.day;

import com.steve.timesheet.app.task.Task;
import com.steve.timesheet.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Day extends BaseEntity {

    private Date checkIn;

    private Date checkOut;

    private Date date;

    private int hourlyLeave;

    private DayType type;

    private Float totalSpend;

    private Float restTime;

    private Float calculatedTime;

    @OneToMany(mappedBy = "day")
    private List<Task> tasks;

    public Day setTasks(List<Task> tasks) {
        this.tasks.clear();
        for (Task task : tasks) {
            this.tasks.add(task);
            task.setDay(this);
        }
        return this;
    }
}

