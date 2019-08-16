/**
 * Copyright (C), 2019
 * FileName: uploadFast
 * Author:   zhangjian
 * Date:     2019/8/9 19:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.springboottest.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;

@RestController
public class uploadFast {
    @Autowired
    private FastFileStorageClient storageClient;

    @GetMapping("file/uploadFast")
    public void uploadFast(HttpServletRequest request) throws Exception {
        File file = new File("D:\\Downloads\\saber.jpeg");
        // 上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "png", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());

    }
}
