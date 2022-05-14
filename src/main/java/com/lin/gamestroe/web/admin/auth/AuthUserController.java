package com.lin.gamestroe.web.admin.auth;

import com.lin.gamestroe.dto.AuthUserExecution;
import com.lin.gamestroe.entity.AuthUser;
import com.lin.gamestroe.enums.AuthUserStateEnum;
import com.lin.gamestroe.service.AuthUserService;
import com.lin.gamestroe.util.HttpServletRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AuthUserController {
    Logger logger = LoggerFactory.getLogger(AuthUserController.class);
    @Autowired
    private AuthUserService authUserService;

    /**
     * 列表
     *
     * @return
     */
    @RequestMapping(value = "/listauthuser", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listAuthUser() {
        logger.info("=========START========");
        Long startTime = System.currentTimeMillis();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<AuthUser> authUserList = new ArrayList<AuthUser>();
        try {
            authUserList = authUserService.getAuthUserList();
            modelMap.put("rows", authUserList);
            modelMap.put("total", authUserList.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        logger.error("test error!");
        Long endTime = System.currentTimeMillis();
        logger.debug("costTime:[{}ms]", endTime - startTime);
        logger.info("========END==========");
        return modelMap;
    }

    @RequestMapping(value = "/bindAuth", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> bindAuthUser(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String username = HttpServletRequestUtil.getString(request, "username");
        String password = HttpServletRequestUtil.getString(request, "password");

        if (username != null && password != null) {
            AuthUser authUser = new AuthUser();
            authUser.setUsername(username);
            authUser.setPassword(password);
            authUser.setCreateTime(new Date());
            authUser.setUpdateTime(new Date());
            AuthUserExecution ae = authUserService.bindAuthUser(authUser);
            if (ae.getState() == AuthUserStateEnum.SUCCESS.getState()) {
                //填入session
                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", ae.getStateInfo());
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "账户与密码不能为空！");
        }
        return modelMap;
    }
}
