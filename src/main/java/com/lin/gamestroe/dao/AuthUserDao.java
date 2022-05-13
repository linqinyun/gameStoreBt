package com.lin.gamestroe.dao;

import com.lin.gamestroe.entity.AuthUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AuthUserDao {
    /**
     * 列出所有管理列表
     * @return
     */
    List<AuthUser> queryAuthUser();

    /**
     * 添加管理员信息
     * @param authUser
     * @return
     */
    int insertAuthUser(AuthUser authUser);

    /**
     * 根据authId，username，password修改密码
     * @param authId
     * @param username
     * @param password
     * @param newPassword
     * @param updateTime
     * @return
     */
    int updateAuthUser(@Param("authId")Long authId, @Param("username")String username,
                       @Param("password")String password, @Param("newPassword")String newPassword,
                       @Param("updateTime")Date updateTime);

    /**
     * 根据账户与密码查询对应信息，登录用
     *
     * @param username
     * @param password
     * @return
     */
    AuthUser queryAuthByUserNameAndPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 根据管理员id查询信息
     * @param authId
     * @return
     */
    AuthUser queryAuthByAuthId(@Param("authId") Long authId);
}
