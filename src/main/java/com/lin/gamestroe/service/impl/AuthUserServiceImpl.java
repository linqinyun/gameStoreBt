package com.lin.gamestroe.service.impl;

import com.lin.gamestroe.dao.AuthUserDao;
import com.lin.gamestroe.entity.AuthUser;
import com.lin.gamestroe.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Autowired
    private AuthUserDao authUserDao;

    @Override
    public List<AuthUser> getAuthUserList() {
        return authUserDao.queryAuthUser();
    }
}
