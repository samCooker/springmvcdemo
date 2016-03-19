package cn.com.cookie.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Cookie on 2016/3/19.
 */
@Entity
@Table(name = "role", schema = "demo_angular_spring")
public class RoleEntity {
    private Integer id;
    private String roleName;
    private String roleDesc;
    private String valid;
    private String creator;
    private Timestamp createDate;

    private List<AppUserEntity> userList;
    private List<ResourceEntity> resourceList;

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
     * @return the roleName
     */
    @Basic
    @Column(name = "role_name", nullable = false, length = 45)
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
    @Basic
    @Column(name = "role_desc", nullable = true, length = 250)
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
     * @return the creator
     */
    @Basic
    @Column(name = "creator", nullable = true, length = 45)
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
    @Basic
    @Column(name = "create_date", nullable = true)
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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleList")
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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_resource", joinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "resource_id", nullable = false, updatable = false) })
    public List<ResourceEntity> getResourceList() {
        return resourceList;
    }

    /**
     * @param resourceList the resourceList to set
     */
    public void setResourceList(List<ResourceEntity> resourceList) {
        this.resourceList = resourceList;
    }
}
