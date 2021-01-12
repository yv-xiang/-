package com.product;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class UserReduce extends Reducer<LongWritable,OrderBean,OrderBean, NullWritable> {
    @Override
    protected void reduce(LongWritable key, Iterable<OrderBean> values, Context context) throws IOException, InterruptedException {
        List<OrderBean> list = new ArrayList<OrderBean>();
        OrderBean user = new OrderBean();
        for (OrderBean ss : values){
            if ("0".equals(ss.getFlag())){
                OrderBean order = new OrderBean();
                    try {
                        BeanUtils.copyProperties(order,ss);
                        list.add(order);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }else {
                try {
                    BeanUtils.copyProperties(user,ss);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (OrderBean ss :list){
            ss.setUserName(user.getUserName());
            context.write(ss,NullWritable.get());
        }
    }
}
