package com.kindstwo;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Arrays;


public class TwoMapper extends Mapper<Text,Text,Text,Text> {
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] friend_person = line.split("\t");
        String friend = friend_person[0];
        String[] person = friend_person[1].split(",");
        Arrays.sort(person);
        for (int i = 0; i <person.length-1 ; i++) {
            for (int j = 0; j <person.length ; j++) {
                context.write(new Text(person[i]+"-"+person[j]),new Text(friend));
            }
        }
    }
}
