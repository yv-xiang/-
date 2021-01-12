package com.product;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;


import java.io.IOException;

public class UserMapper  extends Mapper<LongWritable, Text, LongWritable, OrderBean> {

    LongWritable k = new LongWritable();
    OrderBean v = new OrderBean();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        FileSplit fs = (FileSplit) context.getInputSplit();
        String filename = fs.getPath().getName();
        String line = value.toString();
        String[] split = line.split("\t");
        if (filename.startsWith("order")){
            v.setOrderid(Long.parseLong(split[0]));
            v.setProductName(split[1]);
            v.setUserid(Integer.parseInt(split[2]));
            v.setUserName("");
            v.setFlag("0");
        }else {
            v.setOrderid(0);
            v.setProductName("");
            v.setUserid(Integer.parseInt(split[0]));
            v.setUserName(split[1]);
            v.setFlag("1");
        }
       k.set(v.getOrderid());
        context.write(k,v);
    }
}
