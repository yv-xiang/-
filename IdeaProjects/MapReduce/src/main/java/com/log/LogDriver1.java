package com.log;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class LogDriver1 {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(LogDriver1.class);
        job.setMapperClass(LogMapper.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        Path path = new Path(args[1]);
        FileSystem fileSystem = FileSystem.get(configuration);
        boolean exist = fileSystem.exists(path);
        if (exist){
            fileSystem.delete(path,true);
        }else {
            FileOutputFormat.setOutputPath(job,path);
        }
        job.waitForCompletion(true);
    }
}

