package com.lin.gamestroe.service;

import com.lin.gamestroe.BaseTest;
import com.lin.gamestroe.dao.AuthUserDao;
import com.lin.gamestroe.entity.AuthUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthUserServiceTest extends BaseTest {
    @Autowired
    private AuthUserService authUserService;
    @Test
    public void testGetAuthUserList(){
        List<AuthUser> authUserList = authUserService.getAuthUserList();
        assertEquals(1,authUserList.size());
    }
}
