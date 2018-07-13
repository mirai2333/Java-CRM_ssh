package com.sshlearn.domain;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    @Expose
    private Long cust_id;
    @Expose
    private String cust_name;
    @Expose
    private String cust_level;

    @Expose(serialize = false,deserialize = false)
    private Set<Linkman> linkmens = new HashSet<Linkman>();

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_level() {
        return cust_level;
    }

    public void setCust_level(String cust_level) {
        this.cust_level = cust_level;
    }

    public Set<Linkman> getLinkmens() {
        return linkmens;
    }

    public void setLinkmens(Set<Linkman> linkmens) {
        this.linkmens = linkmens;
    }
}