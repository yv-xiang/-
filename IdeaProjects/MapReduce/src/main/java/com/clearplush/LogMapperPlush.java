package com.clearplush;

import com.sun.tools.internal.ws.resources.UtilMessages;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LogMapperPlush extends Mapper<LongWritable, Text, NullWritable,Text> {
    Text k = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        LogBean logBean = parseLine(line);
        if(logBean!=null)

            k.set(line);
            context.write(NullWritable.get(),new Text(logBean.toString()));
    }

    public LogBean parseLine(String line){
        if(line.length()>0){
            String[] arr = line.split(" ");
            if(arr.length>8){
                String ip=arr[0];
                String stime=arr[3].substring(1);
                String statu=arr[8];
                LogBean logBean = new LogBean();
               logBean.setIp(ip);
                logBean.setStime(stime);
                logBean.getStatu(statu);
                return logBean;
            }
        }
        return null;
    }
}
