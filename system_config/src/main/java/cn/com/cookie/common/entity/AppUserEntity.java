package cn.com.cookie.common.entity;

import cn.com.cookie.common.jpa.IdEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Cookie on 2016/3/19.
 */
@Entity
@Table(name = "app_user", schema = "demo_angular_spring")
public class AppUserEntity extends IdEntity<Long>{
    @Column(name = "account", nullable = false, length = 45)
    private String account;
    @Column(name = "password", nullable = false,length=60)
    private String password;
    @Column(name = "user_name", nullable = true, length = 45)
    private String userName;
    @Column(name = "valid", nullable = true, length = 1)
    private String valid;
    @Column(name = "registe_date", nullable = true)
    private Date registeDate;
    @Column(name = "last_login_date", nullable = true)
    private Date lastLoginDate;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
    private List<RoleEntity> roleList;
    @Transient
    private List<GrantedAuthority> authorities;

    /**
     * @return the account
     */
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

    public List<RoleEntity> getRoleList() {
        return roleList;
    }

    /**
     * @param roleList the roleList to set
     */
    public void setRoleList(List<RoleEntity> roleList) {
        this.roleList = roleList;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
