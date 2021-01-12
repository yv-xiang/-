
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;


public class HdfsClient  {

    @Test
    public void tsetMkdir() throws Exception {

        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop001:9000"), configuration, "root");

        fs.mkdirs(new Path("/hadoop"));
        fs.close();
    }
    @Test
    public void testCopyFromLocal() throws Exception {

        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop001:9000"), configuration, "root");
        configuration.set("dfs.replication","2");
        fs.copyFromLocalFile(new Path("E:/hadoop-2.7.2.rar"),new Path("/"));
        fs.close();
    }
    @Test
    public void testCopyToLocal() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop001:9000"), configuration, "root");
        fileSystem.copyToLocalFile(false,new Path("/allfile.txt"),new Path("E:/allfile.txt"),true);

        fileSystem.close();
    }
    @Test
    public void testdelete() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop001:9000"), configuration, "root");
        fileSystem.delete(new Path("/allfile.txt"),true);//true 是否删除文件夹
        fileSystem.close();
    }
    @Test
    public void rename() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop001:9000"), configuration, "root");
        fileSystem.rename(new Path("/data/a/b/hello.txt"),new Path("/data/a/b/hello6.txt"));
        fileSystem.close();
    }
    @Test
    public void testListStatus() throws Exception {

        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop001:9000"), configuration, "root");
        FileStatus[] listStatus = fileSystem.listStatus(new Path("/"));
        for (FileStatus fileStatus:listStatus){
            if (fileStatus.isDirectory()){
                System.out.println("d :"+fileStatus.getPath().getName());
            }else if (fileStatus.isFile()){
                System.out.println("f:"+fileStatus.getPath().getName());
            }
        }
        fileSystem.close();
    }
    @Test
    public void testPut() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop001:9000"), configuration, "root");
        FileInputStream fileInputStream = new FileInputStream("E:/Tomcat 9.0/bin/bootstrap.jar");
        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("/binbootstrap.jar"));
        IOUtils.copyBytes(fileInputStream,fsDataOutputStream,configuration);
        IOUtils.closeStream(fileInputStream);
        IOUtils.closeStream(fsDataOutputStream);
        fileSystem.close();
    }
    @Test
    public void testGetFile() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop001:9000"), configuration, "root");
        FSDataInputStream fsDataInputStream = fileSystem.open(new Path("/binbootstrap.jar"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/binbootstrap11.jar"));
        IOUtils.copyBytes(fsDataInputStream,fileOutputStream,configuration);
        IOUtils.closeStream(fileOutputStream);
        IOUtils.closeStream(fsDataInputStream);
        fileSystem.close();
    }
    @Test
    public void testFileSeek1() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop001:9000"), configuration, "root");
        FSDataInputStream fsDataInputStream = fileSystem.open(new Path("/hadoop-2.7.2.rar"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/hadoop-2.7.2.rar.part1"));

        byte[] bytes = new byte[1024];
        for (int i = 0; i<1024*128;i++){
            fsDataInputStream.read(bytes);
            fileOutputStream.write(bytes);
        }
        IOUtils.closeStream(fsDataInputStream);
        IOUtils.closeStream(fsDataInputStream);
        fileSystem.close();
    }
    @Test
    public void testFileSeek2() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop001:9000"), configuration, "root");

        FSDataInputStream fsDataInputStream = fileSystem.open(new Path("/hadoop-2.7.2.rar"));
        fsDataInputStream.seek(1024*1024*128);
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/hadoop-2.7.2.rar.part2"));
        IOUtils.copyBytes(fsDataInputStream,fileOutputStream,configuration);
        IOUtils.closeStream(fsDataInputStream);
        IOUtils.closeStream(fileOutputStream);
        fileSystem.close();


    }
}
