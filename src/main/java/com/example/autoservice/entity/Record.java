package com.example.autoservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long clientId;

    @Column(nullable = false, updatable = false)
    private Date visitDate;

    @Column(nullable = false)
    private double checkSize;

    @ManyToOne
    private Employee employee;

    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime createDate;

    @PrePersist
    protected void onCreate() { this.createDate = LocalDateTime.now();}

    public Record() {

    }
}
