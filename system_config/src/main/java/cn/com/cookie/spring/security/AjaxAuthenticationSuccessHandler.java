package cn.com.cookie.spring.security;

import cn.com.cookie.common.bean.UserInfo;
import cn.com.cookie.common.entity.AppUserEntity;
import cn.com.cookie.common.service.AppUserEntityService;
import cn.com.cookie.common.utils.PropertyCopyUtil;
import cn.com.cookie.spring.bean.UserDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private AppUserEntityService appUserEntityService;

    public AjaxAuthenticationSuccessHandler() {
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        ObjectMapper objectMapper = new ObjectMapper();
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            // 登陆成功后返回的信息
            UserDetail user = (UserDetail) authentication.getPrincipal();
            UserInfo userInfo = appUserEntityService.findUserInfo(user.getId());
            objectMapper.writeValue(response.getOutputStream(), userInfo);
        } catch (JsonProcessingException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }
}
