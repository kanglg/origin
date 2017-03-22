package com.shanxinj.auth.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by kanglg on 2017/3/21.
 */
@Entity
@Table(name = "sys_res", schema = "origin")
public class SysRes {
    private String resId;
    private String resName;
    private String resType;
    private Byte avl;
    private String resNo;
    private String upNo;
    private String upNoPath;
    private String prmtDef;
    private Timestamp creTime;

    @Id
    @Column(name = "RES_ID")
    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    @Basic
    @Column(name = "RES_NAME")
    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    @Basic
    @Column(name = "RES_TYPE")
    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
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
    @Column(name = "RES_NO")
    public String getResNo() {
        return resNo;
    }

    public void setResNo(String resNo) {
        this.resNo = resNo;
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
    @Column(name = "UP_NO_PATH")
    public String getUpNoPath() {
        return upNoPath;
    }

    public void setUpNoPath(String upNoPath) {
        this.upNoPath = upNoPath;
    }

    @Basic
    @Column(name = "PRMT_DEF")
    public String getPrmtDef() {
        return prmtDef;
    }

    public void setPrmtDef(String prmtDef) {
        this.prmtDef = prmtDef;
    }

    @Basic
    @Column(name = "CRE_TIME")
    public Timestamp getCreTime() {
        return creTime;
    }

    public void setCreTime(Timestamp creTime) {
        this.creTime = creTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRes sysRes = (SysRes) o;

        if (resId != null ? !resId.equals(sysRes.resId) : sysRes.resId != null) return false;
        if (resName != null ? !resName.equals(sysRes.resName) : sysRes.resName != null) return false;
        if (resType != null ? !resType.equals(sysRes.resType) : sysRes.resType != null) return false;
        if (avl != null ? !avl.equals(sysRes.avl) : sysRes.avl != null) return false;
        if (resNo != null ? !resNo.equals(sysRes.resNo) : sysRes.resNo != null) return false;
        if (upNo != null ? !upNo.equals(sysRes.upNo) : sysRes.upNo != null) return false;
        if (upNoPath != null ? !upNoPath.equals(sysRes.upNoPath) : sysRes.upNoPath != null) return false;
        if (prmtDef != null ? !prmtDef.equals(sysRes.prmtDef) : sysRes.prmtDef != null) return false;
        if (creTime != null ? !creTime.equals(sysRes.creTime) : sysRes.creTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resId != null ? resId.hashCode() : 0;
        result = 31 * result + (resName != null ? resName.hashCode() : 0);
        result = 31 * result + (resType != null ? resType.hashCode() : 0);
        result = 31 * result + (avl != null ? avl.hashCode() : 0);
        result = 31 * result + (resNo != null ? resNo.hashCode() : 0);
        result = 31 * result + (upNo != null ? upNo.hashCode() : 0);
        result = 31 * result + (upNoPath != null ? upNoPath.hashCode() : 0);
        result = 31 * result + (prmtDef != null ? prmtDef.hashCode() : 0);
        result = 31 * result + (creTime != null ? creTime.hashCode() : 0);
        return result;
    }
}
