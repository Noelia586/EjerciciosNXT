package com.example.EJ31.Student.Infraestructure.ErrorHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private int HttpCode;
}
