package cn.com.cookie.common.service;

import javax.transaction.Transactional;

import cn.com.cookie.common.bean.DataRegiste;
import cn.com.cookie.common.bean.InfoUser;
import cn.com.cookie.common.entity.AppUserEntity;
import cn.com.cookie.common.entity.RoleEntity;
import cn.com.cookie.common.jpa.SimpleDomainRepository;
import cn.com.cookie.common.jpa.SimpleLongIdCrudRestService;
import cn.com.cookie.common.reference.AppValid;
import cn.com.cookie.common.repository.AppUserEntityRepository;
import cn.com.cookie.common.utils.PropertyCopyUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 获取用户信息，返回给页面
     * @param userId
     * @return
     */
    @Override
    public InfoUser findUserInfo(Long userId) {
        InfoUser userInfo = null;
        if(userId!=null){
            AppUserEntity userEntity =appUserEntityRepository.findOne(userId);
            if (userEntity != null&&userEntity.getRoleList()!=null) {
                userInfo = PropertyCopyUtil.copy(userEntity, InfoUser.class);
                List<String> rolesName = Lists.newArrayList();
                for(RoleEntity role: userEntity.getRoleList()){
                    rolesName.add(role.getRoleCode());
                }
                userInfo.setRoles(rolesName);
            }
        }
        return userInfo;
    }

    /**
     * 注册用户,将用户信息写入app_user表中，默认角色为游客
     * @return
     */
    @Override
    public String registeUser(DataRegiste dataRegiste) {
        return "";
    }

}
