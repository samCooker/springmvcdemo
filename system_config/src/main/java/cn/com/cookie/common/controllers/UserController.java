package cn.com.cookie.common.controllers;

import cn.com.cookie.common.bean.DataRegiste;
import cn.com.cookie.common.service.AppUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("sys")
public class UserController {

    @Autowired
    AppUserEntityService appUserEntityService;

    /**
     * 注册用户,将用户信息写入app_user表中，默认角色为游客
     * @return
     */
    @RequestMapping(value = "user/add.json")
    @ResponseBody
    public String  getUserList(@RequestBody @Valid DataRegiste dataRegiste, BindingResult result) {
        if(result.hasErrors()){
            StringBuilder builder =new StringBuilder("错误信息：");
            return "a";
        }
        return appUserEntityService.registeUser(dataRegiste);
    }

}
