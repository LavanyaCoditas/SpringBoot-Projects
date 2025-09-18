package com.example.JWT_Basics1.SecurityConfig;
import com.example.JWT_Basics1.Entity.User;
import com.example.JWT_Basics1.Repository.UserRepository;
import com.example.JWT_Basics1.Service.AuthUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter
{
    @Autowired
    AuthUtil authUtil;
    @Autowired
    UserRepository userRepository;

    //Intercepts requests to check for JWT before they reach controllers.
    //Handles extraction, validation, and authentication setup per request
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException,IOException
    {
        // Extracts the JWT from the request header
        String requestTokenHeader = request.getHeader("Authorization");

        //requestTokenHeader.trim() -> directly retrieve raw jwt if no bearer..

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer "))
        {

            String token = requestTokenHeader.substring(7).trim();

            String username=authUtil.getUserNameFromToken(token);

            if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null)
            {
                User user= userRepository.findByUsername(username).orElseThrow();

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities);

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}





































/*

package com.example.JWT_Basics1.SecurityConfig;
import com.example.JWT_Basics1.Entity.User;
import com.example.JWT_Basics1.Repository.UserRepository;
import com.example.JWT_Basics1.Service.AuthUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter
{
    @Autowired
    AuthUtil authUtil;
    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailService userDetailService;


    //Intercepts requests to check for JWT before they reach controllers.
    //Handles extraction, validation, and authentication setup per request
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException,IOException
    {
        // Extracts the JWT from the request header
        String requestTokenHeader = request.getHeader("Authorization");
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            String token = requestTokenHeader.substring(7).trim();
        }
//        if(requestTokenHeader==null || ! requestTokenHeader.startsWith("Bearer ")) {
//            // Calls filterChain.doFilter() to proceed if valid.
//            filterChain.doFilter(request,response);
//            return;
//        }
        //actual token extraction "Bearer hjbadhcjjlkjklkls.."
//        String token = requestTokenHeader.split("Bearer")[1];
//        String token = requestTokenHeader.substring(7);
        String username=authUtil.getUserNameFromToken(token);
        //Accesses the current security context to get/set authentication and then Stores auth info thread-locally for the request's lifecycle.
        if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
            User user= userRepository.findByUsername(username).orElseThrow();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities);
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(request,response);

    }

}

 */