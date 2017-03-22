package com.shanxinj.auth.entity;

import javax.persistence.*;

/**
 * Created by kanglg on 2017/3/22.
 */
@Entity
@Table(name = "sys_ugrp_role_rel", schema = "origin")
@IdClass(SysUgrpRoleRelPK.class)
public class SysUgrpRoleRel {
    private String roleId;
    private String ugrpId;

    @Id
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "UGRP_ID")
    public String getUgrpId() {
        return ugrpId;
    }

    public void setUgrpId(String ugrpId) {
        this.ugrpId = ugrpId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUgrpRoleRel that = (SysUgrpRoleRel) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (ugrpId != null ? !ugrpId.equals(that.ugrpId) : that.ugrpId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (ugrpId != null ? ugrpId.hashCode() : 0);
        return result;
    }
}
