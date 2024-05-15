package com.example.taskwebdev.shared;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class GlobalApiResponse<T> {
    private String message;
    private String data;
    private int statusCode;
}
