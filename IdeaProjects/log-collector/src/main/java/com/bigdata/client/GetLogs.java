package com.bigdata.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bigdata.bean.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

public class GetLogs {
    private static Random rand = new Random();
    // 设备id
    private static int did = 0;
    /**
     * 启动日志
     * @param lList
     * @param locList
     * @param companyList
     * @param aList
     * @param tList
     * @param pList
     * @param prodList
     * @param time
     */
    protected static SensorStart generateStart(List<String> lList, List<String> locList,
                                               List<String> companyList, List<String> aList,
                                               List<String> tList, List<String> pList, List<String> prodList, Timestamp time) {

        SensorStart start = new SensorStart();

        //设备id
        //start.setDid(did+"");
        //did++;
        start.setDid(rand.nextInt(100)+"");
        // 用户id
        start.setUid(rand.nextInt(100) + "");

        // 传感器所属大棚编号
        start.setNum(rand.nextInt(100) + "");
        //传感器所属大棚面积
        start.setArea(rand.nextInt(100) + "");

        // 程序版本号 5,6等
        start.setVc("" + rand.nextInt(20));

        //传感器型号
        start.setTy("S" + rand.nextInt(10) + "" + rand.nextInt(10)+ "" + rand.nextInt(10));

        //    语言  cn,en,jp
        int flag = rand.nextInt(lList.size());
        start.setL(lList.get(flag));

        //    传感器安装位置
        int flag2 = rand.nextInt(locList.size());
        start.setLo(locList.get(flag2));

        //  传感器厂商
        int flag3 = rand.nextInt(companyList.size());
        start.setCmpy(companyList.get(flag3));

        // 区域
        start.setAr("CN");
        // 地址
        int flag4 = rand.nextInt(aList.size());
        start.setAddr(aList.get(flag4));
        // 传输方式
        int flag5 = rand.nextInt(tList.size());
        start.setTr(tList.get(flag5));
        //传输距离
        start.setDis(50+rand.nextInt(200)+"米");
        //供电方式
        int flag6 = rand.nextInt(pList.size());
        start.setPw(pList.get(flag6));
        //  传感器数据的报送时间
        start.setT(time+"");
        //  传感器的启动时间(时间早于报送时间)
        int minSec = rand.nextInt(600);
        start.setSt(Timestamp.from(time.toInstant().minusSeconds(minSec))+"");
        // 大棚种植的作物名称
        int flag7 = rand.nextInt(pList.size());
        start.setProd(prodList.get(flag7));

        //总运行时间
        start.setTotal(rand.nextInt(10000)+"");
        start.setExtend("");
        //设置日志类型
        start.setDatty("start");

        return start;
    }

    /**
     * 生成公共字段
     * @return
     * @param lList
     * @param locList
     * @param companyList
     * @param aList
     * @param tList
     * @param pList
     * @param prodList
     */
    protected static JSONObject generateComFields(List<String> lList, List<String> locList,
                                                  List<String> companyList, List<String> aList,
                                                  List<String> tList, List<String> pList, List<String> prodList,Timestamp time) {
        SensorBase base = new SensorBase();

        //设备id
        base.setDid(rand.nextInt(100)+"");
        // 用户id
        base.setUid(rand.nextInt(100) + "");

        // 传感器所属大棚编号
        base.setNum(rand.nextInt(100) + "");
        //传感器所属大棚面积
        base.setArea(rand.nextInt(100) + "");

        // 程序版本号 5,6等
        base.setVc("" + rand.nextInt(20));

        //传感器型号
        base.setTy("S" + rand.nextInt(10) + "" + rand.nextInt(10)+ "" + rand.nextInt(10));

        //    语言  cn,en,jp
        int flag = rand.nextInt(lList.size());
        base.setL(lList.get(flag));

        //    传感器安装位置
        int flag2 = rand.nextInt(locList.size());
        base.setLo(locList.get(flag2));

        //  传感器厂商
        int flag3 = rand.nextInt(companyList.size());
        base.setCmpy(companyList.get(flag3));

        // 区域
        base.setAr("CN");
        // 地址
        int flag4 = rand.nextInt(aList.size());
        base.setAddr(aList.get(flag4));
        // 传输方式
        int flag5 = rand.nextInt(tList.size());
        base.setTr(tList.get(flag5));
        //传输距离
        base.setDis(50+rand.nextInt(200)+"米");
        //供电方式
        int flag6 = rand.nextInt(pList.size());
        base.setPw(pList.get(flag6));
        //  传感器数据的报送时间
        base.setT(time+"");
        //  传感器的启动时间
        base.setSt(time+"");
        // 大棚种植的作物名称
        int flag7 = rand.nextInt(prodList.size());
        base.setProd(prodList.get(flag7));

        return (JSONObject) JSON.toJSON(base);
    }

    /**
     * 水质情况生成
     * @return
     */
    protected static JSONObject generateWater() {
        WaterInfo waterInfo = new WaterInfo();
        waterInfo.setBod(rand.nextInt(100)+"");
        waterInfo.setCod(rand.nextInt(200)+"");
        waterInfo.setTss(rand.nextInt(150)+"");
        waterInfo.setLas(rand.nextInt(6)+"");
        waterInfo.setN(rand.nextInt(40)+"");
        waterInfo.setTemp(rand.nextInt(45)+"");
        waterInfo.setPh(4+rand.nextInt(4)+"");
        waterInfo.setSalt(rand.nextInt(1200)+"");
        waterInfo.setCl(rand.nextInt(300)+"");
        waterInfo.setS(rand.nextDouble()+rand.nextDouble()+"");
        waterInfo.setExtend("");
        JSONObject jsonObject = (JSONObject) JSON.toJSON(waterInfo);

        return packEventJson("water", jsonObject);
    }

    /**
     * 土壤营养情况生成
     * @return
     */
    protected static JSONObject generateSoilInfo() {
        SoilInfo soilInfo = new SoilInfo();
        soilInfo.setN(20+rand.nextInt(120)+"");
        soilInfo.setP(50+rand.nextInt(250)+"");
        soilInfo.setK(200+rand.nextInt(1100)+"");
        soilInfo.setMg(20+rand.nextInt(100)+"");
        soilInfo.setFe(10+rand.nextInt(80)+"");
        soilInfo.setZn(rand.nextInt(10)+"");
        soilInfo.setExtend("");
        soilInfo.setManure();

        JSONObject jsonObject = (JSONObject) JSON.toJSON(soilInfo);

        return packEventJson("soil", jsonObject);
    }

    /**
     * 温湿度监测
     * @return
     */
    protected static JSONObject generateAirInfo() {

        AirInfo airInfo = new AirInfo();
        airInfo.setIllu(20+rand.nextInt(30)+"");
        airInfo.setHum(40+rand.nextInt(60)+"");
        airInfo.setTemp(15+rand.nextInt(30)+"");
        airInfo.setCo2(2000+rand.nextInt(2000)+"");
        airInfo.setO2(15+rand.nextInt(20)+"");
        airInfo.setExtend("");

        JSONObject jsonObject = (JSONObject) JSON.toJSON(airInfo);

        return packEventJson("air", jsonObject);
    }

    /**
     * 土壤湿度、ph值监测
     * @return
     */
    protected static JSONObject generateSoilDamp() {

        SoilDamp soilDamp = new SoilDamp();
        soilDamp.setSoilsd(20+rand.nextInt(80)+"");
        soilDamp.setPh(4+rand.nextInt(5)+rand.nextFloat()+"");
        soilDamp.setExtend("");
        soilDamp.setIrrigate();

        JSONObject jsonObject = (JSONObject) JSON.toJSON(soilDamp);

        return packEventJson("soildamp", jsonObject);
    }


    protected static JSONObject packEventJson(String eventName, JSONObject jsonObject) {

        JSONObject eventJson = new JSONObject();

        eventJson.put("datti", (System.currentTimeMillis() - rand.nextInt(99999999)) + "");
        eventJson.put("datty", eventName);
        eventJson.put("kv", jsonObject);

        return eventJson;
    }


}
