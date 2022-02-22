package com.example.autoservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date birthDate;

    @Column(nullable = false)
    private String phoneNumber;

    public Client() {

    }
}
