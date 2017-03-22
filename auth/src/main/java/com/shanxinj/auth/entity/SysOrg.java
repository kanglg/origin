package com.shanxinj.auth.entity;

import javax.persistence.*;

/**
 * Created by kanglg on 2017/3/21.
 */
@Entity
@Table(name = "sys_org", schema = "origin")
public class SysOrg {
    private String orgId;
    private String orgName;
    private String upNo;
    private String orgNo;
    private Byte avl;
    private String upNoPath;

    @Id
    @Column(name = "ORG_ID")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Basic
    @Column(name = "ORG_NAME")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "UP_NO")
    public String getUpNo() {
        return upNo;
    }

    public void setUpNo(String upNo) {
        this.upNo = upNo;
    }

    @Basic
    @Column(name = "ORG_NO")
    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    @Basic
    @Column(name = "AVL")
    public Byte getAvl() {
        return avl;
    }

    public void setAvl(Byte avl) {
        this.avl = avl;
    }

    @Basic
    @Column(name = "UP_NO_PATH")
    public String getUpNoPath() {
        return upNoPath;
    }

    public void setUpNoPath(String upNoPath) {
        this.upNoPath = upNoPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysOrg sysOrg = (SysOrg) o;

        if (orgId != null ? !orgId.equals(sysOrg.orgId) : sysOrg.orgId != null) return false;
        if (orgName != null ? !orgName.equals(sysOrg.orgName) : sysOrg.orgName != null) return false;
        if (upNo != null ? !upNo.equals(sysOrg.upNo) : sysOrg.upNo != null) return false;
        if (orgNo != null ? !orgNo.equals(sysOrg.orgNo) : sysOrg.orgNo != null) return false;
        if (avl != null ? !avl.equals(sysOrg.avl) : sysOrg.avl != null) return false;
        if (upNoPath != null ? !upNoPath.equals(sysOrg.upNoPath) : sysOrg.upNoPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orgId != null ? orgId.hashCode() : 0;
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (upNo != null ? upNo.hashCode() : 0);
        result = 31 * result + (orgNo != null ? orgNo.hashCode() : 0);
        result = 31 * result + (avl != null ? avl.hashCode() : 0);
        result = 31 * result + (upNoPath != null ? upNoPath.hashCode() : 0);
        return result;
    }
}
