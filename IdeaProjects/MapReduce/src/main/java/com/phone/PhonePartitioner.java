package com.phone;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class PhonePartitioner extends Partitioner<Text,Phone> {
    @Override
    public int getPartition(Text key, Phone value, int numPartitions) {

        String substring = key.toString().substring(0,3);
        int partition = 0;
        if ("136".equals(substring)){
            partition = 1;
        }else if ("137".equals(substring)){
            partition = 2;
        }else if ("138".equals(substring)){
            partition = 3;
        }else if ("139".equals(substring)){
            partition = 4;
        }
        return partition;

    }
}
