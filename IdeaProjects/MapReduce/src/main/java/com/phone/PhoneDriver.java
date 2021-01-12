package com.phone;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class PhoneDriver {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(PhoneDriver.class);
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Phone.class);
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Phone.class);
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        Path path = new Path(args[1]);
        FileSystem fileSystem = FileSystem.get(configuration);
        boolean exists = fileSystem.exists(path);
        if (exists){
            fileSystem.delete(path,true);
        }
        FileOutputFormat.setOutputPath(job,path);
        job.setPartitionerClass(PhonePartitioner.class);
        job.setNumReduceTasks(5);
        boolean waitForCompletion = job.waitForCompletion(true);
        System.out.println(waitForCompletion);

    }
}
