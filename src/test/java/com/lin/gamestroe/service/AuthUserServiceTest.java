package com.lin.gamestroe.service;

import com.lin.gamestroe.BaseTest;
import com.lin.gamestroe.dao.AuthUserDao;
import com.lin.gamestroe.dto.AuthUserExecution;
import com.lin.gamestroe.entity.AuthUser;
import com.lin.gamestroe.enums.AuthUserStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthUserServiceTest extends BaseTest {
    @Autowired
    private AuthUserService authUserService;
    @Test
    public void testGetAuthUserList(){
        List<AuthUser> authUserList = authUserService.getAuthUserList();
        assertEquals(2,authUserList.size());
    }
    @Test
    public void testGetAuthUserByAuthId(){
        AuthUser authUser = authUserService.getAuthUserByAuthId(1l);
        assertEquals("admin",authUser.getUsername());
    }
    @Test
    public void testGetAuthUserByUserNameAndPwd(){
        AuthUser authUser = authUserService.getAuthUserByUserNameAndPwd("admin","1234");
        assertEquals("admin",authUser.getUsername());
    }
    @Test
    public void testBindAuthUser(){
        String username = "admin4";
        String password = "1234";
        Date createTime = new Date();
        Date updateTime = new Date();
        AuthUser authUser = new AuthUser();
        authUser.setUsername(username);
        authUser.setPassword(password);
        authUser.setCreateTime(createTime);
        authUser.setUpdateTime(updateTime);
        AuthUserExecution ae = authUserService.bindAuthUser(authUser);
//        System.out.println(ae.getAuthUser().getAuthId());
        assertEquals(AuthUserStateEnum.SUCCESS.getState(),ae.getState());
    }
    @Test
    public void testModifyAuthUser(){
        Long authId = 3l;
        String username = "admin2";
        String password = "1234";
        String newPassword = "12344444";
        AuthUserExecution ae = authUserService.modifyAuthUser(authId,username,password,newPassword);
        assertEquals(AuthUserStateEnum.SUCCESS.getState(),ae.getState());
    }
}
