package com.clear;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LogMapper extends Mapper<LongWritable, Text,Text, NullWritable> {
    Text k = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        boolean b = parseLine(line);
        if(b) {
            return;
        }
        k.set(line);
        context.write(value,NullWritable.get());
    }

    public boolean parseLine(String line){
        if(line.length()>0){
            String[] arr = line.split(" ");
            if(arr.length>11){
                return true;
            }
        }
        return false;
    }


}
