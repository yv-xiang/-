package com.offcn.spring;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Beanzhu {

    private Object[] arr;
    private List list;
    private Map map;
    private Properties prop;

    public Beanzhu() {
    }

    public Beanzhu(Object[] arr) {
        this.arr = arr;
    }

    public Beanzhu(List list) {
        this.list = list;
    }

    public Beanzhu(Map map) {
        this.map = map;
    }

    public Beanzhu(Properties prop) {
        this.prop = prop;
    }

    public Beanzhu(Object[] arr, List list, Map map, Properties prop) {
        this.arr = arr;
        this.list = list;
        this.map = map;
        this.prop = prop;
    }

    public Object[] getArr() {
        return arr;
    }

    public void setArr(Object[] arr) {
        this.arr = arr;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", map=" + map +
                ", prop=" + prop +
                '}';
    }
}
