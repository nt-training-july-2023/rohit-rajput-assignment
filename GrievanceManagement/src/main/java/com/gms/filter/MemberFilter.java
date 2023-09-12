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

@Component
public class MemberFilter implements Filter {

    private String header;
    private String[] elements;
    @Autowired
    private UserRepository userRepository;

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        elements = null;
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        header = httpServletRequest.getHeader("AUTH_TOKEN");
//        if (header != null) {
//            System.out.println("line number 35.....");
//            elements = header.split("GMS_BEARER");            
//        }
//        if (header == null || elements.length != 2|| elements[0]=="") {
//            System.out.println("line number 39.....");
//            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
//        } else {
//            try {
////                long id = Long.parseLong(elements[0]);
////                System.out.println(id);
////                System.out.println(elements[1]);
//                if (!userRepository.existsByEmailAndPasswordAndRole(elements[0], elements[1], Role.MEMBER)) {
//                    System.out.println("line number 44.....");
//                    ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("line number 49.....");
//                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
//            }
//        }
//        chain.doFilter(httpServletRequest, response);
//    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
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

