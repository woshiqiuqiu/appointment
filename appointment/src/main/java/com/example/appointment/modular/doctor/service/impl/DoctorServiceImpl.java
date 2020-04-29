package com.example.appointment.modular.doctor.service.impl;

import com.example.appointment.modular.doctor.entity.Doctor;
import com.example.appointment.modular.doctor.dao.DoctorMapper;
import com.example.appointment.modular.doctor.service.IDoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {

//    @Override
//    public List<Doctor> selectDocInfo() {
//        return baseMapper.selectDocInfo();
//    }

    @Override
    public List<Doctor> selectDocInfo(String department_name, String doctor_name) {
        return baseMapper.selectDocInfo(department_name,doctor_name);
    }
}
