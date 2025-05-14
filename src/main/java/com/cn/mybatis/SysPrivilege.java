package com.cn.mybatis;

import java.io.Serializable;

/**
 * @TableName sys_privilege
 */
public class SysPrivilege implements Serializable {
    private Long id;

    private String privilegeName;

    private String privilegeUrl;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeUrl() {
        return privilegeUrl;
    }

    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysPrivilege other = (SysPrivilege) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrivilegeName() == null ? other.getPrivilegeName() == null : this.getPrivilegeName().equals(other.getPrivilegeName()))
            && (this.getPrivilegeUrl() == null ? other.getPrivilegeUrl() == null : this.getPrivilegeUrl().equals(other.getPrivilegeUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrivilegeName() == null) ? 0 : getPrivilegeName().hashCode());
        result = prime * result + ((getPrivilegeUrl() == null) ? 0 : getPrivilegeUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", privilegeName=").append(privilegeName);
        sb.append(", privilegeUrl=").append(privilegeUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}