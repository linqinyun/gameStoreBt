package com.lin.gamestroe.dto;

import com.lin.gamestroe.entity.AuthUser;
import com.lin.gamestroe.enums.AuthUserStateEnum;

import java.util.List;

public class AuthUserExecution {
    private int state;
    private String stateInfo;
    private int count;
    private AuthUser authUser;
    private List<AuthUser> authUserList;

    public AuthUserExecution() {
    }

    //失败的构造器
    public AuthUserExecution(AuthUserStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
    //成功的构造器-1
    public AuthUserExecution(AuthUserStateEnum stateEnum, AuthUser authUser) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.authUser = authUser;
    }

    //成功的构造器-2
    public AuthUserExecution(AuthUserStateEnum stateEnum, List<AuthUser> authUserList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.authUserList = authUserList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public AuthUser getAuthUser() {
        return authUser;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }

    public List<AuthUser> getAuthUserList() {
        return authUserList;
    }

    public void setAuthUserList(List<AuthUser> authUserList) {
        this.authUserList = authUserList;
    }
}
