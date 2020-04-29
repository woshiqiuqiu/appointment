package com.example.appointment.modular.doctor.service.impl;

import com.example.appointment.modular.doctor.entity.Paiban;
import com.example.appointment.modular.doctor.dao.PaibanMapper;
import com.example.appointment.modular.doctor.service.IPaibanService;
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
public class PaibanServiceImpl extends ServiceImpl<PaibanMapper, Paiban> implements IPaibanService {

    @Override
    public List<Paiban> one() {
        return baseMapper.one();
    }

    @Override
    public List<Paiban> two() {
        return baseMapper.two();
    }

    @Override
    public List<Paiban> three() {
        return baseMapper.three();
    }

    @Override
    public List<Paiban> four() {
        return baseMapper.four();
    }

    @Override
    public List<Paiban> five() {
        return baseMapper.five();
    }

    @Override
    public List<Paiban> six() {
        return baseMapper.six();
    }

    @Override
    public List<Paiban> seven() {
        return baseMapper.seven();
    }
}
