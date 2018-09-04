package com.bo.bean;

import java.util.List;

public class CartItrmVo extends Cartitem {
    private Integer cid;
   private List<String> list;

    @Override
    public Integer getCid() {
        return cid;
    }

    @Override
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
