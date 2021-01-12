package com.product;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

public class UserDriver {
    public static void main(String[] args) throws Exception{
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(UserDriver.class);
        job.setMapperClass(UserMapper.class);
        job.setReducerClass(UserReduce.class);
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(OrderBean.class);
        job.setOutputKeyClass(OrderBean.class);
        job.setOutputValueClass(NullWritable.class);
        FileInputFormat.setInputPaths(job,new Path("E:\\temp\\InputStream\\product"));
        Path path = new Path("E:\\temp\\OutputStream\\product");
        FileSystem fileSystem = FileSystem.get(configuration);
        boolean exists = fileSystem.exists(path);
        if (exists){
            fileSystem.delete(path,true);
        }
        FileOutputFormat.setOutputPath(job,path);
        boolean b = job.waitForCompletion(true);
        System.out.println(b);

    }
}
