package com.example.educationalmaterialsshop.model.payload.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionResponse {
    Integer id;
    String name;
    Integer createdBy;
    Integer lastModifiedBy;
    Timestamp createdAt;
    Timestamp lastModifiedAt;
}
