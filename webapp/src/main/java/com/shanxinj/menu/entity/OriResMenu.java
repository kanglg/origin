package com.shanxinj.menu.entity;

import javax.persistence.*;

/**
 * Created by kanglg on 2017/3/22.
 */
@Entity
@Table(name = "ori_res_menu", schema = "origin")
public class OriResMenu {
    private String menuId;
    private String menuName;
    private String extInfo;
    private String path;
    private String upId;
    private String upIdPath;
    private Integer ordrNum;
    private String resId;

    @Id
    @Column(name = "MENU_ID")
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "MENU_NAME")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "EXT_INFO")
    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    @Basic
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "UP_ID")
    public String getUpId() {
        return upId;
    }

    public void setUpId(String upId) {
        this.upId = upId;
    }

    @Basic
    @Column(name = "UP_ID_PATH")
    public String getUpIdPath() {
        return upIdPath;
    }

    public void setUpIdPath(String upIdPath) {
        this.upIdPath = upIdPath;
    }

    @Basic
    @Column(name = "ORDR_NUM")
    public Integer getOrdrNum() {
        return ordrNum;
    }

    public void setOrdrNum(Integer ordrNum) {
        this.ordrNum = ordrNum;
    }

    @Basic
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

        OriResMenu that = (OriResMenu) o;

        if (menuId != null ? !menuId.equals(that.menuId) : that.menuId != null) return false;
        if (menuName != null ? !menuName.equals(that.menuName) : that.menuName != null) return false;
        if (extInfo != null ? !extInfo.equals(that.extInfo) : that.extInfo != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (upId != null ? !upId.equals(that.upId) : that.upId != null) return false;
        if (upIdPath != null ? !upIdPath.equals(that.upIdPath) : that.upIdPath != null) return false;
        if (ordrNum != null ? !ordrNum.equals(that.ordrNum) : that.ordrNum != null) return false;
        if (resId != null ? !resId.equals(that.resId) : that.resId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = menuId != null ? menuId.hashCode() : 0;
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        result = 31 * result + (extInfo != null ? extInfo.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (upId != null ? upId.hashCode() : 0);
        result = 31 * result + (upIdPath != null ? upIdPath.hashCode() : 0);
        result = 31 * result + (ordrNum != null ? ordrNum.hashCode() : 0);
        result = 31 * result + (resId != null ? resId.hashCode() : 0);
        return result;
    }
}
