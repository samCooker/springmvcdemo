package cn.com.cookie.common.jpa;

/**
 * Created by Cookie on 2016/3/26.
 */
public abstract class SimpleLongIdCrudRestService<T_Entity extends IdEntity<Long>> extends
        SimpleCrudRestService<T_Entity, Long> {
}
