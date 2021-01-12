package com.kinds;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FriendDriver {

    public static void main(String[] args) throws Exception{
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(FriendDriver.class);
        job.setMapperClass(FriendMapper.class);
        job.setReducerClass(FriendReduce.class);
        job.setMapOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        Path path = new Path(args[1]);
        FileSystem fileSystem = FileSystem.get(configuration);
        boolean exists = fileSystem.exists(path);
        if (exists){
            fileSystem.delete(path,true);
        }
        FileOutputFormat.setOutputPath(job,path);
        System.out.println(job.waitForCompletion(true));



    }
}
