package com.lin.gamestroe.exceptions;

import com.lin.gamestroe.entity.AuthUser;
import com.lin.gamestroe.enums.AuthUserStateEnum;

public class AuthUserOperationException extends RuntimeException {

    private static final long serialVersionUID = 3310128950711774938L;

    public AuthUserOperationException(String message) {
        super(message);
    }

}
