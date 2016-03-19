/*
 * FileName:    AppUserRepository.java
 * Description:
 * Company:
 * Copyright:
 * History:     2016年03月19日 (Cookie) 1.0 Create
 */
package cn.com.cookie.common.repository;

import cn.com.cookie.common.entity.AppUserEntity;

/**
 * @author Cookie
 */
public interface AppUserEntityRepository extends SimpleDomainRepository<AppUserEntity, Long> {

    AppUserEntity findByAccount(String account);
}
