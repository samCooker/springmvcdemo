package cn.com.samcooker.common.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.samcooker.spring.bean.LoginUser;

@Controller
@RequestMapping("common/user")
public class UserController {

    @RequestMapping(value = "list.json")
    @ResponseBody
    public LoginUser getUserList(@RequestBody LoginUser data) {
        System.out.println("list");
        // throw new NoHandlerFoundException("not found", null, null);
        throw new NullPointerException();
    }

}
