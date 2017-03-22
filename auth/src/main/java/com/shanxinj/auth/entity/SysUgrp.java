package com.shanxinj.auth.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by kanglg on 2017/3/22.
 */
@Entity
@Table(name = "sys_ugrp", schema = "origin")
public class SysUgrp {
    private String ugrpId;
    private String ugrpName;
    private Timestamp creDate;

    @Id
    @Column(name = "UGRP_ID")
    public String getUgrpId() {
        return ugrpId;
    }

    public void setUgrpId(String ugrpId) {
        this.ugrpId = ugrpId;
    }

    @Basic
    @Column(name = "UGRP_NAME")
    public String getUgrpName() {
        return ugrpName;
    }

    public void setUgrpName(String ugrpName) {
        this.ugrpName = ugrpName;
    }

    @Basic
    @Column(name = "CRE_DATE")
    public Timestamp getCreDate() {
        return creDate;
    }

    public void setCreDate(Timestamp creDate) {
        this.creDate = creDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUgrp sysUgrp = (SysUgrp) o;

        if (ugrpId != null ? !ugrpId.equals(sysUgrp.ugrpId) : sysUgrp.ugrpId != null) return false;
        if (ugrpName != null ? !ugrpName.equals(sysUgrp.ugrpName) : sysUgrp.ugrpName != null) return false;
        if (creDate != null ? !creDate.equals(sysUgrp.creDate) : sysUgrp.creDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ugrpId != null ? ugrpId.hashCode() : 0;
        result = 31 * result + (ugrpName != null ? ugrpName.hashCode() : 0);
        result = 31 * result + (creDate != null ? creDate.hashCode() : 0);
        return result;
    }
}
