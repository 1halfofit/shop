package com.bo.bean;

public class Productdetail {
    private Integer id;

    private String dis;

    private String imagepath;

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

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }
}