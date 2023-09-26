package com.gms.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gms.constants.MessageConstant;
import com.gms.constants.UrlConstant;
import com.gms.entity.Role;
import com.gms.repository.UserRepository;

/**
 * This is @MemberFilter for authorize a member to access a end-point.
 */
@Component
public class AuthorizationFilter implements Filter {

    /**
     * This is @UserRepository reference.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * This is @doFilter method for handle request and response.
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getMethod().equals("OPTIONS")) {
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            httpServletResponse.setHeader("Access-Control-Allow-Headers",
                    "Authorization, Content-Type, username, encodePassword");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            System.out.println(httpServletRequest.getRequestURI());
            String username = httpServletRequest.getHeader("username");
            String password = httpServletRequest.getHeader("encodePassword");
            String path = httpServletRequest.getServletPath();
            if (username == null || password == null || username == "" || password == "") {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        MessageConstant.INVALID_TOKEN);
            } else if (!userRepository.existsByEmailAndPassword(username, password)) {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        MessageConstant.UNAUTHORIZED);
            } else if ((path.startsWith(UrlConstant.BASE_URL + UrlConstant.MEMBER_URL)
                    && userRepository.existsByEmailAndPasswordAndRole(username, password, Role.ADMIN))
                    || (path.startsWith(UrlConstant.BASE_URL + UrlConstant.ADMIN_URL)
                            && userRepository.existsByEmailAndPasswordAndRole(username, password, Role.MEMBER))) {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        MessageConstant.ACCESS_DENIED);
            } else {
                chain.doFilter(httpServletRequest, response);
            }
        }
    }
}
