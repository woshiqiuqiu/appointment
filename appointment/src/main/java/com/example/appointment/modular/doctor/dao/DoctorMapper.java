package com.example.appointment.modular.doctor.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.appointment.modular.doctor.entity.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
public interface DoctorMapper extends BaseMapper<Doctor> {

    List<Doctor> selectDocInfo(@Param("department_name")String department_name,@Param("doctor_name")String doctor_name);

}
