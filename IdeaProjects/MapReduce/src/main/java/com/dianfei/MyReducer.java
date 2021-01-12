package com.dianfei;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MyReducer extends Reducer<PowerBean, NullWritable,PowerBean,NullWritable> {
    @Override
    protected void reduce(PowerBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {

        context.write(key,NullWritable.get());
    }
}
