package com.bo.bean;

public class TAuth {
    private Integer authid;

    private String authname;

    private String authpath;

    private Integer parentid;

    private String authdis;

    private String state;

    private String iconcls;

    public Integer getAuthid() {
        return authid;
    }

    public void setAuthid(Integer authid) {
        this.authid = authid;
    }

    public String getAuthname() {
        return authname;
    }

    public void setAuthname(String authname) {
        this.authname = authname == null ? null : authname.trim();
    }

    public String getAuthpath() {
        return authpath;
    }

    public void setAuthpath(String authpath) {
        this.authpath = authpath == null ? null : authpath.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getAuthdis() {
        return authdis;
    }

    public void setAuthdis(String authdis) {
        this.authdis = authdis == null ? null : authdis.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls == null ? null : iconcls.trim();
    }
}