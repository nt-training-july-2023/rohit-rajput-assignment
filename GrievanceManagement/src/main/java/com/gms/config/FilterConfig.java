package com.gms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gms.filter.AdminFilter;
import com.gms.filter.MemberFilter;

/**
 * This is @FilterConfig class for configuration of end-point with filter.
 */
@Configuration
public class FilterConfig {

    /**
     * This is @AdminFilter reference.
     */
    @Autowired
    private AdminFilter adminFilter;

    /**
     * This is @MemberFilter reference.
     */
    @Autowired
    private MemberFilter memberFilter;

    /**
     * This is @adminFilterRegistrationBean() method for registration of admin
     * filter.
     * @return FilterRegistrationBean<AdminFilter>
     */
    @Bean
    public FilterRegistrationBean<AdminFilter> adminFilterRegistrationBean() {
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(adminFilter);
        System.out.println("1qwert");
        registrationBean.addUrlPatterns("/gms/v1/admin","/department");
        return registrationBean;
    }

    /**
     * This is @memberFilterRegistrationBean() method for registration of member
     * filter.
     * @return FilterRegistrationBean<MemberFilter>
     */
    @Bean
    public FilterRegistrationBean<MemberFilter> memberFilterRegistrationBean() {
        FilterRegistrationBean<MemberFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(memberFilter);
        registrationBean.addUrlPatterns("/gms/v1/member");
        return registrationBean;
    }
}
