package com.example.appointment.modular.file.service.impl;

import com.example.appointment.config.UploadConfig;
import com.example.appointment.modular.file.entity.File;
import com.example.appointment.modular.file.dao.FileMapper;
import com.example.appointment.modular.file.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.appointment.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

import static com.example.appointment.utils.FileUtils.generateFileName;
import static com.example.appointment.utils.UploadUtils.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Override
    public void upload(String name, String md5, MultipartFile file) throws IOException {
        String path = UploadConfig.path + generateFileName();
        FileUtils.write(path, file.getInputStream());
        baseMapper.save(new File(name, md5, path, new Date(), FileUtils.getExt(file)));
    }

    @Override
    public void uploadWithBlock(String name, String md5, Long size, Integer chunks, Integer chunk, MultipartFile file) throws IOException {
        String fileName = getFileName(md5, chunks);
        FileUtils.writeWithBlok(UploadConfig.path + fileName, size, file.getInputStream(), file.getSize(), chunks, chunk);
        addChunk(md5,chunk);
        if (isUploaded(md5)) {
            removeKey(md5);
            baseMapper.save(new File(name, md5,UploadConfig.path + fileName, new Date(), FileUtils.getExt(file)));
        }
    }

    @Override
    public boolean checkMd5(String md5) {
        File file = new File();
        file.setMd5(md5);
        return baseMapper.getByFile(file) == null;
    }
}
