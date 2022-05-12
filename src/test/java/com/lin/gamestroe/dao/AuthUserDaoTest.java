package com.lin.gamestroe.dao;

import com.lin.gamestroe.BaseTest;
import com.lin.gamestroe.entity.AuthUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthUserDaoTest extends BaseTest {
    @Autowired
    private AuthUserDao authUserDao;

    @Test
    public void testQueryAuthUser(){
        List<AuthUser> authUserList = authUserDao.queryAuthUser();
        assertEquals(1,authUserList.size());
    }
}
