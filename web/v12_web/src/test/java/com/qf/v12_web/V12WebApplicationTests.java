package com.qf.v12_web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.qf.entity.TProduct;
import com.qf.v12.api.IProductService;
import com.qf.v12.entity.TProductVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class V12WebApplicationTests {
    @Reference
    private IProductService service;

    @Test
    public void contextLoads() {
        List<Long> list = new ArrayList<>();
        list.add(1l);
        list.add(2l);
        list.add(3l);
        System.out.println(service.bathDel(list));
    }

    @Autowired
    private FastFileStorageClient cli;

    @Test
    public void upload() throws FileNotFoundException {
        //图片放在项目，右键图片copy path
        File file = new File("H:\\Java\\MyDemoZhang\\IdeaWeb\\v12\\web\\小法拉利.jpg");
        FileInputStream in = new FileInputStream(file);
        StorePath sp = cli.uploadFile(in, file.length(), "jpg", null);
        String fullPath = sp.getFullPath();
        System.out.println(fullPath);//group1/M00/00/00/wKjcgF0CK7eAV2psAAGfjTGkiek878.jpg
        System.out.println(sp.getPath());//M00/00/00/wKjcgF0CK7eAV2psAAGfjTGkiek878.jpg
    }

    @Test
    public void delUpload() {
        cli.deleteFile("group1/M00/00/00/wKjcgF0CK7eAV2psAAGfjTGkiek878.jpg");
        System.out.println("del sucessfully");
    }

}
