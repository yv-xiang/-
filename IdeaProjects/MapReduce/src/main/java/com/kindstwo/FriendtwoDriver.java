package com.kindstwo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FriendtwoDriver {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(FriendtwoDriver.class);
        // 4 指定map输出的数据类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        // 5 指定最终输出的数据类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // 6 指定job的输入原始所在目录
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        Path path = new Path(args[1]);
        FileSystem fileSystem = FileSystem.get(configuration);
        boolean exists = fileSystem.exists(path);
        if (exists){
            fileSystem.delete(path,true);
        }
        FileOutputFormat.setOutputPath(job,path);
        // 7 提交
        boolean result = job.waitForCompletion(true);

        System.exit(result?1:0);

    }
}
