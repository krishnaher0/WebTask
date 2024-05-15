package com.example.taskwebdev.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="users_seq_gen")
    @SequenceGenerator(name="users_seq_gen",sequenceName="users_seq",allocationSize=1)
    @Id
    private Integer userId;
    @Column(name="user_name" ,nullable=false, length=100)
    private String userName;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}