package com.example.appointment.modular.department.service;

import com.example.appointment.modular.department.entity.Department;
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
public interface IDepartmentService extends IService<Department> {

    List<Department> selectDepById(String departmentName);
}
