package com.bao;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMapper extends Mapper<LongWritable,Text,Text,Phone> {

    Text k = new Text();
    Phone v = new Phone();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split("\t");
        String phoneNum = split[1];
        k.set(phoneNum);
        long baseFee = Long.parseLong(split[2]);
        long communicateFee = Long.parseLong(split[3]);
        long msgFee = Long.parseLong(split[4]);
        long flowFee = Long.parseLong(split[5]);
        v.setFee(baseFee,communicateFee,msgFee,flowFee);
        context.write(k,v);
    }
}
