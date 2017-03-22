package com.shanxinj.auth.entity;

import javax.persistence.*;

/**
 * Created by kanglg on 2017/3/21.
 */
@Entity
@Table(name = "sys_role", schema = "origin")
public class SysRole {
    private String roleId;
    private String roleName;
    private String remark;
    private Byte avl;
    private String roleNo;

    @Id
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
    @Column(name = "ROLE_NO")
    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRole sysRole = (SysRole) o;

        if (roleId != null ? !roleId.equals(sysRole.roleId) : sysRole.roleId != null) return false;
        if (roleName != null ? !roleName.equals(sysRole.roleName) : sysRole.roleName != null) return false;
        if (remark != null ? !remark.equals(sysRole.remark) : sysRole.remark != null) return false;
        if (avl != null ? !avl.equals(sysRole.avl) : sysRole.avl != null) return false;
        if (roleNo != null ? !roleNo.equals(sysRole.roleNo) : sysRole.roleNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (avl != null ? avl.hashCode() : 0);
        result = 31 * result + (roleNo != null ? roleNo.hashCode() : 0);
        return result;
    }
}
