package com.example.appointment.modular.file.service;

import com.example.appointment.modular.file.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
public interface IFileService extends IService<File> {

    /**
     * 上传文件
     * @param md5
     * @param file
     */
    void upload(String name,String md5,MultipartFile file) throws IOException;

    /**
     * 分块上传文件
     * @param md5
     * @param size
     * @param chunks
     * @param chunk
     * @param file
     * @throws IOException
     */
    void uploadWithBlock(String name, String md5, Long size, Integer chunks, Integer chunk, MultipartFile file) throws IOException;

    /**
     * 检查Md5判断文件是否已上传
     * true:  未上传
     * false: 已上传
     * @param md5
     * @return
     */
    boolean checkMd5(String md5);
}
