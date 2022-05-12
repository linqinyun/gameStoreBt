package com.lin.gamestroe.dao;

import com.lin.gamestroe.entity.AuthUser;

import java.util.List;

public interface AuthUserDao {
    List<AuthUser> queryAuthUser();
}
