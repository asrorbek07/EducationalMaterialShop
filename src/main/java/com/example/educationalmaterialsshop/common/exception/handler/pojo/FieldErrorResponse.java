package com.example.educationalmaterialsshop.common.exception.handler.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldErrorResponse {
    private String field;
    private String message;
    private String code;
}
