package com.example.taskwebdev.shared.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class GlobalApiResponse<T> {
    private String message;
    private T data;
    private int statusCode;
}
