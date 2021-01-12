package com.productmap;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MapperMap extends Mapper<LongWritable, Text,Text, NullWritable> {
    Map<String,String> map = new HashMap<String, String>();
    @SuppressWarnings("resource")
    @Override
    protected void setup(Context context)
            throws IOException, InterruptedException {
        // 1 读取缓存文件
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/test/mapjoinnew/user/user.txt"), "UTF-8"));
        String line = null;
        while((line = br.readLine()) != null){
            //19156	张三
            //2 将用户数据用tab键分割，将userid和username分别当作key和value存入Map<userid,username>
            String[] split = line.split("\t");
            map.put(split[0], split[1]);
        }
        //3 关闭资源
        br.close();

    }
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1 读取一行，将其转换为字符串 20010203001	手机	19156
        String line = value.toString();
        // 2 按照tab键分割，挑出每个订单中的userid
        String[] split = line.split("\t");
        // 3 根据userid，去usermap寻找用户名信息，设置到订单数据中
        String username = map.get(split[2]);
        split[2] = username;
        // 4 将带有用户名的订单组装kv并写出
        String join = StringUtils.join(split, "\t");
        context.write(new Text(join), NullWritable.get());
    }

}
