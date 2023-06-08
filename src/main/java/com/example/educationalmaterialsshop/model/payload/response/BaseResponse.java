package com.example.educationalmaterialsshop.model.payload.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseResponse {
    int id;
    int createdBy;
    int lastModifiedBy;
    Instant createdAt;
    Instant lastModifiedAt;
}
