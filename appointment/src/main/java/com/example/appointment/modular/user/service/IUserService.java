package com.example.appointment.modular.user.service;

import com.example.appointment.modular.user.entity.User;
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
public interface IUserService extends IService<User> {

    List<User> selectUser(String name,String password);
}
