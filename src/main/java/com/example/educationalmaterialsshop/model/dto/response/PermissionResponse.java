package com.example.educationalmaterialsshop.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Builder
public class PermissionResponse {
    private Integer id;
    private String name;
    private Integer createdBy;
    private Integer lastModifiedBy;
    private Timestamp createdAt;
    private Timestamp lastModifiedAt;
}
