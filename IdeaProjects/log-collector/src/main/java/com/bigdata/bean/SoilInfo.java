package com.bigdata.bean;

public class SoilInfo {
    private String n;
    private String p;
    private String k;
    private String mg;
    private String fe;
    private String zn;
    private String manure;
    private String extend;

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getFe() {
        return fe;
    }

    public void setFe(String fe) {
        this.fe = fe;
    }

    public String getZn() {
        return zn;
    }

    public void setZn(String zn) {
        this.zn = zn;
    }

    public String getManure() {
        return manure;
    }

    public void setManure() {
        int n = Integer.parseInt(getN());
        int p = Integer.parseInt(getP());
        int k = Integer.parseInt(getK());
        //需要施肥的量（单位袋）
        if(n<70){
            this.manure=((70-n)/10)+"";
        }else if(p<100){
            this.manure=((100-p)/10)+"";
        }else if(k<500){
            this.manure=((500-k)/100)+"";
        }else {
            this.manure = "0";
        }

    }
}
