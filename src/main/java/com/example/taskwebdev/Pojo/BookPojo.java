package com.example.taskwebdev.Pojo;

import com.example.taskwebdev.Entity.Ground;
import com.example.taskwebdev.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookPojo {
    private Integer bookingId;
    private String userName;
    private Long groundId;
    private Long userId;
}
