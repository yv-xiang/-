package com.clearplush;

public class LogBean {
    private String ip;
    private String stime;
    private String statu;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getStatu(String statu) {
        return this.statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    @Override
    public String toString() {
        return ip+"\t"+stime+"\t"+statu;
    }
}
