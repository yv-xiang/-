package com.phone;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MyReducer extends Reducer<Text, Phone,Text, Phone> {

    Phone v = new Phone();
    @Override
    protected void reduce(Text key, Iterable<Phone> values, Context context) throws IOException, InterruptedException {
        long baseFeeSum = 0;
        long commicateFeeSum = 0;
        long msgFeeSum = 0;
        long flowFeeSum = 0;
        for (Phone ss : values){
            baseFeeSum = baseFeeSum +ss.getBaseFee();
            commicateFeeSum = commicateFeeSum +ss.getCommunicateFee();
            msgFeeSum = msgFeeSum + ss.getMsgFee();
            flowFeeSum =flowFeeSum +ss.getFlowFee();

        }
        v.setFee(baseFeeSum,commicateFeeSum,msgFeeSum,flowFeeSum);
        context.write(key,v);

    }
}
