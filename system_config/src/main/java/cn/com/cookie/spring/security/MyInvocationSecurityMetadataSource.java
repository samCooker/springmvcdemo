package cn.com.cookie.spring.security;

import java.util.*;

import cn.com.cookie.common.entity.AppUserEntity;
import cn.com.cookie.common.entity.ResourceEntity;
import cn.com.cookie.common.reference.AppValid;
import cn.com.cookie.common.repository.AppUserEntityRepository;
import cn.com.cookie.common.repository.ResourceEntityRepository;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import cn.com.cookie.spring.tools.AntUrlPathMatcher;
import cn.com.cookie.spring.tools.UrlMatcher;

import javax.inject.Inject;

public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private UrlMatcher                                      urlMatcher  = new AntUrlPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    @Autowired
    private ResourceEntityRepository resourceEntityRepository;
    @Value("${spring.security.enabled}")
    private String  securityEnable;

    /**
     * tomcat启动时实例化一次
     */
    public MyInvocationSecurityMetadataSource() {
    }

    /**
     * 初始化所有url和权限（或角色）的对应关系
     */
    private void initResource() {
        if (resourceMap==null) {
            resourceMap = new HashMap<>();
            List<ResourceEntity> resourceEntityList = resourceEntityRepository.findByValid(AppValid.有效.getKey());
            ConfigAttribute ca = null;
            Collection<ConfigAttribute> value = null;
            for (ResourceEntity resource : resourceEntityList) {
                String name = resource.getAuthorityName();
                String url = resource.getResUrl();
                ca = new SecurityConfig(name);
                value = new ArrayList<>();
                value.add(ca);
                resourceMap.put(url, value);
            }
        }
    }

    /**
     * 参数是要访问的url，返回这个url对于的所有权限（或角色）
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if ("true".equals(securityEnable)) {
            this.initResource();
            // 将参数转为url
            String url = ((FilterInvocation) object).getRequestUrl();
            Iterator<String> ite = resourceMap.keySet().iterator();
            while (ite.hasNext()) {
                String resURL = ite.next();
                if (urlMatcher.pathMatchesUrl(resURL, url)) {
                    return resourceMap.get(resURL);
                }
            }
            throw new AccessDeniedException("forbidden");
        }
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }


}
