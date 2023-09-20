//package com.gms.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.gms.entity.Role;
//import com.gms.repository.UserRepository;
//
///**
// * This is @AdminFilter for authorize admin to access admin end-point.
// */
//@Component
//public class AdminFilter implements Filter {
//    
//    /**
//     * This is @UserRepository reference.
//     */
//    @Autowired
//    private UserRepository userRepository;
//    
//    /**
//     *This is @doFilter method for handle request and response.
//     */
////    @Override
////    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
////            throws IOException, ServletException {
////        System.out.println("2qwert");
////        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
////        String username = httpServletRequest.getHeader("username");
////        String password = httpServletRequest.getHeader("encodedPassword");
////        System.out.println(httpServletRequest.getServletPath());
////        if(username == null || password == null) {
////            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
////        }else if(!userRepository.existsByEmailAndPasswordAndRole(username, password, Role.ADMIN)) {
////            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized user");
////        }else {
////        chain.doFilter(httpServletRequest, response);  
////        }
////    }
//    
//    @Override
//  public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
//          throws IOException, ServletException {
//      System.out.println("2qwert");
//      HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//      String username = httpServletRequest.getHeader("username");
//      String password = httpServletRequest.getHeader("encodedPassword");
//      System.out.println(httpServletRequest.getServletPath());
//      if(username == null || password == null) {
//          ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
//      }else if(!userRepository.existsByEmailAndPasswordAndRole(username, password, Role.ADMIN)) {
//          ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized user");
//      }else {
//          System.out.println("true");
//      chain.doFilter(httpServletRequest, response);  
//      }
//  }
//    
//}
