package com.example.appointment.modular.patient.service;

import com.example.appointment.modular.patient.entity.Appointment;
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
public interface IAppointmentService extends IService<Appointment> {

    List<Appointment> selectAppointment();
}
