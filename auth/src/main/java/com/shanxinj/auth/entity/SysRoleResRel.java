package com.shanxinj.auth.entity;

import javax.persistence.*;

/**
 * Created by kanglg on 2017/3/21.
 */
@Entity
@Table(name = "sys_role_res_rel", schema = "origin")
@IdClass(SysRoleResRelPK.class)
public class SysRoleResRel {
    private String roleId;
    private String resId;

    @Id
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "RES_ID")
    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleResRel that = (SysRoleResRel) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (resId != null ? !resId.equals(that.resId) : that.resId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (resId != null ? resId.hashCode() : 0);
        return result;
    }
}
