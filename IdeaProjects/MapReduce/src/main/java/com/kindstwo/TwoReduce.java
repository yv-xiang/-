package com.kindstwo;

import org.apache.avro.generic.GenericData;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TwoReduce extends Reducer<Text,Text,Text,Text> {
    Text v = new Text();
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        List<String> list = new ArrayList();
        for (Text value : values){
            String f = value.toString();
            list.add(f);
        }
        String friends = StringUtils.join(list.toArray(), ",");
        v.set(friends);
        context.write(key,v);


    }
}
