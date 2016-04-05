package cn.com.cookie.common.entity;

import cn.com.cookie.common.jpa.IdEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Cookie on 2016/3/19.
 */
@Entity
@Table(name = "role", schema = "demo_angular_spring")
public class RoleEntity  extends IdEntity<Long> {
    @Column(name = "role_name", nullable = false, length = 45)
    private String roleName;
    @Column(name = "role_code", nullable = true, length = 45)
    private String roleCode;
    @Column(name = "role_desc", nullable = true, length = 250)
    private String roleDesc;
    @Column(name = "valid", nullable = true, length = 1)
    private String valid;
    @Column(name = "creator", nullable = true, length = 45)
    private String creator;
    @Column(name = "create_date", nullable = true)
    private Timestamp createDate;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleList")
    private List<AppUserEntity> userList;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_resource", joinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "resource_id", nullable = false, updatable = false) })
    private List<ResourceEntity> resourceList;


    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the roleDesc
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * @param roleDesc the roleDesc to set
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
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
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return the createDate
     */
    public Timestamp getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the userList
     */
    public List<AppUserEntity> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<AppUserEntity> userList) {
        this.userList = userList;
    }

    /**
     * @return the resourceList
     */
    public List<ResourceEntity> getResourceList() {
        return resourceList;
    }

    /**
     * @param resourceList the resourceList to set
     */
    public void setResourceList(List<ResourceEntity> resourceList) {
        this.resourceList = resourceList;
    }

    /**
     * @return the roleCode
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * @param roleCode the roleCode to set
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
