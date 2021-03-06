package com.clearplush;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class LogDriverPlush {
    public static void main(String[] args) throws Exception{
        //1.获取文件配置对象
        Configuration conf = new Configuration();

        //2.根据文件配置对象获取Job对象
        Job job = Job.getInstance(conf);
        //3.引用我们需要执行的类
        job.setJarByClass(LogDriverPlush.class);
        //4.关联所要执行的Map
        job.setMapperClass(LogMapperPlush.class);

        //5.设置Map的数据输出类型
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);

        //6.设置将要处理的文件的路径以及输出结果的路径
        FileInputFormat.setInputPaths(job,new Path(args[0]));

        Path outPath = new Path(args[1]);
        FileSystem fs = FileSystem.get(conf);
        boolean exists = fs.exists(outPath);
        if(exists){
            fs.delete(outPath,true);
        }
        FileOutputFormat.setOutputPath(job,outPath);


        //7.提交job任务
        boolean b = job.waitForCompletion(true);

        System.out.println(b);
    }
}
