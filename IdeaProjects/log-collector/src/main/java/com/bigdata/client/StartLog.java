package com.bigdata.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bigdata.bean.*;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.bigdata.client.GetLogs.*;


public class StartLog {
    // private final static Logger logger = LoggerFactory.getLogger(StartLog.class);
    private final static Logger logger = Logger.getLogger(StartLog.class);

    //传感器厂商列表
    private static List<String> companyList = new ArrayList<String>();
    //方位列表
    private static List<String> locList = new ArrayList<String>();
    //语言列表
    private static List<String> lList = new ArrayList<String>();
    //地址列表
    private static List<String> aList = new ArrayList<String>();
    //传输方式列表
    private static List<String> tList = new ArrayList<String>();
    //供电方式列表
    private static List<String> pList = new ArrayList<String>();
    //种植作物列表
    private static List<String> prodList = new ArrayList<String>();

    static {
        companyList.add("Texas Instruments 德州仪器");
        companyList.add("Bosch 博世");
        companyList.add("ST 意法半导体");
        companyList.add("Avago Technologies 安华高");
        companyList.add("Hewlett Packard 惠普");
        locList.add("东边");
        locList.add("西边");
        locList.add("南边");
        locList.add("北边");
        lList.add("cn");
        lList.add("en");
        lList.add("jp");
        aList.add("山东寿光");
        aList.add("山东章丘");
        aList.add("山东泰安");
        aList.add("山东德州");
        tList.add("2.4G");
        tList.add("5G");
        tList.add("3G");
        tList.add("bluetooth");
        pList.add("3.3VDC");
        pList.add("5VDC");
        pList.add("3.3DC");
        pList.add("5DC");
        prodList.add("西红柿");
        prodList.add("豆角");
        prodList.add("茄子");
        prodList.add("大蒜");
        prodList.add("土豆");
    }


    public static void main(String[] args) {
        // 参数一：控制发送每条的延时时间，默认是0
        Long delay = args.length > 0 ? Long.parseLong(args[0]):0L;
        //参数二：获取多久时间内的数据(单位小时)
        int loop_len=args.length > 1 ? Integer.parseInt(args[1])*60*60:60*60;
        //参数三：日志保存路径，如/datas/logs/
        String path=args.length > 2 ?args[2]:"/var/";
        // 生成数据
        generateLog(delay,loop_len,path);
    }

    private static void generateLog(Long delay, int loop_len,String path) {
        while (true){
            //数据的uuid
            UUID uuid = UUID.randomUUID();
            //数据的获取时间
            Timestamp time = Timestamp.from(Instant.now().minusSeconds(loop_len));
            String dateStr = time.toLocalDateTime().toLocalDate().toString();
//根据日期不同将数据写到对应的文件中
            SetLogFileName(path,dateStr);
            //模拟数据的线程号
            int randomThread = 190+(int) (Math.random()*10);
            StringBuffer buffer = new StringBuffer();
            buffer.append(time).append("[http-nio-8080-exec-").append(randomThread)
                    .append("] INFO com.bigdata.service.LogServiceImpl-[").append(uuid).append("]-");

            //应用启动
            SensorStart start = GetLogs.generateStart(lList,locList,companyList,aList,tList,pList,prodList,time);
            String jsonString = JSON.toJSONString(start);

            //System.out.println(buffer.toString() +jsonString);
            //控制台打印
            logger.info(buffer.toString()+jsonString);

            JSONObject json = new JSONObject();
            JSONObject comFields = GetLogs.generateComFields(lList, locList, companyList, aList, tList, pList, prodList,time);

            json.put("cm",comFields);

            JSONArray eventsArray = new JSONArray();

            // 传感器数据日志
            // 水质情况日志生成
            eventsArray.add(generateWater());

            // 土壤营养数据
            JSONObject soilInfo = generateSoilInfo();
            eventsArray.add(soilInfo);

            // 大棚空中温湿度等监测
            eventsArray.add(generateAirInfo());

            // 大棚土壤湿度、ph值生成
            eventsArray.add(generateSoilDamp());
            json.put("dat", eventsArray);
            json.put("createTime", time+"");

            //System.out.println(buffer.toString() + json.toJSONString());
            //控制台打印
            logger.info(buffer.toString() + json.toJSONString());

            // 延迟
            try {
                //每60秒获取一次数据
                loop_len=(loop_len-60>0)?(loop_len-60):0;
                if(loop_len<=0){
                    break;
                }else {
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    //修改log日志的文件名
    public static void SetLogFileName(String path,String filename){
        DailyRollingFileAppender appender = (DailyRollingFileAppender) Logger.getRootLogger().getAppender("file");
        appender.setFile( path+"app-"+filename+".log");//动态地修改这个文件名
        appender.activateOptions();
    }

}
