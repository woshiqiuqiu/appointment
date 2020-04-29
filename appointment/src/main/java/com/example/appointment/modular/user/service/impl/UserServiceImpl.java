package com.example.appointment.modular.user.service.impl;

import com.example.appointment.modular.user.entity.User;
import com.example.appointment.modular.user.dao.UserMapper;
import com.example.appointment.modular.user.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<User> selectUser(String name, String password) {
        return baseMapper.selectUser(name,password);
    }
}
