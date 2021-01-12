package com.kinds;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FriendMapper extends Mapper<LongWritable, Text,Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] filed = line.split(":");
        String person = filed[0];
        String[] friends = filed[1].split(",");
        for(String friend : friends){
            context.write(new Text(friend),new Text(person));
        }
    }
}
