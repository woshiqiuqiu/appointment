package com.example.appointment.modular.patient.service.impl;

import com.example.appointment.modular.patient.entity.Appointment;
import com.example.appointment.modular.patient.dao.AppointmentMapper;
import com.example.appointment.modular.patient.service.IAppointmentService;
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
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements IAppointmentService {

    @Override
    public List<Appointment> selectAppointment() {
        return baseMapper.selectAppointment();
    }
}
