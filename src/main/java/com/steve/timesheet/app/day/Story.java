package com.steve.timesheet.app.day;

import com.steve.timesheet.app.task.Task;
import com.steve.timesheet.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Story extends BaseEntity {

    private LocalDate enterTime;

    private LocalDate exitTime;

    private int hourlyLeave;

    private DayType type;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public void deleteTask(Task task){
        this.tasks.remove(task);
    }
}
