package com.example.educationalmaterialsshop.model.payload.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse extends BaseResponse{
    String  name;
}
