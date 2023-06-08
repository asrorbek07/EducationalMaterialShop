package com.example.educationalmaterialsshop.model.payload.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtToken {
    String accessToken;
    String refreshToken;
}
