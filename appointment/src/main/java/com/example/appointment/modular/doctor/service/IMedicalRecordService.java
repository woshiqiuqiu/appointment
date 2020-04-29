package com.example.appointment.modular.doctor.service;

import com.example.appointment.modular.doctor.entity.MedicalRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-17
 */
public interface IMedicalRecordService extends IService<MedicalRecord> {

    List<MedicalRecord> selectMed();
}
