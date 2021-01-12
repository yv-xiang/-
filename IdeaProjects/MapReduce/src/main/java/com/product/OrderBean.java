package com.product;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderBean implements Writable {
    private long orderid;
    private String productName;
    private int userid;
    private String userName;
    private String flag;

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public OrderBean() {
    }

    public OrderBean(long orderid, String productName, int userid, String userName, String flag) {
        this.orderid = orderid;
        this.productName = productName;
        this.userid = userid;
        this.userName = userName;
        this.flag = flag;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(orderid);
        dataOutput.writeUTF(productName);
        dataOutput.writeInt(userid);
        dataOutput.writeUTF(userName);
        dataOutput.writeUTF(flag);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

        this.orderid = dataInput.readLong();
        this.productName = dataInput.readUTF();
        this.userid = dataInput.readInt();
        this.userName = dataInput.readUTF();
        this.flag = dataInput.readUTF();
    }
    @Override
    public String toString() {
        return orderid+"\t"+productName+"\t"+userName;
    }
}
