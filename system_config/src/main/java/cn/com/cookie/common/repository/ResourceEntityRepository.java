/*
 * FileName:    ResourceEntityRepository.java
 * Description: 
 * Company:     南宁超创信息工程有限公司
 * Copyright:    ChaoChuang (c) 2016
 * History:     2016年03月19日 (Cookie) 1.0 Create
 */

package cn.com.cookie.common.repository;

import cn.com.cookie.common.entity.ResourceEntity;
import cn.com.cookie.common.jpa.SimpleDomainRepository;

import java.util.List;

/**
 * @author Cookie
 */
public interface ResourceEntityRepository extends SimpleDomainRepository<ResourceEntity, Long> {

    /**
     * 根据是否有效标志查找资源列表
     * @param validat 否有效标志
     * @return
     */
    List<ResourceEntity> findByValid(String validat);
}
