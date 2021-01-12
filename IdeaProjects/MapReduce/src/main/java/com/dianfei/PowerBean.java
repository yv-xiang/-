package com.dianfei;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PowerBean implements WritableComparable<PowerBean> {

    private int userid;
    private String month;
    private double fee;

    public PowerBean() {
    }

    public PowerBean(int userid, String month, double fee) {
        this.userid = userid;
        this.month = month;
        this.fee = fee;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return userid+"\t"+month+"\t"+fee;

    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(userid);
        dataOutput.writeUTF(month);
        dataOutput.writeDouble(fee);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        userid = dataInput.readInt();
        month = dataInput.readUTF();
        fee = dataInput.readDouble();
    }

    @Override
    public int compareTo(PowerBean o) {
        int res1 = 0;
        if (this.getUserid()>o.getUserid()){
            res1 = 1;
        }else if (this.getUserid()<o.getUserid()){
            res1 = -1;
        }else {
            int res2 = 0;
            if (this.getFee()>o.getFee()){
                res2 = -1;
            }else if (this.getFee()<o.getFee()){
                res2 = 1 ;
            }
            return res2;
        }
        return res1;
    }
}
