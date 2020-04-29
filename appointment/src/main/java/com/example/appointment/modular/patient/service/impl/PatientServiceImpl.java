package com.example.appointment.modular.patient.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.appointment.modular.patient.dao.PatientMapper;
import com.example.appointment.modular.patient.entity.Patient;
import com.example.appointment.modular.patient.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 患者操作
 * @author wangkun
 * @since 2020-03-26
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements IPatientService {

    @Override
    public List<Patient> selectPatById(String name) {
        return baseMapper.selectPatById(name);
    }

    @Override
    public List<Patient> getPatientInfo(String name) {
        return baseMapper.getPatientInfo(name);
    }
}
