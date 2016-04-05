package cn.com.cookie.common.service;

import javax.transaction.Transactional;

import cn.com.cookie.common.bean.RegisteData;
import cn.com.cookie.common.bean.UserInfo;
import cn.com.cookie.common.entity.AppUserEntity;
import cn.com.cookie.common.entity.RoleEntity;
import cn.com.cookie.common.jpa.SimpleDomainRepository;
import cn.com.cookie.common.jpa.SimpleLongIdCrudRestService;
import cn.com.cookie.common.reference.AppValid;
import cn.com.cookie.common.repository.AppUserEntityRepository;
import cn.com.cookie.common.utils.PropertyCopyUtil;
import com.google.common.collect.Lists;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cookie
 * History:2016年03月21日 (Cookie) 1.0 Create
 */
@Service
@Transactional
public class AppUserEntityServiceImpl extends SimpleLongIdCrudRestService<AppUserEntity> implements AppUserEntityService {

    @Autowired
    private AppUserEntityRepository appUserEntityRepository;

    @Override
    public SimpleDomainRepository<AppUserEntity, Long> getRepository() {
        return appUserEntityRepository;
    }

    @Override
    public AppUserEntity findByAccountAndValid(String account, String validable) {
        return appUserEntityRepository.findByAccountAndValid(account,validable);
    }

    @Override
    public AppUserEntity findByAccount(String account) {
        return appUserEntityRepository.findByAccountAndValid(account,AppValid.有效.getKey());
    }

    @Override
    public UserInfo findUserInfo(Long userId) {
        UserInfo userInfo = null;
        if(userId!=null){
            AppUserEntity userEntity =appUserEntityRepository.findOne(userId);
            if (userEntity != null&&userEntity.getRoleList()!=null) {
                userInfo = PropertyCopyUtil.copy(userEntity, UserInfo.class);
                List<String> rolesName = Lists.newArrayList();
                for(RoleEntity role: userEntity.getRoleList()){
                    rolesName.add(role.getRoleCode());
                }
                userInfo.setRoles(rolesName);
            }
        }
        return userInfo;
    }

    @Override
    public boolean registeUser(RegisteData registeData) {

        return false;
    }

}
