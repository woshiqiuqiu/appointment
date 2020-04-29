package com.example.appointment.modular.doctor.service.impl;

import com.example.appointment.modular.doctor.entity.MedicalRecord;
import com.example.appointment.modular.doctor.dao.MedicalRecordMapper;
import com.example.appointment.modular.doctor.service.IMedicalRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-17
 */
@Service
public class MedicalRecordServiceImpl extends ServiceImpl<MedicalRecordMapper, MedicalRecord> implements IMedicalRecordService {

    @Override
    public List<MedicalRecord> selectMed() {
        return baseMapper.selectMed();
    }
}
