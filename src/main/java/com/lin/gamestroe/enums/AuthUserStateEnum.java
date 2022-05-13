package com.lin.gamestroe.enums;

public enum AuthUserStateEnum {
    LOGINFAIL(-1,"用户或账号输入有误"), SUCCESS(0, "操作成功"), NULL_AUTH_INFO(-1006,
            "注册信息为空");
    private int state;
    private String stateInfo;

    AuthUserStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
    public static AuthUserStateEnum stateOf(int index){
        for (AuthUserStateEnum state:values()){
            if (state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
