package com.example.educationalmaterialsshop.common.filter;


import com.example.educationalmaterialsshop.common.jwt.JwtUtils;
import com.example.educationalmaterialsshop.model.entity.User;
import com.example.educationalmaterialsshop.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String requestHeader = request.getHeader("Authorization");
        if (!(requestHeader != null && requestHeader.startsWith("Bearer "))) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = requestHeader.replace("Bearer ", "");
        Claims claims = JwtUtils.isAccessTokenValid(token);

        if (claims == null) {
            filterChain.doFilter(request, response);
            return;
        }
        User user = userRepository.findByUsername(claims.getSubject()).get();
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        authenticateUser(user,request);

        filterChain.doFilter(request, response);
    }

    public void authenticateUser(User user, HttpServletRequest request){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//        authenticationToken.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

}
