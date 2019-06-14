package com.qf.v12_web.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.qf.v12.jopo.ResultBean;
import com.qf.v12.jopo.ResultInfo;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("file")
public class FileController {
    @Autowired
    private FastFileStorageClient client;
    @Value("${image.head}")
    private String head;//http://192.168.220.128/

    @PostMapping("upload")
    @ResponseBody
    public ResultBean upload(@RequestParam(name = "file") MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String fileName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            StorePath storePath = client.uploadFile(file.getInputStream(), file.getSize(), fileName, null);
            String fullPath = storePath.getFullPath();
            String path = new StringBuilder(head).append(fullPath).toString();
            ResultBean resultBean = new ResultBean(200, path);
            return resultBean;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultBean(404, "网络不稳定，请重新上传");
    }

    @PostMapping("uploadW")
    @ResponseBody
    public ResultInfo uploadW(@RequestParam(name = "files") MultipartFile[] files) {
        ResultInfo r = new ResultInfo();
        List<String> list = null;
        for (MultipartFile file : files) {
            if (list == null) {
                list = new ArrayList<>();
            }
            String originalFilename = file.getOriginalFilename();
            String fileName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            StorePath storePath = null;
            try {
                storePath = client.uploadFile(file.getInputStream(), file.getSize(), fileName, null);
            } catch (IOException e) {
                e.printStackTrace();
                r.setErrno(1);
            }
            String fullPath = storePath.getFullPath();
            String path = new StringBuilder(head).append(fullPath).toString();
            list.add(path);
        }
        if (list != null) {
            r.setErrno(0);
            r.setData(list);
        } else {
            r.setErrno(1);
        }
        return r;
    }
}
