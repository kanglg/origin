package com.shanxinj.auth.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by kanglg on 2017/3/22.
 */
public class SysUserUgrpRelPK implements Serializable {
    private String userId;
    private String ugrpId;

    @Column(name = "USER_ID")
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

        SysUserUgrpRelPK that = (SysUserUgrpRelPK) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (ugrpId != null ? !ugrpId.equals(that.ugrpId) : that.ugrpId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (ugrpId != null ? ugrpId.hashCode() : 0);
        return result;
    }
}
