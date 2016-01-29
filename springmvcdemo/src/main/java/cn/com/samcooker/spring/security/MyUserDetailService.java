package cn.com.samcooker.spring.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

    // ��½��֤ʱ��ͨ��username��ȡ�û�������Ȩ����Ϣ��
    // ������User�ŵ�spring��ȫ�ֻ���SecurityContextHolder�У��Թ���Ȩ��ʹ��
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

        GrantedAuthorityImpl auth2 = new GrantedAuthorityImpl("ROLE_ADMIN");
        GrantedAuthorityImpl auth1 = new GrantedAuthorityImpl("ROLE_USER");

        if (username.equals("sam")) {
            auths = new ArrayList<GrantedAuthority>();
            auths.add(auth1);
            auths.add(auth2);
        }
        if (username.equals("kimi")) {
            throw new UsernameNotFoundException("û���û�[" + username + "]�����ݣ�");
        }

        User user = new User(username, "c4ca4238a0b923820dcc509a6f75849b", true, true, true, true, auths);
        return user;
    }
}