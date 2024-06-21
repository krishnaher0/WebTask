package com.example.taskwebdev.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name="users")
public class User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="users_seq_gen")
    @SequenceGenerator(name="users_seq_gen",sequenceName="users_seq",allocationSize=1)
    @Id
    private Integer id;
    @Column(name="user_name" ,nullable=false, length=100)
    private String  userName;


}