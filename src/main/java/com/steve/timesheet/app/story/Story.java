package com.steve.timesheet.app.story;

import com.steve.timesheet.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Story  extends BaseEntity {

    private LocalDateTime startTime;

    private Date endTime;

    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Story story;
}
