package cn.com.cookie.common.controllers;

import cn.com.cookie.common.bean.RegisteData;
import cn.com.cookie.common.service.AppUserEntityService;
import cn.com.cookie.spring.bean.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sys")
public class UserController {

    @Autowired
    AppUserEntityService appUserEntityService;

    /**
     * 注册用户
     * @return
     */
    @RequestMapping(value = "user/add.action")
    @ResponseBody
    public boolean getUserList(@RequestBody RegisteData registeData) {

        return appUserEntityService.registeUser(registeData);
    }

}
