package com.friends2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class myMapper extends Mapper<LongWritable, Text,Text,Text> {

    Text k=new Text();
    Text v=new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.读入数据，例如：  A:I,K,C,B,G,F,H,O,D
        String line = value.toString();
        String[] arr = line.split(":");
        //获取用户
        String user=arr[0];
        //获取好友
        String[] friendArr = arr[1].split(",");
        Arrays.sort(friendArr);

        for (int i = 0; i < friendArr.length-1; i++) {
            for (int j = i+1; j < friendArr.length; j++) {
               String Afriend= friendArr[i];
                String Bfriend=friendArr[j];
                String ABfriend=Afriend+"-"+Bfriend;
                k.set(ABfriend);
                v.set(user);
                context.write(k,v);
            }
            
        }
        

    }
}
