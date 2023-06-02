package com.example.educationalmaterialsshop.jwt;

import com.example.educationalmaterialsshop.model.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.experimental.UtilityClass;

import java.util.Date;

@UtilityClass
public class JwtUtils {
    private final static String jwtAccessKey = "thisIsTheSecretKey";
    private final static String jwtRefreshKey = "thisIsTheRefreshKey";
    private final static long expirationTimeOfAccessToken = 3600000;
    private final static long expirationTimeOfRefreshToken = 7200000;

    public  synchronized String generateAccessToken(
            UserEntity userDetails
    ) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, jwtAccessKey)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expirationTimeOfAccessToken))
                .claim("authorities", userDetails.getAuthorities())
                .compact();
    }public  synchronized String generateRefreshToken(
            UserEntity userDetails
    ) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, jwtRefreshKey)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expirationTimeOfRefreshToken))
                .claim("authorities", userDetails.getAuthorities())
                .compact();
    }

    public synchronized  Claims isAccessTokenValid(String token) {
        return getAccessTokenClaim(token);
    }

    public synchronized  Claims isRefreshTokenValid(String token) {
        return getRefreshTokenClaim(token);
    }

//    public static List<String> getAuthorities(Claims claims) {
//        return (List<String>) claims.get("authorities");
//    }


    private  synchronized Claims getAccessTokenClaim(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtAccessKey).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private  synchronized Claims getRefreshTokenClaim(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtRefreshKey).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
