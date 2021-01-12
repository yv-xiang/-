package com.dianfei;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator {
    public GroupingComparator(){

        super(PowerBean.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {


        PowerBean aa = (PowerBean) a;
        PowerBean bb = (PowerBean) b;
        int res1 = 0;
        if (aa.getUserid()>bb.getUserid()){
            res1 = 0;
        }else if (aa.getUserid()<bb.getUserid()){
            res1 = -1;
        }
        return res1;
    }
}
