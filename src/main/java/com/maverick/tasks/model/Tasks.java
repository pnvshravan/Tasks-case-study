package com.maverick.tasks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor //@NoArgsConstructor
public class Tasks {

    public enum Status{
        pending,
        in_progress,
        completed
    }

    @Id
    private int task_id;
    private String title;
    private String description;
    private Date date; //yyyy-MM-dd format
    @Enumerated(EnumType.STRING)
    public Status status;

    @Column(updatable = false)
    private final ZonedDateTime created_at;

    private ZonedDateTime updated_at;

    public Tasks(){
        ZoneId istZoneId = ZoneId.of("Asia/Kolkata");
        this.created_at = LocalDateTime.now().atZone(istZoneId);

        this.updated_at = LocalDateTime.now().atZone(istZoneId);
        //this.status = Status.completed;
    }
}
