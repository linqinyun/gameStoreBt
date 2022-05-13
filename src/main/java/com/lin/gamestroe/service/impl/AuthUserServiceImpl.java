package com.lin.gamestroe.service.impl;

import com.lin.gamestroe.dao.AuthUserDao;
import com.lin.gamestroe.dto.AuthUserExecution;
import com.lin.gamestroe.entity.AuthUser;
import com.lin.gamestroe.enums.AuthUserStateEnum;
import com.lin.gamestroe.exceptions.AuthUserOperationException;
import com.lin.gamestroe.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Autowired
    private AuthUserDao authUserDao;

    @Override
    public List<AuthUser> getAuthUserList() {
        return authUserDao.queryAuthUser();
    }

    @Override
    public AuthUser getAuthUserByAuthId(Long authId) {
        return authUserDao.queryAuthByAuthId(authId);
    }

    @Override
    public AuthUser getAuthUserByUserNameAndPwd(String userName, String password) {
        return authUserDao.queryAuthByUserNameAndPwd(userName,password);
    }

    @Override
    @Transactional
    public AuthUserExecution bindAuthUser(AuthUser authUser) throws AuthUserOperationException {
        // 空值判断，帐号密码，用户信息不能为空，否则直接返回错误
        if (authUser == null || authUser.getPassword() == null || authUser.getUsername() == null) {
            return new AuthUserExecution(AuthUserStateEnum.NULL_AUTH_INFO);
        }
        try {
            int effectedNum = authUserDao.insertAuthUser(authUser);
            if (effectedNum <= 0) {
                throw new AuthUserOperationException("账号创建失败!");
            } else {
                return new AuthUserExecution(AuthUserStateEnum.SUCCESS, authUser);
            }
        } catch (Exception e) {
            throw new AuthUserOperationException("insertAuthUser error: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public AuthUserExecution modifyAuthUser(Long authId, String username, String password, String newPassword) throws AuthUserOperationException {
        if (authId != null && username != null && password != null && newPassword != null && !password.equals(newPassword)) {
            try {
                int effectedNum = authUserDao.updateAuthUser(authId, username, password, newPassword, new Date());
                if (effectedNum <= 0) {
                    throw new AuthUserOperationException("更新密码失败");
                }
                return new AuthUserExecution(AuthUserStateEnum.SUCCESS);
            } catch (Exception e) {
                throw new AuthUserOperationException("更新密码失败：" + e.toString());
            }
        } else {
            return new AuthUserExecution(AuthUserStateEnum.NULL_AUTH_INFO);
        }
    }
}
