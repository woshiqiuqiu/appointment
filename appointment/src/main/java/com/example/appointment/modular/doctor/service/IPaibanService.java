package com.example.appointment.modular.doctor.service;

import com.example.appointment.modular.doctor.entity.Paiban;
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
public interface IPaibanService extends IService<Paiban> {

    //1--7 的排班
    List<Paiban> one();
    List<Paiban> two();
    List<Paiban> three();
    List<Paiban> four();
    List<Paiban> five();
    List<Paiban> six();
    List<Paiban> seven();
}
