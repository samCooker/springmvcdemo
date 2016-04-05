package cn.com.cookie.common.service;

import cn.com.cookie.common.entity.AppUserEntity;
import cn.com.cookie.common.entity.ResourceEntity;
import cn.com.cookie.common.entity.RoleEntity;
import cn.com.cookie.spring.bean.UserDetail;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("myUserDetailService")
@Transactional
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AppUserEntityService appUserEntityService;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
        // 可从数据库获取用户信息及对应的角色
        AppUserEntity userEntity = appUserEntityService.findByAccount(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户名或密码错误。");
        }
        this.getGrantedAuthorityList(userEntity);

        UserDetail user = new UserDetail(userEntity.getAccount(), userEntity.getPassword(), true, true, true, true, userEntity.getAuthorities());
        //添加额外信息
        user.setId(userEntity.getId());
        return user;
    }

    /**
     * 从用户实体中获取角色信息
     * @param userEntity
     */
    private void getGrantedAuthorityList(AppUserEntity userEntity) {
        List<GrantedAuthority> auths =  Lists.newArrayList();
        GrantedAuthority ga;
        if (userEntity.getRoleList() != null) {
            for (RoleEntity role : userEntity.getRoleList()) {
                if(role.getResourceList()!=null){
                    for (ResourceEntity res : role.getResourceList()){
                        ga = new SimpleGrantedAuthority(res.getAuthorityName());
                        auths.add(ga);
                    }
                }

            }
        }
        userEntity.setAuthorities(auths);
    }

}