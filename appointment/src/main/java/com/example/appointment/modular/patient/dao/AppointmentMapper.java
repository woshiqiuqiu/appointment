package com.example.appointment.modular.patient.dao;

import com.example.appointment.modular.patient.entity.Appointment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AutoGenerator
 * @since 2020-04-01
 */
public interface AppointmentMapper extends BaseMapper<Appointment> {

    List<Appointment> selectAppointment();
}
