package com.example.autoservice.entity;

import com.example.autoservice.entity.enums.ERole;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(targetClass = ERole.class)
    @CollectionTable(name = "employee_role",
            joinColumns = @JoinColumn(name = "employee_id"))
    private Set<ERole> roles = new HashSet<>();

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String phoneNumber;

    @ManyToOne()
//    @JoinColumn(name = "id")
    private Position position;

    @Column(unique = true, updatable = false)
    private String username;

    @Column(length = 3000)
    private String password;

//    @
//    private List<Record> records = new ArrayList<>();

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public Employee() {

    }
}
