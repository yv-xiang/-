package com.bigdata.myzookeeper;


import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MyZooTestWithoutWathch {
    ZooKeeper client = null;
    @Before
    public void getClient() throws IOException {
        client = new ZooKeeper("hadoop001:2181,hadoop002:2181,hadoop003:2181",2000,null);
        System.out.println("--> this is getClient method:"+client);

    }
    //创建节点
@Test
    public void createNode() throws KeeperException, InterruptedException {
        String create = client.create("/eclipse", "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("创建节点"+create);
    }
    // 获取节点
    @Test
    public void getChildNode() throws KeeperException, InterruptedException {
        List<String> children = client.getChildren("/", null);
        for (String str : children){
            System.out.println("node:"+str);
        }
    }


}
