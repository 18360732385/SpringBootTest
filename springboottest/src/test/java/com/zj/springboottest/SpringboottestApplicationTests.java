package com.zj.springboottest;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringboottestApplicationTests {


    @Autowired
    private FastFileStorageClient storageClient;


    @Test
    public void testUpload() throws FileNotFoundException {
        File file = new File("D:\\Downloads\\saber.jpeg");
        // 上传并且生成缩略图
        StorePath storePath = storageClient.uploadFile(
                new FileInputStream(file), file.length(), "png", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
    }

    @Test
    public void testUploadAndCreateThumb() throws FileNotFoundException {
        //删除文件
        storageClient.deleteFile("group1/M00/00/00/wKgCAl1NdvSAdgtqAAPunpGIcfw630.png");
        System.out.println("删除结果：" +"删除成功"+"删除失败");
    }


}
