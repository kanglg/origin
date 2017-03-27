package com.shanxinj.login.web.vo;

/**
 * Created by kanglg on 2017/3/24.
 */
public class AuthUserVO {
    private String username;
    private String roleName;
    private String orgName;

    public AuthUserVO(String username, String roleName, String orgName) {
        this.username = username;
        this.roleName = roleName;
        this.orgName = orgName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}