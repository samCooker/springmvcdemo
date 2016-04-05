package cn.com.cookie.common.service;

import cn.com.cookie.common.bean.RegisteData;
import cn.com.cookie.common.bean.UserInfo;
import cn.com.cookie.common.entity.AppUserEntity;
import cn.com.cookie.common.jpa.CrudRestService;
import cn.com.cookie.common.reference.AppValid;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @author Cookie
 * History:2016年03月21日 (Cookie) 1.0 Create
 */
public interface AppUserEntityService extends CrudRestService<AppUserEntity,Long> {

    /**
     * 根据账号查询用户对象
     * @param account
     * @param validable
     * @return
     */
    AppUserEntity findByAccountAndValid(String account, String validable);

    /**
     * 根据账号查询有效的用户
     * @param account
     * @return
     */
    AppUserEntity findByAccount(String account);

    /**
     * 获取用户信息，返回给页面
     * @param userId
     * @return
     */
    UserInfo findUserInfo(Long userId);

    /**
     * 注册用户
     * @param registeData
     * @return
     */
    boolean registeUser(RegisteData registeData);
}
