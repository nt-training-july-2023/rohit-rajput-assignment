//package com.gms.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.gms.constants.UrlConstant;
//
//@Configuration
//@EnableWebMvc
//public class CorsConfiguration {
//    
//    @Bean
//    public WebMvcConfigurer addCorsConfigurer() {
//        return new WebMvcConfigurer() {            
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                System.out.println("line--------1");
//                registry.addMapping(UrlConstant.BASE_URL + "/*")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .allowedOrigins("*");
//            }
//        };
//    }
//}