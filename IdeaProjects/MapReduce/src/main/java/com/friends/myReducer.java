package com.friends;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class myReducer extends Reducer<Text,Text,NullWritable,Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        ArrayList<String> list = new ArrayList<String>();
        for (Text s : values) {
            list.add(s.toString());
        }
        String friends = StringUtils.join(list, ",");
        String user = key.toString();
        Text v = new Text(user + ":" + friends);
        context.write(NullWritable.get(),v);

    }
}
