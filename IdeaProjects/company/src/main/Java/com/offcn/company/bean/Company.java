package com.offcn.company.bean;

import java.util.Date;

public class Company {
    private Integer tid;
    private String tname;
    private String tsex;
    private Date tregisterDate;
    private Integer tdeptId;
    private Integer id;
    private String location;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public Date getTregisterDate() {
        return tregisterDate;
    }

    public void setTregisterDate(Date tregisterDate) {
        this.tregisterDate = tregisterDate;
    }

    public Integer getTdeptId() {
        return tdeptId;
    }

    public void setTdeptId(Integer tdeptId) {
        this.tdeptId = tdeptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Company{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tregisterDate=" + tregisterDate +
                ", tdeptId=" + tdeptId +
                ", id=" + id +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
