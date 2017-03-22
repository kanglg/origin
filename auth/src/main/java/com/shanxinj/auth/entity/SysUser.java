package com.shanxinj.auth.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by kanglg on 2017/3/21.
 */
@Entity
@Table(name = "sys_user", schema = "origin")
public class SysUser {
    private String userId;
    private String username;
    private String password;
    private String orgId;
    private Byte avl;
    private Timestamp creDate;
    private Timestamp lastUpdtDate;

    @Id
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ORG_ID")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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
    @Column(name = "CRE_DATE")
    public Timestamp getCreDate() {
        return creDate;
    }

    public void setCreDate(Timestamp creDate) {
        this.creDate = creDate;
    }

    @Basic
    @Column(name = "LAST_UPDT_DATE")
    public Timestamp getLastUpdtDate() {
        return lastUpdtDate;
    }

    public void setLastUpdtDate(Timestamp lastUpdtDate) {
        this.lastUpdtDate = lastUpdtDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUser sysUser = (SysUser) o;

        if (userId != null ? !userId.equals(sysUser.userId) : sysUser.userId != null) return false;
        if (username != null ? !username.equals(sysUser.username) : sysUser.username != null) return false;
        if (password != null ? !password.equals(sysUser.password) : sysUser.password != null) return false;
        if (orgId != null ? !orgId.equals(sysUser.orgId) : sysUser.orgId != null) return false;
        if (avl != null ? !avl.equals(sysUser.avl) : sysUser.avl != null) return false;
        if (creDate != null ? !creDate.equals(sysUser.creDate) : sysUser.creDate != null) return false;
        if (lastUpdtDate != null ? !lastUpdtDate.equals(sysUser.lastUpdtDate) : sysUser.lastUpdtDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (avl != null ? avl.hashCode() : 0);
        result = 31 * result + (creDate != null ? creDate.hashCode() : 0);
        result = 31 * result + (lastUpdtDate != null ? lastUpdtDate.hashCode() : 0);
        return result;
    }
}
