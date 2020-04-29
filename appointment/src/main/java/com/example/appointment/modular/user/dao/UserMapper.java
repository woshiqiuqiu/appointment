package com.example.appointment.modular.user.dao;

import com.example.appointment.modular.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface UserMapper extends BaseMapper<User> {

    List<User> selectUser(@Param("name")String name,@Param("password")String password);
}
