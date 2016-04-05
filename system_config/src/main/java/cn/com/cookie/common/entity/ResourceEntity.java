package cn.com.cookie.common.entity;

import cn.com.cookie.common.jpa.IdEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Cookie on 2016/3/19.
 */
@Entity
@Table(name = "resource", schema = "demo_angular_spring")
public class ResourceEntity extends IdEntity<Long> {
    @Column(name = "res_name", nullable = true, length = 100)
    private String resName;
    @Column(name = "res_desc", nullable = true, length = 250)
    private String resDesc;
    @Column(name = "res_type", nullable = true, length = 45)
    private String resType;
    @Column(name = "res_url", nullable = false, length = 150)
    private String resUrl;
    @Column(name = "authority_name", nullable = false, length = 100)
    private String authorityName;
    @Column(name = "valid", nullable = true, length = 1)
    private String valid;
    @Column(name = "parent_id", nullable = true)
    private Integer parentId;
    @Column(name = "creator", nullable = true, length = 45)
    private String creator;
    @Column(name = "create_date", nullable = true)
    private Date createDate;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resourceList")
    private List<RoleEntity> roleList;

    /**
     * @return the resName
     */
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
