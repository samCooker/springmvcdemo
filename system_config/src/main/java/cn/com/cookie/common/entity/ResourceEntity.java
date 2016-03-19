package cn.com.cookie.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Cookie on 2016/3/19.
 */
@Entity
@Table(name = "resource", schema = "demo_angular_spring")
public class ResourceEntity {
    private Integer id;
    private String resName;
    private String resDesc;
    private String resType;
    private String resUrl;
    private String authorityName;
    private String valid;
    private Integer parentId;
    private String creator;
    private Date createDate;

    private List<RoleEntity> roleList;

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
     * @return the resName
     */
    @Basic
    @Column(name = "res_name", nullable = true, length = 100)
    public String getResName() {
        return resName;
    }

    /**
     * @param resName the resName to set
     */
    public void setResName(String resName) {
        this.resName = resName;
    }

    /**
     * @return the resDesc
     */
    @Basic
    @Column(name = "res_desc", nullable = true, length = 250)
    public String getResDesc() {
        return resDesc;
    }

    /**
     * @param resDesc the resDesc to set
     */
    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }

    /**
     * @return the resType
     */
    @Basic
    @Column(name = "res_type", nullable = true, length = 45)
    public String getResType() {
        return resType;
    }

    /**
     * @param resType the resType to set
     */
    public void setResType(String resType) {
        this.resType = resType;
    }

    /**
     * @return the resUrl
     */
    @Basic
    @Column(name = "res_url", nullable = false, length = 150)
    public String getResUrl() {
        return resUrl;
    }

    /**
     * @param resUrl the resUrl to set
     */
    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    /**
     * @return the authorityName
     */
    @Basic
    @Column(name = "authority_name", nullable = false, length = 100)
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * @param authorityName the authorityName to set
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
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
     * @return the parentId
     */
    @Basic
    @Column(name = "parent_id", nullable = true)
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the roleList
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resourceList")
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
