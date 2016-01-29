package cn.com.samcooker.spring.security;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        String username = obtainUsername(request);
        String password = obtainPassword(request);
        try {
            InputStream in = request.getInputStream();
            in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String roletype = request.getParameter("roletype");

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = null;

        if (!"".equals(roletype) || roletype != null) {
            if ("student".equals(roletype)) {
                // Student stu = studentdao.findById(username);
                //
                // //通过session把用户对象设置到session中
                // request.getSession().setAttribute("session_user", stu);
                //
                // //将角色标志在username上
                // username = "stu"+username;
                //
                // try {
                // if (stu == null || !stu.getPassword().equals(password)) {
                // BadCredentialsException exception = new BadCredentialsException("用户名或密码不匹配");
                // throw exception;
                // }
                // } catch (Exception e) {
                // BadCredentialsException exception = new BadCredentialsException("没有此用户");
                // throw exception;
                // }

            } else if ("teacher".equals(roletype)) {
                // Teacher tea = teacherdao.findById(username);
                //
                // //通过session把用户对象设置到session中
                // request.getSession().setAttribute("session_user", tea);
                //
                // //将角色标志在username上
                // username = "tea"+username;
                //
                // try {
                // if (tea == null || !tea.getPassword().equals(password)) {
                // BadCredentialsException exception = new BadCredentialsException("用户名或密码不匹配");
                // throw exception;
                // }
                // } catch (Exception e) {
                // BadCredentialsException exception = new BadCredentialsException("没有此用户");
                // throw exception;
                // }

            } else if ("admin".equals(roletype)) {
                // Admin adm on()= admindao.findById(username);
                //
                // //通过session把用户对象设置到session中
                // request.getSessi.setAttribute("session_user", adm);
                //
                // //将角色标志在username上
                // username = "adm"+username;
                // try {
                // if (adm == null || !password.equals(adm.getPassword())) {
                // BadCredentialsException exception = new BadCredentialsException("用户名或密码不匹配");
                // throw exception;
                // }
                // } catch (Exception e) {
                // BadCredentialsException exception = new BadCredentialsException("没有此用户");
                // throw exception;
                // }

            } else {
                BadCredentialsException exception = new BadCredentialsException("系统错误：没有对应的角色！");
                throw exception;
            }
        }

        // 实现验证
        authRequest = new UsernamePasswordAuthenticationToken(username, password);
        // 允许设置用户详细属性
        setDetails(request, authRequest);
        // 运行
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        Object obj = request.getParameter(USERNAME);
        return null == obj ? "" : obj.toString();
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        Object obj = request.getParameter(PASSWORD);
        return null == obj ? "" : obj.toString();
    }

    @Override
    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        super.setDetails(request, authRequest);
    }
}
