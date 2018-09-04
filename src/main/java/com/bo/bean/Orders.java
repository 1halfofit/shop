package com.bo.bean;

import java.util.Date;
import java.util.List;

public class Orders {

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private List<Orderitem> orderitem;

    public List<Orderitem> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(List<Orderitem> orderitem) {
        this.orderitem = orderitem;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    private String pd_frpId;

    private String oid;

    private Date ordertime;

    private Double total;

    private String state;

    private String address;

    private String name;

    private String telephone;

    private String uid;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public Date getOrdertime(Date date) {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getPd_frpId() {
        return pd_frpId;
    }

    public void setPd_frpId(String pd_frpId) {
        this.pd_frpId = pd_frpId;
    }
}