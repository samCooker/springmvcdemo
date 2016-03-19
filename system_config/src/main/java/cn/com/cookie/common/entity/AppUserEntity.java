package cn.com.cookie.common.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Cookie on 2016/3/19.
 */
@Entity
@Table(name = "app_user", schema = "demo_angular_spring")
public class AppUserEntity {
    private Integer id;
    private String account;
    private String userName;
    private String valid;
    private Date registeDate;
    private Date lastLoginDate;

    private List<RoleEntity> roleList;
    private List<GrantedAuthority> authorities;

    /**
     * @return the id
     */
    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the account
     */
    @Basic
    @Column(name = "account", nullable = false, length = 45)
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the userName
     */
    @Basic
    @Column(name = "user_name", nullable = true, length = 45)
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the valid
     */
    @Basic
    @Column(name = "valid", nullable = true, length = 1)
    public String getValid() {
        return valid;
    }

    /**
     * @param valid the valid to set
     */
    public void setValid(String valid) {
        this.valid = valid;
    }

    /**
     * @return the registeDate
     */
    @Basic
    @Column(name = "registe_date", nullable = true)
    public Date getRegisteDate() {
        return registeDate;
    }

    /**
     * @param registeDate the registeDate to set
     */
    public void setRegisteDate(Date registeDate) {
        this.registeDate = registeDate;
    }

    /**
     * @return the lastLoginDate
     */
    @Basic
    @Column(name = "last_login_date", nullable = true)
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * @param lastLoginDate the lastLoginDate to set
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * @return the authorities
     */
    @Transient
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * @param authorities the authorities to set
     */
    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    /**
     * @return the roleList
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
    public List<RoleEntity> getRoleList() {
        return roleList;
    }

    /**
     * @param roleList the roleList to set
     */
    public void setRoleList(List<RoleEntity> roleList) {
        this.roleList = roleList;
    }
}
