package com.github.duychuongvn.core.jpa.auditing;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Created by huynhduychuong on Oct 2, 2016.
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class AbstractAuditableEntity implements Serializable {
    @CreatedDate
    private Date created;
    @LastModifiedDate
    @Column(name = "last_updated")
    private Date lastUpdated;

    @CreatedBy
    @Column(name = "created_by")
    private String createBy;
    @LastModifiedBy
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Version
    private Integer versionNo;
    private boolean deleted;
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
    public Integer getVersionNo() {
        return versionNo;
    }
    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }
    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    
}
