package com.bao;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class Phone implements Writable {

    //套餐基本费
    private long baseFee;
    //语音通讯费
    private long communicateFee;
    //短信彩信费
    private long msgFee;
    //流量费
    private long flowFee;
    //总费用
    private long sumFee;

    public Phone() {

    }

    public Phone(long baseFee, long communicateFee, long msgFee, long flowFee, long sumFee) {
        this.baseFee = baseFee;
        this.communicateFee = communicateFee;
        this.msgFee = msgFee;
        this.flowFee = flowFee;
        this.sumFee = sumFee;
    }

    public void setFee(long baseFee, long communicateFee, long msgFee, long flowFee) {
        this.baseFee = baseFee;
        this.communicateFee = communicateFee;
        this.msgFee = msgFee;
        this.flowFee = flowFee;
        this.sumFee = baseFee + communicateFee + msgFee + flowFee  ;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
       dataOutput.writeLong(baseFee);
       dataOutput.writeLong(communicateFee);
       dataOutput.writeLong(msgFee);
       dataOutput.writeLong(flowFee);
       dataOutput.writeLong(sumFee);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        baseFee = dataInput.readLong();
        communicateFee = dataInput.readLong();
        msgFee = dataInput.readLong();
        flowFee = dataInput.readLong();
        sumFee = dataInput.readLong();
    }

    @Override
    public String toString() {
        return baseFee+"\t"+communicateFee+"\t"+msgFee+"\t"+flowFee+"\t"+sumFee;
    }

    public long getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(long baseFee) {
        this.baseFee = baseFee;
    }

    public long getCommunicateFee() {
        return communicateFee;
    }

    public void setCommunicateFee(long communicateFee) {
        this.communicateFee = communicateFee;
    }

    public long getMsgFee() {
        return msgFee;
    }

    public void setMsgFee(long msgFee) {
        this.msgFee = msgFee;
    }

    public long getFlowFee() {
        return flowFee;
    }

    public void setFlowFee(long flowFee) {
        this.flowFee = flowFee;
    }

    public long getSumFee() {
        return sumFee;
    }

    public void setSumFee(long sumFee) {
        this.sumFee = sumFee;
    }
}
