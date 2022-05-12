package com.lin.gamestroe.web.admin;

import com.lin.gamestroe.entity.AuthUser;
import com.lin.gamestroe.service.AuthUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AuthUserController {
    Logger logger = LoggerFactory.getLogger(AuthUserController.class);
    @Autowired
    private AuthUserService authUserService;

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
        logger.debug("costTime:[{}ms]",endTime-startTime);
        logger.info("========END==========");
        return modelMap;
    }
}
