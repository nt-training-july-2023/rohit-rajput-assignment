package com.gms.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gms.entity.Role;
import com.gms.repository.UserRepository;

/**
 * This is @MemberFilter for authorize a member to access a end-point.
 */
@Component
public class MemberFilter implements Filter {

   
    /**
     * This is @UserRepository reference.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     *This is @doFilter method for handle request and response.
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        System.out.println("memberfilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String username = httpServletRequest.getHeader("username");
        String password = httpServletRequest.getHeader("encodedPassword");
        System.out.println(username);
        System.out.println(password);
        if(username == null || password == null || username == "" || password == "") {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
        }else if(!userRepository.existsByEmailAndPasswordAndRole(username, password, Role.MEMBER)) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized user");
        }
        chain.doFilter(httpServletRequest, response);        
    }
}

