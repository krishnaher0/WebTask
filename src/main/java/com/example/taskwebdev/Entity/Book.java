package com.example.taskwebdev.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @GeneratedValue(strategy = GenerationType.AUTO,generator="books_seq_gen")
    @SequenceGenerator(name="books_seq_gen",sequenceName="books_seq",allocationSize=1)
    @Id
    private Integer bookingId;

    @Column(name ="book_name",nullable = false,length = 100)
    private String userName;

    @ManyToOne
    @JoinColumn
    private Ground ground;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn
    private User user;
}

