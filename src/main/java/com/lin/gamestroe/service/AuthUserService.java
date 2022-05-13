package com.lin.gamestroe.service;

import com.lin.gamestroe.dto.AuthUserExecution;
import com.lin.gamestroe.entity.AuthUser;
import com.lin.gamestroe.exceptions.AuthUserOperationException;

import java.util.List;

public interface AuthUserService {
    List<AuthUser> getAuthUserList();

    AuthUser getAuthUserByAuthId(Long authId);

    AuthUser getAuthUserByUserNameAndPwd(String userName, String password);

    AuthUserExecution bindAuthUser(AuthUser authUser) throws AuthUserOperationException;

    AuthUserExecution modifyAuthUser(Long authId, String username, String password, String newPassword) throws AuthUserOperationException;
}
