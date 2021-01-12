package com.dianfei;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver {
    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(Driver.class);
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);
        job.setMapOutputKeyClass(PowerBean.class);
        job.setMapOutputValueClass(NullWritable.class);
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        Path path = new Path(args[1]);
        FileSystem fileSystem = FileSystem.get(configuration);
        boolean exists = fileSystem.exists(path);
        if (exists){
            fileSystem.delete(path,true);
        }
        FileOutputFormat.setOutputPath(job,path);
        job.setGroupingComparatorClass(GroupingComparator.class);
        boolean b = job.waitForCompletion(true);
        System.out.println(b);
    }
}
