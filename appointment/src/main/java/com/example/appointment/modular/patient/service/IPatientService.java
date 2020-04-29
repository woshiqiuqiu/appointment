package com.example.appointment.modular.patient.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.appointment.modular.patient.entity.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 患者操作
 * @author wangkun
 * @since 2020-03-26
 */
public interface IPatientService extends IService<Patient> {

    List<Patient> selectPatById(String name);

    List<Patient> getPatientInfo(String name);
}
