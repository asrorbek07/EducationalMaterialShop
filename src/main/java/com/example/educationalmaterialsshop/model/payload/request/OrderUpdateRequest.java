package com.example.educationalmaterialsshop.model.payload.request;

import com.example.educationalmaterialsshop.model.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderUpdateRequest {
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    OrderStatus status;
}
