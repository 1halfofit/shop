package com.bo.bean;

public class Evaluate {
    private Integer id;

    private String dis;

    private String username;

    private String pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis == null ? null : dis.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }
}