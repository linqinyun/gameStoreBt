package com.lin.gamestroe.dao;

import com.lin.gamestroe.BaseTest;
import com.lin.gamestroe.entity.AuthUser;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

//根据方法名称排序进行测试 A-B-C-D
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthUserDaoTest extends BaseTest {
    @Autowired
    private AuthUserDao authUserDao;

    @Test
//    @Ignore //忽略
    public void testQueryAuthUser() {
        List<AuthUser> authUserList = authUserDao.queryAuthUser();
        assertEquals(1, authUserList.size());
    }

    @Test
    public void testQueryAuthByUserNameAndPwd() {
        String username = "admin";
        String password = "1234";
        AuthUser authUser = authUserDao.queryAuthByUserNameAndPwd(username, password);
        System.out.println(authUser.getUsername());
    }

    @Test
    public void testQueryAuthByUserId(){
        AuthUser authUser = authUserDao.queryAuthByAuthId(1l);
        assertEquals("admin",authUser.getUsername());
    }

    @Test
    public void testInsertAuthUser() {
        String username = "admin3";
        String password = "1234";
        Date createTime = new Date();
        Date updateTime = new Date();
        AuthUser authUser = new AuthUser();
        authUser.setUsername(username);
        authUser.setPassword(password);
        authUser.setCreateTime(createTime);
        authUser.setUpdateTime(updateTime);
        System.out.println(authUser.getUsername() + "," + authUser.getPassword() + "," + authUser.getCreateTime()
                + "," + authUser.getUpdateTime());
        int i = authUserDao.insertAuthUser(authUser);
        System.out.println(i);
    }

    @Test
    public void testUpdateAuthUser() {
        Long authId = 2l;
        String username = "admin1";
        String password = "12345";
        String newPassword = "123456";
        Date updateTime = new Date();
        System.out.println(updateTime);
        int i = authUserDao.updateAuthUser(authId, username, password, newPassword, updateTime);
        System.out.println(i);
    }
}
