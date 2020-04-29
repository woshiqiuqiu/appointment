package com.example.appointment.modular.doctor.dao;

import com.example.appointment.modular.doctor.entity.MedicalRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-17
 */
public interface MedicalRecordMapper extends BaseMapper<MedicalRecord> {

    List<MedicalRecord> selectMed();
}
