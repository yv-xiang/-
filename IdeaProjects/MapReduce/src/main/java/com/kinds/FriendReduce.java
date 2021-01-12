package com.kinds;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FriendReduce extends Reducer<Text,Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        List<String> list = new ArrayList();
        for (Text value :values){
            list.add(value.toString());
        }
        String join = StringUtils.join(list.toArray(), ",");
        context.write(key,new Text(join));
    }
}
