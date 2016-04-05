/*
 * FileName:    AppUserRepository.java
 * Description:
 * Company:
 * Copyright:
 * History:     2016年03月19日 (Cookie) 1.0 Create
 */
package cn.com.cookie.common.repository;

import cn.com.cookie.common.entity.AppUserEntity;
import cn.com.cookie.common.jpa.SimpleDomainRepository;

/**
 * @author Cookie
 */
public interface AppUserEntityRepository extends SimpleDomainRepository<AppUserEntity, Long> {

    /**
     * 根据账号查询用户对象
     * @param account
     * @param validable AppValid字典中定义
     * @return
     */
    AppUserEntity findByAccountAndValid(String account, String validable);
}
