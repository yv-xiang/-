package com.offcn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class hbaseTest {
    Configuration configuration = null;
    @Before
    public void getConfiguration(){
        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "hadoop001,hadoop002,hadoop003");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");

    }
    //判断表是否存在
    @Test
    public void tableExists() throws IOException {

        Connection connection = ConnectionFactory.createConnection(configuration);
        Admin admin = connection.getAdmin();
        boolean tableExists = admin.tableExists(TableName.valueOf("student"));
        if (tableExists) {
            System.out.println("存在表吗：" + tableExists);
        }
        admin.close();
    }

    //创建表
    @Test
    public void tableCreate() throws IOException {
        Connection connection = ConnectionFactory.createConnection(configuration);
        Admin admin = connection.getAdmin();
        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf("student2"));

        HColumnDescriptor descriptor = new HColumnDescriptor("info");
        tableDescriptor.addFamily(descriptor);
        admin.createTable(tableDescriptor);
        System.out.println("创建表成功");
        admin.close();

    }
    //删除表
    @Test
    public void tableDrop() throws IOException {
        Connection connection = ConnectionFactory.createConnection(configuration);
        Admin admin = connection.getAdmin();
        admin.disableTable(TableName.valueOf("student2"));
        admin.deleteTable(TableName.valueOf("student2"));
        System.out.println("表删除成功");
        admin.close();
    }
    //向表中插入数据
    @Test
    public void dataPut() throws IOException {
        Connection connection = ConnectionFactory.createConnection(configuration);
        Table table = connection.getTable(TableName.valueOf("student2"));
        Put put = new Put(Bytes.toBytes("1001"));
        put.addColumn(Bytes.toBytes("info"),Bytes.toBytes("name"),Bytes.toBytes("zhangshan"));
        table.put(put);
        System.out.println("添加成功");
        table.close();
    }
@Test
    //添加多行数据
    public void datasPut() throws IOException {
        Connection connection = ConnectionFactory.createConnection(configuration);
        Table table = connection.getTable(TableName.valueOf("student2"));
        List<Put> puts = new ArrayList<Put>();
        Put put = new Put(Bytes.toBytes("1004"));
         put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes("18"));
        Put put2 = new Put(Bytes.toBytes("1004"));
        put2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("lisi"));
        puts.add(put);
        puts.add(put2);
        table.put(puts);
        System.out.println("添加数据成功");
        table.close();
    }
    //删除一行
    @Test
    public void datadelete() throws IOException {
        Connection connection = ConnectionFactory.createConnection(configuration);
        Table table = connection.getTable(TableName.valueOf("student2"));
        Delete delete = new Delete(Bytes.toBytes("1001"));
        delete.addColumn(Bytes.toBytes("info"),Bytes.toBytes("name"));
        table.delete(delete);
        System.out.println("删除数据成功");
        table.close();

    }
    //删除多行
    @Test
    public void datasdelete() throws IOException {
        //获取客户端对象
        Connection connection = ConnectionFactory.createConnection(configuration);
        Table table = connection.getTable(TableName.valueOf("student2"));

        Delete delete = new Delete(Bytes.toBytes("1001"));
        delete.addFamily(Bytes.toBytes("info"));
        table.delete(delete);
        System.out.println("删除成功");
        table.close();

    }
    //删除多行
    @Test
    public void delet() throws IOException {
        Connection connection = ConnectionFactory.createConnection(configuration);
        Table table = connection.getTable(TableName.valueOf("student2"));
        Delete delete = new Delete(Bytes.toBytes("1001"));
        delete.addColumn(Bytes.toBytes("info"),Bytes.toBytes("age"));
        Delete delete1 = new Delete(Bytes.toBytes("1002"));
        delete1.addColumn(Bytes.toBytes("info"),Bytes.toBytes("name"));
        List<Delete> deletes = new ArrayList<Delete>();
        deletes.add(delete);
        deletes.add(delete1);
        table.delete(deletes);
        System.out.println("删除成功");
        table.close();


    }
    //获取所有数据
    public void dataScan() throws IOException {
        Connection connection = ConnectionFactory.createConnection(configuration);
        Table table = connection.getTable(TableName.valueOf("student2"));
        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);
        for (Result result : scanner) {
            //获取到的数据包含列名和列值
            Cell[] cells = result.rawCells();
            for (Cell cell : cells) {
                String rowkey = Bytes.toString(CellUtil.cloneRow(cell));
            }
        }

    }

}