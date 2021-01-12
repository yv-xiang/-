package com.bigdata.bean;

public class SoilDamp {
    private String soilsd;
    private String ph;
    private String irrigate;
    private String extend;

    public String getSoilsd() {
        return soilsd;
    }

    public void setSoilsd(String soilsd) {
        this.soilsd = soilsd;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getIrrigate() {
        return irrigate;
    }

    public void setIrrigate() {
        int i = Integer.parseInt(getSoilsd());
        if(70-i>0){
            //需要浇灌水量（单位方）
            this.irrigate=(2*(70-i))+"";
        }else {
            this.irrigate = "0";
        }

    }
}
