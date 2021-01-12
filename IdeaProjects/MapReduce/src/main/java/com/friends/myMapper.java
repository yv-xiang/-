package com.friends;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class myMapper extends Mapper<LongWritable, Text,Text,Text> {

    Text k=new Text();
    Text v=new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.读入数据，例如：  A:B,C,D,F,E,O
        String line = value.toString();
        String[] arr = line.split(":");
        //获取用户
        String user=arr[0];
        //获取好友
        String[] friendArr = arr[1].split(",");
        for (String s : friendArr) {
            k.set(s);
            v.set(user);
            context.write(k,v);
        }

    }
}
