package com.gms.constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UrlConstantTest {
    
    @Test
    public void testUrlConstant() {
        assertEquals("/admin", UrlConstant.ADMIN_URL);
        assertEquals("/user", UrlConstant.COMMON_URL);
        assertEquals("/ticket", UrlConstant.TICKET_URL);
        assertEquals("/department", UrlConstant.DEPARTMENT_URL);
        assertEquals("/auth", UrlConstant.AUTH_URL);
        assertEquals("/gms", UrlConstant.BASE_URL);
        assertEquals("/member", UrlConstant.MEMBER_URL);
    }

}
