package com.example.appointment.modular.doctor.service;

import com.example.appointment.modular.doctor.entity.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
public interface IDoctorService extends IService<Doctor> {

    List<Doctor> selectDocInfo(String department_name,String doctor_name);
}
