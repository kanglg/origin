package com.shanxinj.auth.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by kanglg on 2017/3/22.
 */
public class SysUgrpRoleRelPK implements Serializable {
    private String roleId;
    private String ugrpId;

    @Column(name = "ROLE_ID")
    @Id
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name = "UGRP_ID")
    @Id
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

        SysUgrpRoleRelPK that = (SysUgrpRoleRelPK) o;

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
