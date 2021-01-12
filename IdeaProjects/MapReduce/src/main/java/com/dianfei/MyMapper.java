package com.dianfei;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMapper extends Mapper<LongWritable, Text,PowerBean, NullWritable> {

    PowerBean k =new PowerBean();
    NullWritable v = NullWritable.get();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split("\t");
        String userid = split[0];
        String month = split[1];
        String fee = split[2];
        k.setUserid(Integer.parseInt(userid));
        k.setMonth(month);
        k.setFee(Double.parseDouble(fee));
        context.write(k,v);

    }
}
