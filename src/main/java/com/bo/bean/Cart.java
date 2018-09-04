package com.bo.bean;

public class Cart {
    private Integer cid;

    private String cdis;

    private String uid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCdis() {
        return cdis;
    }

    public void setCdis(String cdis) {
        this.cdis = cdis == null ? null : cdis.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}