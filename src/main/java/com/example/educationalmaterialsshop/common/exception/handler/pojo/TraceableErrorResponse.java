package com.example.educationalmaterialsshop.common.exception.handler.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TraceableErrorResponse {
    private String message;
    private String correlationId;
    private String stackTrace;
}

