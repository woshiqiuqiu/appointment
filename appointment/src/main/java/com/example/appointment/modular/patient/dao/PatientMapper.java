package com.example.appointment.modular.patient.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.appointment.modular.patient.entity.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 患者操作
 * @author wangkun
 * @since 2020-03-26
 */
public interface PatientMapper extends BaseMapper<Patient> {

    List<Patient> selectPatById(@Param("name")String name);

    List<Patient> getPatientInfo(@Param("name")String name);
}
