package com.gms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gms.filter.AdminFilter;
import com.gms.filter.MemberFilter;

@Configuration
public class FilterConfig {
    
    @Autowired
    private AdminFilter adminFilter;
    @Autowired
    private MemberFilter memberFilter;
    
    @Bean
    public FilterRegistrationBean<AdminFilter> adminFilterRegistrationBean(){
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(adminFilter);
        registrationBean.addUrlPatterns("/gms/v1/admin");
        return registrationBean;
    }
    
    @Bean
    public FilterRegistrationBean<MemberFilter> memberFilterRegistrationBean(){
        FilterRegistrationBean<MemberFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(memberFilter);
        registrationBean.addUrlPatterns("/gms/v1/member");
        return registrationBean;
    }

}
